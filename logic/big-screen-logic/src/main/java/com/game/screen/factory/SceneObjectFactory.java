package com.game.screen.factory;

import com.game.ex.FlowContextEx;
import com.game.common.model.SceneObject;

/**
 * 场景对象工厂接口
 */
public interface SceneObjectFactory {
    
    /**
     * 创建场景对象
     * 
     * @param objId 对象ID
     * @param flowContext 流程上下文
     * @return 场景对象
     */
    SceneObject createObject(int objId, FlowContextEx flowContext);
}