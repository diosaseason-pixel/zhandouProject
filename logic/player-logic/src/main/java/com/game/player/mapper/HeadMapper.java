package com.game.player.mapper;

import com.game.common.proto.PbHead;
import com.game.player.entity.HeadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HeadMapper {

    HeadMapper ME = Mappers.getMapper(HeadMapper.class);

    PbHead convert(HeadEntity head);

    HeadEntity convert(PbHead pbHead);
}
