package com.game.screen.region;

import com.game.cmd.Code;
import com.game.cmd.SCmd;
import com.game.common.execl.TableManager;
import com.game.comp.constant.PersonCompType;
import com.game.comp.execl.BoxCompomentTable;
import com.game.comp.execl.BoxRewardTable;
import com.game.comp.execl.ItemCompomentTable;
import com.game.comp.proto.PbAssembly;
import com.game.comp.proto.PbAssemblyFinishReq;
import com.game.comp.proto.PbAssemblyFinishResp;
import com.game.comp.proto.PbUpdateItemAssemblyListNtf;
import com.game.ex.FlowContextEx;
import com.game.kit.JsonKit;
import com.game.screen.manager.PlayerObjectManager;
import com.game.screen.service.PersonalCompService;
import com.game.storage.client.ItemExchange;
import com.game.storage.proto.PbInternalItem;
import com.game.storage.proto.PbInternalAddItemReq;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PersonalRegion {

    @Resource
    PlayerObjectManager playerObjectManager;

    @Resource
    PersonalCompService personalCompService;

    /**
     * 完成个人组件
     *
     * @param request     完成个人组件请求
     * @param flowContext 流程上下文
     * @return 完成个人组件响应
     */
    public PbAssemblyFinishResp finishPersonalComp(PbAssemblyFinishReq request, FlowContextEx flowContext) {
        log.info("完成个人组件请求: {}", request);

        // 判断组件类型
        switch (request.type) {
            case PersonCompType.ITEM:
                return handleItemComp(request, flowContext);
            case PersonCompType.CHEST:
                return handleBoxComp(request, flowContext);
            default:
                log.error("未知的组件类型: {}", request.type);
                var response = new PbAssemblyFinishResp();
                response.code = Code.CODE_PARAM_ERROR;
                return response;
        }
    }

    /**
     * 处理道具资源点类型组件
     */
    private PbAssemblyFinishResp handleItemComp(PbAssemblyFinishReq request, FlowContextEx flowContext) {
        long roleId = flowContext.getRoleId();

        // 1. 获取组件配置
        var table = TableManager.getTable(ItemCompomentTable.class).get(request.id);
        if (table == null) {
            log.error("完成个人组件请求失败，找不到道具资源点配置: {}", request);
            return createErrorResponse(Code.CODE_PARAM_ERROR);
        }

        // 2. 检查组件是否已完成
        if (personalCompService.isCompFinished(roleId, request.id, request.type)) {
            log.info("完成个人组件请求失败，组件已完成: roleId={}, compId={}", roleId, request.id);
            return createErrorResponse(Code.CODE_ERROR);
        }

        // 3. 检查角色是否在交互范围内
        int distance = playerObjectManager.getDistanceToPosition(roleId, table.getXpos(), table.getYpos());
        if (distance > table.getInteractDistance()) {
            log.info("完成个人组件请求失败，角色不在交互范围内: roleId={}, distance={}, interactDistance={}", roleId, distance, table.getInteractDistance());
            return createErrorResponse(Code.CODE_ERROR_POSITION);
        }

        // 4. 处理组件完成
        int groupId = table.getGroupId();
        if (groupId > 0) {
            // 分组组件完成
            return handleGroupItemComp(request, flowContext, roleId, table, groupId);
        } else {
            // 单个组件完成
            return handleSingleItemComp(request, flowContext, roleId, table);
        }
    }

    /**
     * 处理分组道具资源点组件完成
     */
    private PbAssemblyFinishResp handleGroupItemComp(PbAssemblyFinishReq request, FlowContextEx flowContext,
                                                     long roleId, ItemCompomentTable table, int groupId) {
        // 1. 初始化奖励请求
        var addItemReq = new PbInternalAddItemReq();
        addItemReq.msgId = SCmd.FINISH_PERSONAL_COMP;
        addItemReq.isShow = true;

        // 添加当前组件的奖励
        var reward = PbInternalItem.of(table.getReward());
        addItemReq.itemList.add(reward);

        // 2. 初始化通知
        var notify = new PbUpdateItemAssemblyListNtf();

        // 3. 完成当前组件
        if (!completeCompAndAddToNotify(roleId, request.id, request.type, notify)) {
            return createErrorResponse(Code.CODE_ERROR);
        }

        // 4. 完成同组其他组件并收集奖励
        var itemTableLoader = TableManager.getTable(ItemCompomentTable.class);
        var sameGroupComps = itemTableLoader.query(comp -> comp.getGroupId() == groupId && comp.getId() != request.id);

        for (var comp : sameGroupComps) {
            int compId = comp.getId();

            // 跳过已完成的组件
            if (personalCompService.isCompFinished(roleId, compId, request.type)) {
                continue;
            }

            // 完成组件并添加到通知列表
            if (personalCompService.finishComp(roleId, compId, request.type)) {
                addCompToNotify(compId, request.type, notify);
                log.info("同组组件完成: roleId={}, groupId={}, compId={}", roleId, groupId, compId);

                // 添加组件奖励
                var compReward = PbInternalItem.of(comp.getReward());
                addItemReq.itemList.add(compReward);
            }
        }

        // 5. 发放奖励
        if (!addItemReq.itemList.isEmpty()) {
            ItemExchange.addItem(addItemReq, flowContext);
            log.info("发放组件和同组组件奖励: roleId={}, groupId={}, 奖励数量={}", roleId, groupId, addItemReq.itemList.size());
        }

        // 6. 发送通知
        if (!notify.updateList.isEmpty()) {
            flowContext.broadcastMe(SCmd.UPDATE_ITEM_ASSEMBLY_LIST_NTF, notify);
        }

        // 7. 返回成功响应
        return createSuccessResponse(request);
    }

    /**
     * 处理单个道具资源点组件完成
     */
    private PbAssemblyFinishResp handleSingleItemComp(PbAssemblyFinishReq request, FlowContextEx flowContext,
                                                      long roleId, ItemCompomentTable table) {
        // 1. 完成组件
        if (!personalCompService.finishComp(roleId, request.id, request.type)) {
            return createErrorResponse(Code.CODE_ERROR);
        }

        // 2. 发放奖励
        var reward = PbInternalItem.of(table.getReward());
        var addItemReq = new PbInternalAddItemReq();
        addItemReq.msgId = SCmd.FINISH_PERSONAL_COMP;
        addItemReq.isShow = true;
        addItemReq.itemList.add(reward);
        ItemExchange.addItem(addItemReq, flowContext);

        log.info("完成单个组件请求成功: roleId={}, compId={}", roleId, request.id);

        // 3. 发送通知
        var notify = new PbUpdateItemAssemblyListNtf();
        addCompToNotify(request.id, request.type, notify);
        flowContext.broadcastMe(SCmd.UPDATE_ITEM_ASSEMBLY_LIST_NTF, notify);

        // 4. 返回成功响应
        return createSuccessResponse(request);
    }

    /**
     * 完成组件并添加到通知列表
     */
    private boolean completeCompAndAddToNotify(long roleId, int compId, int compType, PbUpdateItemAssemblyListNtf notify) {
        boolean result = personalCompService.finishComp(roleId, compId, compType);
        addCompToNotify(compId, compType, notify);
        return result;
    }

    /**
     * 添加组件到通知列表
     */
    private void addCompToNotify(int compId, int compType, PbUpdateItemAssemblyListNtf notify) {
        var assembly = new PbAssembly();
        assembly.id = compId;
        assembly.type = compType;
        notify.updateList.add(assembly);
    }

    /**
     * 创建错误响应
     */
    private PbAssemblyFinishResp createErrorResponse(int errorCode) {
        var response = new PbAssemblyFinishResp();
        response.code = errorCode;
        return response;
    }

    /**
     * 创建成功响应
     */
    private PbAssemblyFinishResp createSuccessResponse(PbAssemblyFinishReq request) {
        var response = new PbAssemblyFinishResp();
        response.id = request.id;
        response.type = request.type;
        response.param = request.param;
        response.code = Code.CODE_OK;
        return response;
    }

    /**
     * 处理宝箱类型组件
     */
    private PbAssemblyFinishResp handleBoxComp(PbAssemblyFinishReq request, FlowContextEx flowContext) {
        long roleId = flowContext.getRoleId();
        int boxId = request.param;
        if (boxId <= 0) {
            log.error("宝箱ID无效: {}", boxId);
            return createErrorResponse(Code.CODE_PARAM_ERROR);
        }

        // 1. 获取宝箱配置
        var table = TableManager.getTable(BoxCompomentTable.class).get(request.id);
        if (table == null) {
            log.error("完成宝箱组件请求失败，找不到宝箱配置: {}", request);
            return createErrorResponse(Code.CODE_PARAM_ERROR);
        }

        // 2. 检查宝箱是否已完成
        if (personalCompService.isCompFinished(roleId, request.id, request.type)) {
            log.info("完成宝箱组件请求失败，宝箱已完成: roleId={}, boxId={}", roleId, request.id);
            return createErrorResponse(Code.CODE_ERROR);
        }

        // 3. 检查角色是否在交互范围内
        int distance = playerObjectManager.getDistanceToPosition(roleId, table.getXpos(), table.getYpos());
        if (distance > table.getInteractDistance()) {
            log.info("完成宝箱组件请求失败，角色不在交互范围内: roleId={}, distance={}, interactDistance={}", roleId, distance, table.getInteractDistance());
            return createErrorResponse(Code.CODE_ERROR_POSITION);
        }

        // 4. 完成宝箱组件
        if (table.getUseTimes() == 1) {
            personalCompService.finishComp(roleId, request.id, request.type);
        }

        // 5. 发放宝箱奖励
        List<Integer> chooses = JsonKit.parseList(table.getButtonChoose(), Integer.class);
        if (chooses == null || chooses.isEmpty()) {
            log.error("宝箱奖励配置错误: {}", table.getButtonChoose());
            return createErrorResponse(Code.CODE_PARAM_ERROR);
        }

        if (!chooses.contains(boxId)) {
            log.error("宝箱奖励ID不在配置范围内: {}", boxId);
            return createErrorResponse(Code.CODE_PARAM_ERROR);
        }

        // 6. 获取奖励配置
        var reward = TableManager.getTable(BoxRewardTable.class).get(boxId);
        if (reward == null) {
            log.error("宝箱奖励配置错误: {}", boxId);
            return createErrorResponse(Code.CODE_PARAM_ERROR);
        }

        // 7. 发放奖励
        var reawardList = reward.getRewardItems();
        if (!reawardList.isEmpty()) {
            var addItemReq = new PbInternalAddItemReq();
            addItemReq.msgId = SCmd.FINISH_PERSONAL_COMP;
            addItemReq.isShow = true;

            for (var item : reawardList) {
                var rewardItem = PbInternalItem.of(item);
                addItemReq.itemList.add(rewardItem);
            }
            ItemExchange.addItem(addItemReq, flowContext);
        }

        // 8. 发送通知
        var assembly = new PbAssembly();
        assembly.id = request.id;
        assembly.type = request.type;
        flowContext.broadcastMe(SCmd.UPDATE_PERSONAL_COMP, assembly);

        // 9. 返回成功响应
        return createSuccessResponse(request);
    }
}
