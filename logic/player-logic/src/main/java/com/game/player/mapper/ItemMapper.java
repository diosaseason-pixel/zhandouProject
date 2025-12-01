package com.game.player.mapper;

import com.game.player.entity.ItemEntity;
import com.game.storage.proto.PbInternalItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ItemMapper {

    ItemMapper ME = Mappers.getMapper(ItemMapper.class);

    List<ItemEntity> convertList(List<PbInternalItem> item);

    ItemEntity convert(PbInternalItem item);

    List<PbInternalItem> convert(List<ItemEntity> itemEntity);

    PbInternalItem convert(ItemEntity itemEntity);

}
