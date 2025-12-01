package com.game.common.model;


import com.game.attr.Attr;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 服务器真实存在场景对象
 */
@Getter
@Setter
public class SceneObject {

    private int objId;

    @AttrField(Attr.Obj.ObjType)
    int objectType;

    @AttrField(Attr.Obj.SubObjType)
    int subObjType;

    @AttrField(value = Attr.Obj.DisplayName, isString = true)
    String displayName;

    @AttrField(Attr.Obj.NameColor)
    int nameColor;

    @AttrField(Attr.Obj.Status)
    int status;

    @AttrField(Attr.Obj.Appr)
    int appr;

    @AttrField(Attr.Obj.Action)
    int action;

    @AttrField(Attr.Obj.AppearEffect)
    int appearEffect;

    /**
     * 定义属性访问器注解，用于标记需要自动同步更新的属性
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface AttrField {
        /**
         * 属性键值
         */
        int value();

        /**
         * 是否为字符串类型
         */
        boolean isString() default false;
    }

    public SceneObject(int objId) {
        this.objId = objId;
    }


}
