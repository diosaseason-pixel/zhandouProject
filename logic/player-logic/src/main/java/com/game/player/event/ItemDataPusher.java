package com.game.player.event;

import com.game.cmd.SCmd;
import com.game.common.client.BroadcastHelp;
import com.game.common.event.ClientReadyEvent;
import com.game.player.manager.ItemObjectManager;
import com.game.screen.util.SceneObjectProtoUtil;
import com.game.storage.proto.PbPackageItemNtf;
import com.iohao.game.action.skeleton.eventbus.EventSubscribe;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ItemDataPusher {

    @Resource
    ItemObjectManager itemObjectManager;

    @EventSubscribe
    public void onClientReady(ClientReadyEvent event) {
        log.info("onClientReady userId:{} roleId:{}", event.getUserId(), event.getRoleId());

        // 加载玩家物品数据 到 itemObjectManager
        var storage = itemObjectManager.loadStorage(event.getRoleId());

        // 遍历物品数据并发送通知
        storage.forEach((itemType, itemList) -> {
            var notify = new PbPackageItemNtf();
            notify.parcelId = itemType;
            for (var item : itemList) {
                var property = SceneObjectProtoUtil.toProto(item);
                notify.itemList.add(property);
            }
            // 发送物品数据到客户端
            BroadcastHelp.broadcast(SCmd.STORAGE_ITEM, notify, event.getUserId());
        });

    }
}
