package com.game.ex;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import com.iohao.game.action.skeleton.core.flow.UserAttachment;
import lombok.Data;

@Data
@ProtobufClass
public class AttachmentEx implements UserAttachment {
    /**
     * 用户ID
     */
    String userUUID;

    /**
     * 服务器ID
     */
    int serverId;

    /**
     * 角色ID
     */
    long roleId;


    /**
     * 场景对象Id
     */
    int objectId;

}
