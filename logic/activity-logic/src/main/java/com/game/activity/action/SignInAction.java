package com.game.activity.action;


import com.game.activity.execl.SignInTable;
import com.game.cmd.CCmd;
import com.game.cmd.Code;
import com.game.common.execl.TableManager;
import com.game.common.proto.PbBaseResp;
import com.game.common.proto.wrapper.UIntValue;
import com.game.ex.FlowContextEx;
import com.game.storage.client.ItemExchange;
import com.game.storage.proto.PbInternalItem;
import com.game.storage.proto.PbInternalAddItemReq;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ActionController(0)
public class SignInAction {

    /**
     * 签到
     */
    @ActionMethod(CCmd.SIGN_IN)
    public PbBaseResp signIn(UIntValue intValue, FlowContextEx flowContext) {
        log.info("签到 {}", intValue);

        var table = TableManager.getTable(SignInTable.class).get(intValue.value);
        if (table == null) {
            log.error("签到表不存在 {}", intValue.value);
            return PbBaseResp.error(Code.CODE_PARAM_ERROR);
        }

        // 添加物品到背包
        var rewards = table.getRewards()
                .stream()
                .map(PbInternalItem::of)
                .toList();

        var addItemReq = new PbInternalAddItemReq();
        addItemReq.msgId = CCmd.SIGN_IN;
        addItemReq.isShow = true;
        addItemReq.itemList.addAll(rewards);
        ItemExchange.addItem(addItemReq, flowContext);

        // 签到数据变更 SIGN_IN_NTF
        return PbBaseResp.ok();
    }

}
