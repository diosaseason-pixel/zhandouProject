package com.game.player.entity;

import lombok.Data;
import java.util.List;

/**
 * 角色头部/外观信息实体类
 * 对应 .base.Head 协议结构
 */
@Data
public class HeadEntity {
    /** 发型 */
    private Integer hair;
    
    /** 身体类型 */
    private Integer body;
    
    /** 脸型 */
    private Integer faceShape;
    
    /** 眉毛 */
    private Integer eyeBrow;
    
    /** 眼睛 */
    private Integer eye;
    
    /** 鼻子 */
    private Integer nose;
    
    /** 嘴巴 */
    private Integer mouth;
    
    /** 面部装饰 */
    private Integer faceDecoration;
    
    /** 模型ID */
    private Integer modelId;
    
    /** 时装数组 */
    private List<Integer> fashionArr;
    
    /** 性别 */
    private Integer sex;
}