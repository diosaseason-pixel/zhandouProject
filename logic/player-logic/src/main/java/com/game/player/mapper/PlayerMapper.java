package com.game.player.mapper;

import com.game.common.proto.PbLoginPlayer;
import com.game.player.entity.PlayerEntity;
import com.game.role.proto.PbInternalPlayer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlayerMapper {

    PlayerMapper ME = Mappers.getMapper(PlayerMapper.class);

    PbInternalPlayer convert(PlayerEntity player);

    PbLoginPlayer convertToLogin(PlayerEntity player);

    List<PbLoginPlayer> convertToLogin(List<PlayerEntity> player);

}
