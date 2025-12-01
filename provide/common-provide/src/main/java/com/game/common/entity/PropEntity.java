package com.game.common.entity;

import com.baidu.bjf.remoting.protobuf.annotation.ProtobufClass;
import lombok.Data;

// {"BaseHp":33,"DcMin":2,"DcMax":3,"Ac":2}
@Data
@ProtobufClass
public class PropEntity {
    /**
     * 气血
     */
    int HpMax = 0;
    /**
     * 当前气血
     */
    int CurHp = 0;
    /**
     * 基础气血
     */
    int BaseHp = 0;
    /**
     * 气血加成
     */
    int HpPct = 0;
    /**
     * 气血恢复
     */
    int HpReg = 0;
    /**
     * 灵力
     */
    int MpMax = 0;
    /**
     * 当前灵力
     */
    int CurMp = 0;
    /**
     * 灵力恢复
     */
    int MpReg = 0;
    /**
     * 最大攻击
     */
    int DcMax = 0;
    /**
     * 最小攻击
     */
    int DcMin = 0;
    /**
     * 攻击万分比
     */
    int DcPct = 0;
    /**
     * 防御
     */
    int Ac = 0;
    /**
     * 防御万分比
     */
    int AcPct = 0;
    /**
     * 命中
     */
    int Hit = 0;
    /**
     * 闪避
     */
    int Dodge = 0;
    /**
     * 会心
     */
    int LuckyStrike = 0;
    /**
     * 会心抗性
     */
    int LuckyDef = 0;
    /**
     * 神圣抗性
     */
    int PureDef = 0;
    /**
     * 暴击概率
     */
    int CritRatio = 0;
    /**
     * 暴击伤害
     */
    int CritDam = 0;
    /**
     * 暴击抗性
     */
    int CritRatioDef = 0;
    /**
     * 暴伤减免
     */
    int CritDamDef = 0;
    /**
     * 灵根-金
     */
    int JinAtk = 0;
    /**
     * 灵根-木
     */
    int MuAtk = 0;
    /**
     * 灵根-水
     */
    int ShuiAtk = 0;
    /**
     * 灵根-火
     */
    int HuoAtk = 0;
    /**
     * 灵根-土
     */
    int TuAtk = 0;
    /**
     * 灵根抗性
     */
    int EleDef = 0;

    /**
     * 万分比伤害
     */
    int DamPct = 0;
    /**
     * 对人族伤害万分比
     */
    int DamPctPeople = 0;
    /**
     * 对妖族伤害万分比
     */
    int DamPctElf = 0;
    /**
     * 对魔族伤害万分比
     */
    int DamPctEvil = 0;
    /**
     * 对仙族伤害万分比
     */
    int DamPctFariy = 0;
    /**
     * 对灵族伤害万分比
     */
    int DamPctSpirit = 0;
    /**
     * 对同性伤害万分比
     */
    int DamPctSameSex = 0;
    /**
     * 对异性伤害万分比
     */
    int DamPctDiffSex = 0;
    /**
     * 万分比抗性
     */
    int DefPct = 0;
    /**
     * 对人族抗性万分比
     */
    int DefPctPeople = 0;
    /**
     * 对妖族抗性万分比
     */
    int DefPctElf = 0;
    /**
     * 对魔族抗性万分比
     */
    int DefPctEvil = 0;
    /**
     * 对仙族抗性万分比
     */
    int DefPctFariy = 0;
    /**
     * 对灵族抗性万分比
     */
    int DefPctSpirit = 0;
    /**
     * 固定吸血
     */
    int BloodLust = 0;
    /**
     * 万分比吸血
     */
    int BloodLustPct = 0;
    /**
     * 移动速度
     */
    int MoveSpeed = 0;
    /**
     * 当前移速
     */
    int CurMoveSpeed = 0;
    /**
     * 移速加成
     */
    int MoveSpeedPct = 0;
    /**
     * 释放速度
     */
    int MagicSpeed = 0;
    /**
     * 技能急速
     */
    int Haste = 0;
    /**
     * 技能急速转换出的冷却缩减万分比
     */
    int Haste_Pct = 0;
    /**
     * 技能状态
     */
    int SkillStep = 0;
    /**
     * 当前释放技能id
     */
    int SkillId = 0;
    /**
     * 破甲
     */
    int ApPct = 0;
    /**
     * 破甲概率
     */
    int ApRatio = 0;
    /**
     * 护盾
     */
    int Shield = 0;

    /**
     * 金属性伤害增加
     */
    int DamJin = 0;
    /**
     * 木属性伤害增加
     */
    int DamMu = 0;
    /**
     * 水属性伤害增加
     */
    int DamShui = 0;
    /**
     * 火属性伤害增加
     */
    int DamHuo = 0;
    /**
     * 土属性伤害增加
     */
    int DamTu = 0;
    /**
     * 金属性伤害百分比增加
     */
    int DamPctJin = 0;
    /**
     * 木属性伤害百分比增加
     */
    int DamPctMu = 0;
    /**
     * 水属性伤害百分比增加
     */
    int DamPctShui = 0;
    /**
     * 火属性伤害百分比增加
     */
    int DamPctHuo = 0;
    /**
     * 土属性伤害百分比增加
     */
    int DamPctTu = 0;
    /**
     * 金属性伤害减少
     */
    int DefJin = 0;
    /**
     * 木属性伤害减少
     */
    int DefMu = 0;
    /**
     * 水属性伤害减少
     */
    int DefShui = 0;
    /**
     * 火属性伤害减少
     */
    int DefHuo = 0;
    /**
     * 土属性伤害减少
     */
    int DefTu = 0;
    /**
     * 金属性伤害百分比减少
     */
    int DefPctJin = 0;
    /**
     * 木属性伤害百分比减少
     */
    int DefPctMu = 0;
    /**
     * 水属性伤害百分比减少
     */
    int DefPctShui = 0;
    /**
     * 火属性伤害百分比减少
     */
    int DefPctHuo = 0;
    /**
     * 土属性伤害百分比减少
     */
    int DefPctTu = 0;
    /**
     * 治疗效果降低
     */
    int DefCure = 0;

    /**
     * 精通-剑
     */
    int TechSword = 0;
    /**
     * 剑伤害增加
     */
    int DamSword = 0;
    /**
     * 剑伤害百分比增加
     */
    int DamPctSword = 0;
    /**
     * 剑伤害减少
     */
    int DefSword = 0;
    /**
     * 剑伤害百分比减少
     */
    int DefPctSword = 0;
    /**
     * 精通-刀
     */
    int TechKnife = 0;
    /**
     * 刀伤害增加
     */
    int DamKnife = 0;
    /**
     * 刀伤害百分比增加
     */
    int DamPctKnife = 0;
    /**
     * 刀伤害减少
     */
    int DefKnife = 0;
    /**
     * 刀伤害百分比减少
     */
    int DefPctKnife = 0;
    /**
     * 精通-锤
     */
    int TechHammer = 0;
    /**
     * 锤伤害增加
     */
    int DamHammer = 0;
    /**
     * 锤伤害百分比增加
     */
    int DamPctHammer = 0;
    /**
     * 锤伤害减少
     */
    int DefHammer = 0;
    /**
     * 锤伤害百分比减少
     */
    int DefPctHammer = 0;
    /**
     * 精通-枪
     */
    int TechSpear = 0;
    /**
     * 枪伤害增加
     */
    int DamSpear = 0;
    /**
     * 枪伤害百分比增加
     */
    int DamPctSpear = 0;
    /**
     * 枪伤害减少
     */
    int DefSpear = 0;
    /**
     * 枪伤害百分比减少
     */
    int DefPctSpear = 0;
    /**
     * 精通-拳
     */
    int TechBoxing = 0;
    /**
     * 拳伤害增加
     */
    int DamBoxing = 0;
    /**
     * 拳伤害百分比增加
     */
    int DamPctBoxing = 0;
    /**
     * 拳伤害减少
     */
    int DefBoxing = 0;
    /**
     * 拳伤害百分比减少
     */
    int DefPctBoxing = 0;
    /**
     * 精通-符
     */
    int TechTally = 0;
    /**
     * 符伤害增加
     */
    int DamTally = 0;
    /**
     * 符伤害百分比增加
     */
    int DamPctTally = 0;
    /**
     * 符伤害减少
     */
    int DefTally = 0;
    /**
     * 符伤害百分比减少
     */
    int DefPctTally = 0;
    /**
     * 精通-盾
     */
    int TechShield = 0;
    /**
     * 盾伤害增加
     */
    int DamShield = 0;
    /**
     * 盾伤害百分比增加
     */
    int DamPctShield = 0;
    /**
     * 盾伤害减少
     */
    int DefShield = 0;
    /**
     * 盾伤害百分比减少
     */
    int DefPctShield = 0;
    /**
     * 精通-印
     */
    int TechSeal = 0;
    /**
     * 印伤害增加
     */
    int DamSeal = 0;
    /**
     * 印伤害百分比增加
     */
    int DamPctSeal = 0;
    /**
     * 印伤害减少
     */
    int DefSeal = 0;
    /**
     * 印伤害百分比减少
     */
    int DefPctSeal = 0;

    /**
     * 技能死亡凝视状态--移动会造成伤害技能 0无状态 1影响中
     */
    int SkillEyeStatus = 0;


    /**
     * 根据最小和最大属性值生成随机武器属性
     *
     * @param propMin 最小属性
     * @param propMax 最大属性
     * @return 随机生成的武器属性
     */
    public static PropEntity generateProps(PropEntity propMin, PropEntity propMax) {
        PropEntity randomProp = new PropEntity();

        // 如果最小或最大属性为空，返回空属性
        if (propMin == null || propMax == null) {
            return randomProp;
        }

        // 随机生成基础气血值
        if (propMin.getBaseHp() > 0 || propMax.getBaseHp() > 0) {
            int minHp = propMin.getBaseHp();
            int maxHp = propMax.getBaseHp();
            if (maxHp > minHp) {
                randomProp.setBaseHp(minHp + (int) (Math.random() * (maxHp - minHp + 1)));
            } else {
                randomProp.setBaseHp(minHp);
            }
        }

        // 随机生成最小攻击值
        if (propMin.getDcMin() > 0 || propMax.getDcMin() > 0) {
            int minDcMin = propMin.getDcMin();
            int maxDcMin = propMax.getDcMin();
            if (maxDcMin > minDcMin) {
                randomProp.setDcMin(minDcMin + (int) (Math.random() * (maxDcMin - minDcMin + 1)));
            } else {
                randomProp.setDcMin(minDcMin);
            }
        }

        // 随机生成最大攻击值
        if (propMin.getDcMax() > 0 || propMax.getDcMax() > 0) {
            int minDcMax = propMin.getDcMax();
            int maxDcMax = propMax.getDcMax();
            if (maxDcMax > minDcMax) {
                randomProp.setDcMax(minDcMax + (int) (Math.random() * (maxDcMax - minDcMax + 1)));
            } else {
                randomProp.setDcMax(minDcMax);
            }
        }

        // 随机生成防御值
        if (propMin.getAc() > 0 || propMax.getAc() > 0) {
            int minAc = propMin.getAc();
            int maxAc = propMax.getAc();
            if (maxAc > minAc) {
                randomProp.setAc(minAc + (int) (Math.random() * (maxAc - minAc + 1)));
            } else {
                randomProp.setAc(minAc);
            }
        }

        return randomProp;
    }
}
