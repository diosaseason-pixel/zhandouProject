package com.game.screen.util;

import com.game.common.proto.PbObjProperty;
import com.game.common.proto.PbPerProperty;
import com.game.common.model.SceneObject;
import com.game.common.model.SceneObject.AttrField;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 场景对象序列化工具类
 * 将 SceneObject 及其子类序列化为 PbObjProperty 对象
 */
@Slf4j
public class SceneObjectProtoUtil {

    // 使用ConcurrentHashMap缓存类的字段信息，提高反射性能
    private static final Map<Class<?>, List<FieldInfo>> CLASS_FIELDS_CACHE = new ConcurrentHashMap<>();

    // 用于缓存字段信息的内部类
    private record FieldInfo(Field field, AttrField attrField) {
        private FieldInfo(Field field, AttrField attrField) {
            this.field = field;
            this.attrField = attrField;
            this.field.setAccessible(true); // 预先设置为可访问
        }
    }

    /**
     * 将场景对象序列化为 PbObjProperty
     *
     * @param sceneObject 场景对象，可以是 SceneObject 或其子类
     * @return PbObjProperty 对象
     */
    public static PbObjProperty toProto(SceneObject sceneObject) {
        if (sceneObject == null) {
            return null;
        }

        PbObjProperty proto = new PbObjProperty();
        proto.setObjId(sceneObject.getObjId());
        proto.setObjType(sceneObject.getObjectType());

        // 获取缓存的字段信息
        List<FieldInfo> fieldInfos = getClassFields(sceneObject.getClass());

        // 预先分配列表大小，减少扩容操作
        proto.setObjProps(new ArrayList<>(fieldInfos.size()));

        // 批量处理字段
        for (FieldInfo fieldInfo : fieldInfos) {
            try {
                Object value = fieldInfo.field.get(sceneObject);
                if (value == null) {
                    continue;
                }

                PbPerProperty property = createProperty(fieldInfo.attrField, value);
                if (property != null) {
                    proto.addProperty(property);
                }
            } catch (IllegalAccessException e) {
                // 处理异常
                log.error("访问字段失败: {}", fieldInfo.field.getName(), e);
            }
        }
        return proto;
    }

    /**
     * 获取类的缓存字段信息，如果缓存中没有则创建并缓存
     */
    private static List<FieldInfo> getClassFields(Class<?> clazz) {
        return CLASS_FIELDS_CACHE.computeIfAbsent(clazz, key -> {
            List<FieldInfo> fieldInfos = new ArrayList<>();
            Set<Field> allFields = getAllFields(key);

            for (Field field : allFields) {
                AttrField attrField = field.getAnnotation(AttrField.class);
                if (attrField != null) {
                    fieldInfos.add(new FieldInfo(field, attrField));
                }
            }
            return fieldInfos;
        });
    }

    /**
     * 创建属性对象，使用优化后的方法减少对象创建
     */
    private static PbPerProperty createProperty(AttrField attrField, Object value) {
        if (attrField.isString()) {
            // 处理字符串类型的属性
            String strValue = (String) value;
            if (!strValue.isEmpty()) {
                return new PbPerProperty(attrField.value(), strValue);
            }
        } else {
            // 处理数值类型的属性
            if (value instanceof Integer intValue && intValue != 0) {
                return new PbPerProperty(attrField.value(), intValue.longValue());
            }
        }
        return null;
    }

    /**
     * 获取指定类及其所有父类中的所有字段
     *
     * @param clazz 要获取字段的类
     * @return 包含所有字段的集合
     */
    private static Set<Field> getAllFields(Class<?> clazz) {
        // 获取当前类的字段
        Set<Field> fields = new HashSet<>(Arrays.asList(clazz.getDeclaredFields()));

        // 获取父类的字段
        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null && !superClass.equals(Object.class)) {
            fields.addAll(getAllFields(superClass));
        }

        return fields;
    }

    /**
     * 清除字段缓存，通常在应用重启或配置更新时调用
     */
    public static void clearCache() {
        CLASS_FIELDS_CACHE.clear();
    }
}