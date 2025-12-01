package com.game.common.event;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientReadyEvent implements Serializable {
    long userId;
    long roleId;

    public ClientReadyEvent(long userId, long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
