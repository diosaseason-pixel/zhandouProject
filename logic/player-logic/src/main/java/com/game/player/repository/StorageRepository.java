package com.game.player.repository;

import com.game.player.entity.StorageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 玩家背包存储库
 */
@Repository
public interface StorageRepository extends CrudRepository<StorageEntity, Long> {
    

    
}