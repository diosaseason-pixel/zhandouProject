package com.game.screen.service;

import com.game.comp.constant.PersonCompType;
import com.game.kit.TimeKit;
import com.game.screen.entity.PersonalCompEntity;
import com.game.screen.repository.PersonalCompRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 个人组件服务
 */
@Slf4j
@Service
@AllArgsConstructor
public class PersonalCompService {

    private final PersonalCompRepository personalCompRepository;

    /**
     * 获取玩家个人组件信息
     *
     * @param roleId 角色ID
     * @return 个人组件实体
     */
    public PersonalCompEntity getPersonalComp(long roleId) {
        var optional = personalCompRepository.findById(roleId);
        return optional.orElseGet(() -> createPersonalComp(roleId));
    }

    /**
     * 创建玩家个人组件记录
     *
     * @param roleId 角色ID
     * @return 新创建的个人组件实体
     */
    public PersonalCompEntity createPersonalComp(long roleId) {
        PersonalCompEntity personalComp = new PersonalCompEntity();
        personalComp.setId(roleId);
        
        // 初始化空的Map
        Map<Integer, Set<Integer>> finishedComps = new HashMap<>();
        
        // 添加两个初始类型的空集合
        finishedComps.put(1, new HashSet<>());
        finishedComps.put(2, new HashSet<>());
        
        personalComp.setFinishedComps(finishedComps);
        personalComp.setUpdateTime(TimeKit.currentSecond());
        return personalCompRepository.save(personalComp);
    }

    /**
     * 检查组件是否已完成
     *
     * @param roleId 角色ID
     * @param compId 组件ID
     * @param compType 组件类型
     * @return 是否已完成
     */
    public boolean isCompFinished(long roleId, int compId, int compType) {
        PersonalCompEntity personalComp = getPersonalComp(roleId);
        
        // 获取指定类型的已完成组件集合
        Set<Integer> compSet = personalComp.getFinishedComps().get(compType);
        if (compSet == null) {
            return false;
        }
        
        return compSet.contains(compId);
    }

    /**
     * 完成组件
     *
     * @param roleId 角色ID
     * @param compId 组件ID
     * @param compType 组件类型
     * @return 是否成功完成（如果已经完成过则返回false）
     */
    public boolean finishComp(long roleId, int compId, int compType) {
        PersonalCompEntity personalComp = getPersonalComp(roleId);
        
        // 获取或创建指定类型的组件集合
        Set<Integer> compSet = personalComp.getFinishedComps().computeIfAbsent(compType, k -> new HashSet<>());
        
        // 添加组件ID到集合中
        boolean result = compSet.add(compId);
        
        if (result) {
            personalComp.setUpdateTime(TimeKit.currentSecond());
            personalCompRepository.save(personalComp);
            log.info("玩家完成组件: roleId={}, compId={}, compType={}", roleId, compId, compType);
        }
        
        return result;
    }

    /**
     * 获取指定类型的已完成组件ID列表
     *
     * @param roleId 角色ID
     * @param compType 组件类型
     * @return 已完成的组件ID集合
     */
    public Set<Integer> getFinishedCompIds(long roleId, int compType) {
        PersonalCompEntity personalComp = getPersonalComp(roleId);
        
        // 获取指定类型的已完成组件集合，如果不存在则返回空集合
        return personalComp.getFinishedComps().getOrDefault(compType, new HashSet<>());
    }
} 