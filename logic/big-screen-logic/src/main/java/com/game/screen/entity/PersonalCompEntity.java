package com.game.screen.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 个人组件实体
 * 用于存储玩家已完成的个人组件信息
 */
@Data
@Document(collection = "personal_comp_info")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonalCompEntity {

    /**
     * 玩家ID roleId
     */
    @Id
    private long id;

    /**
     * 已完成的组件ID集合
     * 按组件类型存储，key为组件类型，value为已完成的组件ID集合
     */
    private Map<Integer, Set<Integer>> finishedComps = new HashMap<>();
    
    /**
     * 其他类型的组件集合可以在这里添加
     * 例如: private Set<Integer> finishedQuestComps = new HashSet<>();
     */
    
    /**
     * 最后更新时间
     */
    private long updateTime;
} 