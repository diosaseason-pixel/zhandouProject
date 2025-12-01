package com.game.ex;

import com.iohao.game.action.skeleton.core.BarMessageKit;
import com.iohao.game.action.skeleton.core.CmdInfo;
import com.iohao.game.action.skeleton.core.CmdKit;
import com.iohao.game.action.skeleton.core.flow.FlowContext;
import com.iohao.game.common.consts.CommonConst;

import java.util.Objects;

/**
 * 流程上下文扩展
 */
public class FlowContextEx extends FlowContext {
    AttachmentEx attachment;

    @Override
    @SuppressWarnings("unchecked")
    public AttachmentEx getAttachment() {
        if (Objects.isNull(attachment)) {
            this.attachment = this.getAttachment(AttachmentEx.class);
        }
        return this.attachment;
    }

    /**
     * 绑定用户 表示登录成功
     *
     * @param userId 用户id
     */
    public boolean bindUser(String userId) {
        this.getAttachment().setUserUUID(userId);
        return this.bindingUserId(10000);
    }

    /**
     * 设置服务器id
     */
    public void setServerId(int serverId) {
        this.getAttachment().setServerId(serverId);
        this.updateAttachment(this.getAttachment());
    }

    /**
     * 获取服务器id
     */
    public int getServerId() {
        return this.getAttachment().getServerId();
    }

    /**
     * 获取对象Id
     */
    public int getObjectId() {
        return this.getAttachment().getObjectId();
    }

    /**
     * 设置角色id
     */
    public void setRoleId(long roleId) {
        this.getAttachment().setRoleId(roleId);
        this.updateAttachment(this.getAttachment());
    }

    /**
     * 设置对象Id
     */
    public void setObjectId(int objectId) {
        this.getAttachment().setObjectId(objectId);
        this.updateAttachment(this.getAttachment());
    }

    /**
     * 获取角色id
     */
    public long getRoleId() {
        return this.getAttachment().getRoleId();
    }

    /**
     * 主动广播消息 给客户端
     */
    public void broadcastMe(int cmd, Object data) {
        this.broadcastMe(CmdInfo.of(0, cmd), data);
    }

    /**
     * 主动广播消息 给客户端
     */
    public void broadcastMe(int cmd) {
        var cmdInfo = CmdInfo.of(0, cmd);
        var message = BarMessageKit.createResponseMessage(cmdInfo);
        message.setData(CommonConst.emptyBytes);
        this.broadcastMe(message);
    }


}
