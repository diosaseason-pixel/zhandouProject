package com.game.screen.action;


import com.game.cmd.CCmd;
import com.game.comp.proto.PbAssemblyFinishReq;
import com.game.comp.proto.PbAssemblyFinishResp;
import com.game.comp.proto.PbAssemblyList;
import com.game.comp.proto.PbAssemblyListNtf;
import com.game.ex.FlowContextEx;
import com.game.screen.manager.PlayerObjectManager;
import com.game.screen.region.PersonalRegion;
import com.game.screen.service.PersonalCompService;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 个人组件
 */
@Slf4j
@Component
@ActionController(0)
public class PersonalCompAction {

    @Resource
    PlayerObjectManager playerObjectManager;

    @Resource
    PersonalCompService personalCompService;
    
    @Resource
    PersonalRegion personalRegion;

    /**
     * 个人组件信息请求
     * 获取已完成的个人组件
     */
    @ActionMethod(CCmd.PERSONAL_COMP_LIST)
    public PbAssemblyListNtf personalCompList(FlowContextEx flowContext) {
        long roleId = flowContext.getRoleId();
        log.info("获取个人组件列表请求: roleId={}", roleId);

        PbAssemblyListNtf response = new PbAssemblyListNtf();

        // 获取玩家的个人组件实体
        var personalComp = personalCompService.getPersonalComp(roleId);

        // 遍历所有类型的已完成组件
        for (var entry : personalComp.getFinishedComps().entrySet()) {
            int compType = entry.getKey();
            List<Integer> compIds = new ArrayList<>(entry.getValue());

            PbAssemblyList assemblyList = new PbAssemblyList();
            assemblyList.useFinish = true;
            assemblyList.type = compType;
            assemblyList.ids.addAll(compIds);
            response.list.add(assemblyList);
        }

        log.info("个人组件列表响应: roleId={}, size={}", roleId, response.list.size());
        return response;
    }

    /**
     * 完成个人组件请求
     */
    @ActionMethod(CCmd.FINISH_PERSONAL_COMP)
    public PbAssemblyFinishResp finishPersonalComp(PbAssemblyFinishReq request, FlowContextEx flowContext) {
        return personalRegion.finishPersonalComp(request, flowContext);
    }
}
