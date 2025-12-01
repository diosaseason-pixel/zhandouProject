package com.game.player.service;

import com.game.player.entity.PlayerEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PlayerService {
    final MongoTemplate mongoTemplate;

    /**
     * 通过userId 和 serverId 查询角色
     */
    public List<PlayerEntity> findPlayersByUserId(long userId, int serverId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId).and("serverId").is(serverId));
        return mongoTemplate.find(query, PlayerEntity.class);
    }

    /**
     * 通过玩家ID查询角色
     */
    public PlayerEntity findPlayerById(long playerId) {
        return mongoTemplate.findById(playerId, PlayerEntity.class);
    }

    /**
     * 保存玩家角色到数据库
     */
    public PlayerEntity savePlayer(PlayerEntity player) {
        return mongoTemplate.save(player);
    }

    /**
     * 检查角色名是否已存在
     * 使用缓存提高查询性能
     */
    @Cacheable(value = "playerNameCache", key = "#name", unless = "#result == false")
    public boolean isNameExists(String name) {
        log.info("检查角色名是否存在, name={}", name);
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.exists(query, PlayerEntity.class);
    }

    public void levelUp(long roleId, int level) {
        var player = findPlayerById(roleId);
        if (player == null) {
            return;
        }
        player.setLevel(player.getLevel() + level);
        this.savePlayer(player);
    }

    /**
     * 添加灵石
     */
    public long addCoin(long role, int count) {
        var player = findPlayerById(role);
        if (player == null) {
            return 0;
        }
        if (count <= 0) {
            return player.getCoin();
        }

        player.setCoin(player.getCoin() + count);
        this.savePlayer(player);
        return player.getCoin();
    }

    /**
     * 添加绑定仙玉
     */
    public long addFairyCrystal(long role, int count) {
        var player = findPlayerById(role);
        if (player == null) {
            return 0;
        }
        if (count <= 0) {
            return player.getFairyCrystal();
        }

        player.setFairyCrystal(player.getFairyCrystal() + count);
        this.savePlayer(player);
        return player.getFairyCrystal();
    }

    /**
     * 添加绑定仙玉
     */
    public long addPayCoin(long role, int count) {
        var player = findPlayerById(role);
        if (player == null) {
            return 0;
        }
        if (count <= 0) {
            return player.getPayCoin();
        }

        player.setPayCoin(player.getPayCoin() + count);
        this.savePlayer(player);
        return player.getPayCoin();
    }

    /**
     * 添加经验
     */
    public long addExp(long role, int count) {
        var player = findPlayerById(role);
        if (player == null) {
            return 0;
        }
        if (count <= 0) {
            return player.getExp();
        }

        player.setExp(player.getExp() + count);
        this.savePlayer(player);
        return player.getExp();
    }

    /**
     * 扣除灵石
     */
    public long reduceCoin(long role, int count) {
        var player = findPlayerById(role);
        if (player == null) {
            return 0;
        }

        if (count <= 0) {
            return player.getCoin();
        }

        // 灵石总数是否足够
        long totalCoin = player.getCoin() + player.getBindCoin();
        if (totalCoin < count) {
            return 0;
        }

        // 优先扣除绑定金币
        if (player.getBindCoin() >= count) {
            player.setBindCoin(player.getBindCoin() - count);
        } else {
            // 绑定金币不足，扣除部分绑定金币和部分普通金币
            long remainCoin = count - player.getBindCoin();
            player.setBindCoin(0);
            player.setCoin(player.getCoin() - remainCoin);
        }

        // 保存玩家数据
        this.savePlayer(player);
        return player.getCoin() + player.getBindCoin();
    }

    /**
     * 扣除仙玉
     */
    public long reduceFairyCrystal(long role, int count) {
        var player = findPlayerById(role);
        if (player == null) {
            return 0;
        }
        if (count <= 0) {
            return player.getFairyCrystal();
        }

        long totalCoin = player.getFairyCrystal() + player.getPayCoin();
        if (totalCoin < count) {
            return 0;
        }
        // 优先扣除绑定仙玉
        if (player.getFairyCrystal() >= count) {
            player.setFairyCrystal(player.getFairyCrystal() - count);
        } else {
            // 绑定金币不足，扣除部分绑定金币和部分普通金币
            long remainCoin = count - player.getFairyCrystal();
            player.setFairyCrystal(0);
            player.setPayCoin(player.getPayCoin() - remainCoin);
        }

        this.savePlayer(player);
        return player.getFairyCrystal() + player.getPayCoin();
    }

    /**
     * 扣除经验
     */
    public long reduceExp(long role, int count) {
        var player = findPlayerById(role);
        if (player == null) {
            return 0;
        }
        if (count <= 0) {
            return player.getExp();
        }
        // 经验总数是否足够
        if (player.getExp() < count) {
            return 0;
        }

        // 扣除经验
        player.setExp(player.getExp() - count);
        this.savePlayer(player);
        return player.getExp();
    }
}
