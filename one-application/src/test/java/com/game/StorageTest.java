package com.game;


import com.game.player.service.PlayerService;
import com.game.player.service.StorageService;
import com.game.storage.constant.ItemConstant;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class StorageTest {

    @Resource
    PlayerService playerService;

    @Resource
    StorageService storageService;

    private static long ROLE_ID = 5000073000010L;


    @Test
    public void testAddExp() {
        playerService.addExp(ROLE_ID, 2000000);
    }

    @Test
    public void testAddItem() {
//        ItemEntity item = new ItemEntity();
//        item.setItemIdx(60300);
//        item.setCount(1);
//        item.setBind(1);
//        storageService.addItemProp(ROLE_ID, item);

        storageService.reduceItem(ROLE_ID, 60300, 1, ItemConstant.StorageType.PACKAGE);
    }


}
