package com.game.player.mapper;

import com.game.player.entity.ItemEntity;
import com.game.storage.model.ItemObject;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.game.common.entity.PropEntity;
import com.game.attr.Attr;
import org.mapstruct.Mapping;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface ItemObjectMapper {

    ItemObjectMapper ME = Mappers.getMapper(ItemObjectMapper.class);

    /**
     * 将ItemEntity转换为ItemObject
     */
    // PropEntity {"BaseHp":33,"DcMin":2,"DcMax":3,"Ac":2} 转为 112:33,118:3,119:2,121:2
    @Mapping(target = "weaponProp", ignore = true)
    ItemObject convert(ItemEntity item);
    
    @AfterMapping
    default void afterConvert(ItemEntity item, @MappingTarget ItemObject itemObject) {
        if (item.getProp() != null) {
            PropEntity prop = item.getProp();
            StringBuilder sb = new StringBuilder();
            
            // 属性ID映射
            if (prop.getBaseHp() > 0) {
                sb.append(Attr.Battle.BaseHp).append(":").append(prop.getBaseHp()).append(",");
            }
            
            if (prop.getDcMax() > 0) {
                sb.append(Attr.Battle.DcMax).append(":").append(prop.getDcMax()).append(",");
            }
            
            if (prop.getDcMin() > 0) {
                sb.append(Attr.Battle.DcMin).append(":").append(prop.getDcMin()).append(",");
            }
            
            if (prop.getAc() > 0) {
                sb.append(Attr.Battle.Ac).append(":").append(prop.getAc()).append(",");
            }
            
            String propStr = sb.toString();
            // 移除末尾的逗号（如果有）
            if (propStr.endsWith(",")) {
                propStr = propStr.substring(0, propStr.length() - 1);
            }
            
            if (!propStr.isEmpty()) {
                itemObject.setWeaponProp(propStr);
            }
        }
    }
}
