package com.game.player.action;

import com.game.player.service.StorageService;
import com.iohao.game.action.skeleton.annotation.ActionController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 玩家背包管理Action
 */
@Slf4j
@Component
@ActionController(0)
@AllArgsConstructor
public class StorageAction {

    private final StorageService storageService;
    
}