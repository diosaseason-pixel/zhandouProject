package com.game.screen.factory;

import com.game.ex.FlowContextEx;
import com.game.common.model.SceneObject;
import com.game.screen.model.RoleObject;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 场景对象工厂管理器
 * 根据对象类型选择合适的工厂
 */
@Slf4j
@Component
public class SceneObjectFactoryRegistry {

    /**
     * 对象类型：角色
     */
    public static final int TYPE_ROLE = 1;

    /**
     * 对象类型：怪物
     */
    public static final int TYPE_MONSTER = 2;

    @Resource
    private RoleObjectFactory roleObjectFactory;

    @Resource
    private MonsterObjectFactory monsterObjectFactory;

    /**
     * 工厂映射表
     */
    private final Map<Integer, SceneObjectFactory> factoryMap = new HashMap<>();

    /**
     * 初始化工厂映射
     */
    @PostConstruct
    public void init() {
        // 注册各种工厂
        factoryMap.put(TYPE_ROLE, roleObjectFactory);
        factoryMap.put(TYPE_MONSTER, monsterObjectFactory);
    }

    /**
     * 根据类型创建场景对象
     *
     * @param type        对象类型
     * @param objId       对象ID
     * @param flowContext 流程上下文
     * @return 场景对象
     */
    public SceneObject createSceneObject(int type, int objId, FlowContextEx flowContext) {
        SceneObjectFactory factory = factoryMap.get(type);

        if (factory == null) {
            log.error("未找到对应类型的工厂，type={}", type);
            return null;
        }

        return factory.createObject(objId, flowContext);
    }

    /**
     * 创建角色对象
     *
     * @param objId       对象ID
     * @param flowContext 流程上下文
     * @return 角色对象
     */
    public RoleObject createRoleObject(int objId, FlowContextEx flowContext) {
        return (RoleObject) roleObjectFactory.createObject(objId, flowContext);
    }

    /**
     * 创建怪物对象
     *
     * @param objId       对象ID
     * @param flowContext 流程上下文
     * @return 怪物对象
     */
    public SceneObject createMonsterObject(int objId, FlowContextEx flowContext) {
        return monsterObjectFactory.createObject(objId, flowContext);
    }

    /**
     * 根据模板创建怪物对象
     *
     * @param objId      对象ID
     * @param templateId 模板ID
     * @return 怪物对象
     */
    public SceneObject createMonsterByTemplate(int objId, int templateId) {
        return monsterObjectFactory.createMonsterByTemplate(objId, templateId);
    }
}