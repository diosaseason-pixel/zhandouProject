package com.game.player.region;

import com.game.common.entity.PropEntity;
import com.game.common.service.SequenceGeneratorService;
import com.game.kit.TimeKit;
import com.game.player.entity.PlayerEntity;
import com.game.player.mapper.HeadMapper;
import com.game.player.service.PlayerService;
import com.game.role.proto.PbCreateRoleReq;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 创建角色的业务逻辑区域
 */
@Slf4j
@Component
@AllArgsConstructor
public class CreateRoleRegion {

    private final PlayerService playerService;
    private final SequenceGeneratorService sequenceGeneratorService;

    /**
     * 创建角色
     *
     * @param userId   用户ID
     * @param serverId 服务器ID
     * @param request  创建角色请求
     * @return 创建的玩家角色
     */
    public PlayerEntity createPlayer(long userId, int serverId, PbCreateRoleReq request) {
        // 创建新角色
        PlayerEntity player = new PlayerEntity();

        // 生成角色ID
        long roleId = sequenceGeneratorService.generateSequence(PlayerEntity.SEQUENCE_NAME) + serverId * 1000000L;
        player.setId(roleId);

        // 设置基本信息
        player.setUserId((int) userId);
        player.setServerId(serverId);
        player.setName(request.name);
        player.setSex(request.sex);
        player.setLevel(1);

        // 设置头像信息
        if (request.getHead() != null) {
            player.setHead(HeadMapper.ME.convert(request.head));
        }

        // 设置初始属性
        initBaseProp(player);
        initializePlayerAttributes(player);

        // 设置初始位置
        player.setMapCode("1000");      // 初始地图
        player.setPosX(92);
        player.setPosY(45);
        player.setDirectionX(0);
        player.setDirectionY(1);

        // 气运
        player.setDestiny(request.destinyArray);
        // 健康值
        player.setHealthy(100);


        // 设置时间
        long currentTime = TimeKit.currentSecond();
        player.setCreateTime(currentTime);
        player.setLastTime(currentTime);

        player.setDeleteTime(0);
        player.setUnfreezeAccountTime(0);
        player.setUnfreezeSpeechTime(0);
        player.setRoleRechargeCount(0);
        player.setVersion(1);

        // 保存角色
        PlayerEntity savedPlayer = playerService.savePlayer(player);
        log.info("创建角色成功, userId={}, serverId={}, roleId={}, name={}", userId, serverId, savedPlayer.getId(), savedPlayer.getName());

        return savedPlayer;
    }


    /**
     * 初始化玩家角色的属性
     *
     * @param player 玩家角色
     */
    private void initializePlayerAttributes(PlayerEntity player) {
        // 设置初始等级和经验
        player.setLevel(1);
        player.setExp(0);

        // 设置初始货币
        player.setDiamond(0);
        player.setBindDiamond(0);
        player.setCoin(1000); // 初始金币
        player.setBindCoin(0);
        player.setFairyCrystal(0);
        player.setPayCoin(0);

        // 设置初始战斗力
        player.setCombatValue(0);
    }

    private void initBaseProp(PlayerEntity player) {
        PropEntity baseProp = new PropEntity();
        // 初始灵根
        baseProp.setJinAtk(6);
        baseProp.setMuAtk(6);
        baseProp.setShuiAtk(6);
        baseProp.setHuoAtk(6);
        baseProp.setTuAtk(6);
        // 初始法术精通
        baseProp.setTechSword(6);
        baseProp.setTechKnife(6);
        baseProp.setTechHammer(6);
        baseProp.setTechSpear(6);
        baseProp.setTechBoxing(6);
        baseProp.setTechTally(6);
        baseProp.setTechShield(6);
        baseProp.setTechSeal(6);

        // 初始属性
        baseProp.setMpMax(100);       // 灵力
        baseProp.setMpReg(1);         // 灵力恢复

        baseProp.setCritDam(5000);    // 暴击伤害
        baseProp.setMoveSpeed(600);   // 移动速度

        player.setProp(baseProp);
    }
}