package com.game.screen.repository;

import com.game.screen.entity.PersonalCompEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 个人组件存储库
 */
@Repository
public interface PersonalCompRepository extends CrudRepository<PersonalCompEntity, Long> {
    
} 