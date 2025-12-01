package com.game.screen.factory;

import com.game.ex.FlowContextEx;
import com.game.screen.model.MonsterObject;
import com.game.common.model.SceneObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 怪物对象工厂
 * 专门负责创建怪物对象
 */
@Slf4j
@Component
public class MonsterObjectFactory implements SceneObjectFactory {

    @Override
    public SceneObject createObject(int objId, FlowContextEx flowContext) {
        return createMonsterObject(objId, flowContext);
    }

    /**
     * 创建怪物对象
     *
     * @param objId 对象ID
     * @param flowContext 流程上下文
     * @return 怪物对象
     */
    public MonsterObject createMonsterObject(int objId, FlowContextEx flowContext) {
        // 创建MonsterObject实例
        MonsterObject monsterObject = new MonsterObject(objId);
        
        // 设置怪物基本信息
        // 这里需要根据实际业务逻辑设置怪物的属性
        monsterObject.setMonsterIdx(0); // 设置怪物索引
        monsterObject.setGradeType(0);  // 设置等级类型
        monsterObject.setMonsterType(0); // 设置怪物类型
        monsterObject.setMonsterName("默认怪物"); // 设置怪物名称
        
        // 设置怪物的战斗属性
        monsterObject.setLevel(1); // 设置等级
        
        // 可以根据需要设置其他属性
        
        return monsterObject;
    }
    
    /**
     * 根据模板ID创建怪物对象
     * 
     * @param objId 对象ID
     * @param templateId 模板ID
     * @return 怪物对象
     */
    public MonsterObject createMonsterByTemplate(int objId, int templateId) {
        // 创建MonsterObject实例
        MonsterObject monsterObject = new MonsterObject(objId);
        
        // 根据模板ID从配置或数据库中获取怪物信息
        // 这里需要实现根据模板ID获取怪物配置的逻辑
        
        // 设置怪物属性
        monsterObject.setMonsterIdx(templateId);
        // 其他属性设置...
        
        return monsterObject;
    }
}