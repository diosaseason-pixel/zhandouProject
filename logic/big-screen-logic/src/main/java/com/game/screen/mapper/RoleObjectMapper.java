package com.game.screen.mapper;

import com.game.common.entity.PropEntity;
import com.game.common.proto.PbHead;
import com.game.role.proto.PbInternalPlayer;
import com.game.screen.model.RoleObject;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

/**
 * 角色对象映射器
 * 将PbSimplePlayer对象转换为RoleObject对象
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleObjectMapper {

    RoleObjectMapper ME = Mappers.getMapper(RoleObjectMapper.class);

    /**
     * 将PbSimplePlayer转换为RoleObject
     *
     * @param simplePlayer PbSimplePlayer对象
     * @param objId        对象ID
     * @return RoleObject对象
     */
    @Mapping(target = "playerID", source = "player.id")
    @Mapping(target = "createRoleTime", source = "player.createTime")
    @Mapping(target = "displayName", source = "player.name")
    @Mapping(target = "mapPosX", source = "player.posX")
    @Mapping(target = "mapPosY", source = "player.posY")
    @Mapping(target = "curExp", expression = "java(player.getExp().intValue())")
    @Mapping(target = "combatValue", expression = "java(player.getCombatValue().intValue())")
    @Mapping(target = "destiny", ignore = true)
    RoleObject toRoleObject(PbInternalPlayer player, int objId);

    @AfterMapping
    default void afterConvert(PbInternalPlayer player, @MappingTarget RoleObject roleObject) {
        if (player.destiny != null && !player.destiny.isEmpty()) {
            // 格式为 "1,2,4"
            StringBuilder destiny = new StringBuilder();
            for (Integer value : player.destiny) {
                destiny.append(value).append(",");
            }
            // 移除末尾的逗号（如果有）
            if (!destiny.isEmpty() && destiny.charAt(destiny.length() - 1) == ',') {
                destiny.deleteCharAt(destiny.length() - 1);
            }
            roleObject.setDestiny(destiny.toString());
        }

        // 处理prop属性，将属性从prop映射到roleObject
        if (player.getProp() != null) {
            setProp(player.getProp(), roleObject);
        }

        // 处理head属性，将外观从head映射到roleObject
        if (player.getHead() != null) {
            setHead(player.getHead(), roleObject);
        }
    }

    /**
     * 设置属性
     */
    void setProp(PropEntity propEntity, @MappingTarget RoleObject roleObject);

    /**
     * 设置外观
     */
    @Mapping(target = "hairId", source = "head.hair")
    @Mapping(target = "bodyId", source = "head.body")
    void setHead(PbHead head, @MappingTarget RoleObject roleObject);

}