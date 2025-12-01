package com.game.player.action.internal;

import com.game.common.proto.PbBaseResp;
import com.game.ex.FlowContextEx;
import com.game.player.mapper.ItemMapper;
import com.game.player.region.ItemRegion;
import com.game.player.service.StorageService;
import com.game.storage.cmd.ItemCmd;
import com.game.storage.constant.ItemConstant;
import com.game.storage.proto.PbInternalAddItemReq;
import com.game.storage.proto.PbInternalItemList;
import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ActionController(ItemCmd.cmd)
public class InternalItemAction {

    @Resource
    ItemRegion itemRegion;

    @Resource
    StorageService storageService;

    /**
     * 添加物品
     */
    @ActionMethod(ItemCmd.addPackageItem)
    public PbBaseResp addPackageItem(PbInternalAddItemReq req, FlowContextEx flowContext) {
        itemRegion.addItemAndNotify(flowContext, req);
        return PbBaseResp.ok();
    }


    /**
     * 获取已穿戴的法术
     */
    @ActionMethod(ItemCmd.getEquipWeapon)
    public PbInternalItemList getEquipWeapon(FlowContextEx flowContext) {
        var roleId = flowContext.getRoleId();
        var itemList = storageService.getStorageItems(roleId, ItemConstant.StorageType.WEAPONWEAR);
        return new PbInternalItemList(ItemMapper.ME.convert(itemList));
    }


}
