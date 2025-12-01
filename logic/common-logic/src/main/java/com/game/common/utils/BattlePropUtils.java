package com.game.common.utils;

import com.game.common.entity.PropEntity;
import com.game.common.model.BattleObject;
import lombok.experimental.UtilityClass;

/**
 * 战斗属性工具类
 * 负责处理战斗对象的属性设置
 */
@UtilityClass
public class BattlePropUtils {

    /**
     * 将属性对象 加到 战斗对象上，方便计算角色总属性
     *
     * @param battle 战斗对象
     * @param prop 属性对象
     */
    public void addBattleProp(BattleObject battle, PropEntity prop) {
        // 生命相关属性
        battle.setHpMax(battle.getHpMax() + prop.getHpMax());
//        battleObject.setCurHp(prop.getCurHp() > 0 ? prop.getCurHp() : prop.getHpMax());
        battle.setBaseHp(battle.getBaseHp() + prop.getBaseHp());
        battle.setHpPct(battle.getHpPct() + prop.getHpPct());
        battle.setHpReg(battle.getHpReg() + prop.getHpReg());
        
        // 灵力相关属性
        battle.setMpMax(battle.getMpMax() + prop.getMpMax());
//        battleObject.setCurMp(prop.getCurMp() > 0 ? prop.getCurMp() : prop.getMpMax());
        battle.setMpReg(battle.getMpReg() + prop.getMpReg());
        
        // 攻击相关属性
        battle.setDcMax(battle.getDcMax() + prop.getDcMax());
        battle.setDcMin(battle.getDcMin() + prop.getDcMin());
        battle.setDcPct(battle.getDcPct() + prop.getDcPct());
        
        // 防御相关属性
        battle.setAc(battle.getAc() + prop.getAc());
        battle.setAcPct(battle.getAcPct() + prop.getAcPct());
        
        // 命中与闪避
        battle.setHit(battle.getHit() + prop.getHit());
        battle.setDodge(battle.getDodge() + prop.getDodge());
        
        // 会心与抗性
        battle.setLuckyStrike(battle.getLuckyStrike() + prop.getLuckyStrike());
        battle.setLuckyDef(battle.getLuckyDef() + prop.getLuckyDef());
        battle.setPureDef(battle.getPureDef() + prop.getPureDef());
        
        // 暴击相关
        battle.setCritRatio(battle.getCritRatio() + prop.getCritRatio());
        battle.setCritDam(battle.getCritDam() + prop.getCritDam());
        battle.setCritRatioDef(battle.getCritRatioDef() + prop.getCritRatioDef());
        battle.setCritDamDef(battle.getCritDamDef() + prop.getCritDamDef());
        
        // 灵根属性
        battle.setJinAtk(battle.getJinAtk() + prop.getJinAtk());
        battle.setMuAtk(battle.getMuAtk() + prop.getMuAtk());
        battle.setShuiAtk(battle.getShuiAtk() + prop.getShuiAtk());
        battle.setHuoAtk(battle.getHuoAtk() + prop.getHuoAtk());
        battle.setTuAtk(battle.getTuAtk() + prop.getTuAtk());
        battle.setEleDef(battle.getEleDef() + prop.getEleDef());

        // 法术精通
        battle.setTechSword(battle.getTechSword() + prop.getTechSword());
        battle.setTechKnife(battle.getTechKnife() + prop.getTechKnife());
        battle.setTechHammer(battle.getTechHammer() + prop.getTechHammer());
        battle.setTechSpear(battle.getTechSpear() + prop.getTechSpear());
        battle.setTechBoxing(battle.getTechBoxing() + prop.getTechBoxing());
        battle.setTechTally(battle.getTechTally() + prop.getTechTally());
        battle.setTechShield(battle.getTechShield() + prop.getTechShield());
        battle.setTechSeal(battle.getTechSeal() + prop.getTechSeal());

        // 伤害属性
        battle.setDamPct(battle.getDamPct() + prop.getDamPct());
        battle.setDamPctPeople(battle.getDamPctPeople() + prop.getDamPctPeople());
        battle.setDamPctElf(battle.getDamPctElf() + prop.getDamPctElf());
        battle.setDamPctEvil(battle.getDamPctEvil() + prop.getDamPctEvil());
        battle.setDamPctFariy(battle.getDamPctFariy() + prop.getDamPctFariy());
        battle.setDamPctSpirit(battle.getDamPctSpirit() + prop.getDamPctSpirit());
        battle.setDamPctSameSex(battle.getDamPctSameSex() + prop.getDamPctSameSex());
        battle.setDamPctDiffSex(battle.getDamPctDiffSex() + prop.getDamPctDiffSex());
        
        // 抗性属性
        battle.setDefPct(battle.getDefPct() + prop.getDefPct());
        battle.setDefPctPeople(battle.getDefPctPeople() + prop.getDefPctPeople());
        battle.setDefPctElf(battle.getDefPctElf() + prop.getDefPctElf());
        battle.setDefPctEvil(battle.getDefPctEvil() + prop.getDefPctEvil());
        battle.setDefPctFariy(battle.getDefPctFariy() + prop.getDefPctFariy());
        battle.setDefPctSpirit(battle.getDefPctSpirit() + prop.getDefPctSpirit());
        
        // 吸血与移动速度
        battle.setBloodLust(battle.getBloodLust() + prop.getBloodLust());
        battle.setBloodLustPct(battle.getBloodLustPct() + prop.getBloodLustPct());
        battle.setMoveSpeed(battle.getMoveSpeed() + prop.getMoveSpeed());
//        battleObject.setCurMoveSpeed(prop.getCurMoveSpeed() > 0 ? prop.getCurMoveSpeed() : prop.getMoveSpeed());
        battle.setMoveSpeedPct(battle.getMoveSpeedPct() + prop.getMoveSpeedPct());
        
        // 技能相关
        battle.setMagicSpeed(battle.getMagicSpeed() + prop.getMagicSpeed());
        battle.setHaste(battle.getHaste() + prop.getHaste());
        battle.setHastePct(battle.getHastePct() + prop.getHaste_Pct());
        
        // 其他战斗相关属性
        // battleObject.setSkillEyeStatus(battleObject.getSkillEyeStatus() + prop.getSkillEyeStatus());
        // battleObject.setSkillStep(battleObject.getSkillStep() + prop.getSkillStep());
        // battleObject.setSkillId(battleObject.getSkillId() + prop.getSkillId());

        // 新增属性
        battle.setApPct(battle.getApPct() + prop.getApPct());
        battle.setApRatio(battle.getApRatio() + prop.getApRatio());

        // 护盾
        battle.setShield(battle.getShield() + prop.getShield());

        // 五行属性伤害增加
        battle.setDamJin(battle.getDamJin() + prop.getDamJin());
        battle.setDamMu(battle.getDamMu() + prop.getDamMu());
        battle.setDamShui(battle.getDamShui() + prop.getDamShui());
        battle.setDamHuo(battle.getDamHuo() + prop.getDamHuo());
        battle.setDamTu(battle.getDamTu() + prop.getDamTu());

        // 五行属性伤害百分比增加
        battle.setDamPctJin(battle.getDamPctJin() + prop.getDamPctJin());
        battle.setDamPctMu(battle.getDamPctMu() + prop.getDamPctMu());
        battle.setDamPctShui(battle.getDamPctShui() + prop.getDamPctShui());
        battle.setDamPctHuo(battle.getDamPctHuo() + prop.getDamPctHuo());
        battle.setDamPctTu(battle.getDamPctTu() + prop.getDamPctTu());

        // 五行属性伤害减少
        battle.setDefJin(battle.getDefJin() + prop.getDefJin());
        battle.setDefMu(battle.getDefMu() + prop.getDefMu());
        battle.setDefShui(battle.getDefShui() + prop.getDefShui());
        battle.setDefHuo(battle.getDefHuo() + prop.getDefHuo());
        battle.setDefTu(battle.getDefTu() + prop.getDefTu());

        // 五行属性伤害百分比减少
        battle.setDefPctJin(battle.getDefPctJin() + prop.getDefPctJin());
        battle.setDefPctMu(battle.getDefPctMu() + prop.getDefPctMu());
        battle.setDefPctShui(battle.getDefPctShui() + prop.getDefPctShui());
        battle.setDefPctHuo(battle.getDefPctHuo() + prop.getDefPctHuo());
        battle.setDefPctTu(battle.getDefPctTu() + prop.getDefPctTu());

        // 治愈减免
        battle.setDefCure(battle.getDefCure() + prop.getDefCure());

        // 剑术相关
        battle.setDamSword(battle.getDamSword() + prop.getDamSword());
        battle.setDamPctSword(battle.getDamPctSword() + prop.getDamPctSword());
        battle.setDefSword(battle.getDefSword() + prop.getDefSword());
        battle.setDefPctSword(battle.getDefPctSword() + prop.getDefPctSword());

        // 刀法相关
        battle.setDamKnife(battle.getDamKnife() + prop.getDamKnife());
        battle.setDamPctKnife(battle.getDamPctKnife() + prop.getDamPctKnife());
        battle.setDefKnife(battle.getDefKnife() + prop.getDefKnife());
        battle.setDefPctKnife(battle.getDefPctKnife() + prop.getDefPctKnife());

        // 锤法相关
        battle.setDamHammer(battle.getDamHammer() + prop.getDamHammer());
        battle.setDamPctHammer(battle.getDamPctHammer() + prop.getDamPctHammer());
        battle.setDefHammer(battle.getDefHammer() + prop.getDefHammer());
        battle.setDefPctHammer(battle.getDefPctHammer() + prop.getDefPctHammer());

        // 枪法相关
        battle.setDamSpear(battle.getDamSpear() + prop.getDamSpear());
        battle.setDamPctSpear(battle.getDamPctSpear() + prop.getDamPctSpear());
        battle.setDefSpear(battle.getDefSpear() + prop.getDefSpear());
        battle.setDefPctSpear(battle.getDefPctSpear() + prop.getDefPctSpear());

        // 拳法相关
        battle.setDamBoxing(battle.getDamBoxing() + prop.getDamBoxing());
        battle.setDamPctBoxing(battle.getDamPctBoxing() + prop.getDamPctBoxing());
        battle.setDefBoxing(battle.getDefBoxing() + prop.getDefBoxing());
        battle.setDefPctBoxing(battle.getDefPctBoxing() + prop.getDefPctBoxing());

        // 符法相关
        battle.setDamTally(battle.getDamTally() + prop.getDamTally());
        battle.setDamPctTally(battle.getDamPctTally() + prop.getDamPctTally());
        battle.setDefTally(battle.getDefTally() + prop.getDefTally());
        battle.setDefPctTally(battle.getDefPctTally() + prop.getDefPctTally());

        // 盾法相关
        battle.setDamShield(battle.getDamShield() + prop.getDamShield());
        battle.setDamPctShield(battle.getDamPctShield() + prop.getDamPctShield());
        battle.setDefShield(battle.getDefShield() + prop.getDefShield());
        battle.setDefPctShield(battle.getDefPctShield() + prop.getDefPctShield());

        // 法印相关
        battle.setDamSeal(battle.getDamSeal() + prop.getDamSeal());
        battle.setDamPctSeal(battle.getDamPctSeal() + prop.getDamPctSeal());
        battle.setDefSeal(battle.getDefSeal() + prop.getDefSeal());
        battle.setDefPctSeal(battle.getDefPctSeal() + prop.getDefPctSeal());
    }
} 