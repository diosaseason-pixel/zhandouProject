package com.game.player.entity;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * 玩家背包
 */
@Data
@Document(collection = "storage_info")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StorageEntity {

    /**
     * 玩家ID roleId
     */
    @Id
    private long id;

    /**
     * 道具列表
     * key: 包裹类型    StorageType
     * value: 道具列表
     */
    Map<Integer, List<ItemEntity>> itemList;
}
