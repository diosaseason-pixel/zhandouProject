package com.game.storage.client;


import com.game.common.proto.PbBaseResp;
import com.game.ex.FlowContextEx;
import com.game.storage.cmd.ItemCmd;
import com.game.storage.proto.PbInternalAddItemReq;
import com.game.storage.proto.PbInternalItem;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ItemExchange {

    /**
     * 添加物品
     */
    public PbBaseResp addItem(PbInternalAddItemReq items, FlowContextEx flowContext) {
        var cmd = ItemCmd.of(ItemCmd.addPackageItem);
        var message = flowContext.invokeModuleMessage(cmd, items);
        return message.getData(PbBaseResp.class);
    }

    /**
     * 获取已穿戴的装备
     */
    public List<PbInternalItem> getEquipWeapon(FlowContextEx flowContext) {
        var cmd = ItemCmd.of(ItemCmd.getEquipWeapon);
        var message = flowContext.invokeModuleMessage(cmd);
        return message.listValue(PbInternalItem.class);
    }


}
