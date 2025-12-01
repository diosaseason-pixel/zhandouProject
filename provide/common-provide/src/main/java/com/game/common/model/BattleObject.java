package com.game.common.model;

import com.game.attr.Attr;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BattleObject extends BaseObject {

    // 生命相关属性
    @AttrField(Attr.Battle.HpMax)
    private int hpMax;
    
    @AttrField(Attr.Battle.CurHp)
    private int curHp;
    
    @AttrField(Attr.Battle.BaseHp)
    private int baseHp;
    
    @AttrField(Attr.Battle.HpPct)
    private int hpPct;
    
    @AttrField(Attr.Battle.HpReg)
    private int hpReg;
    
    // 灵力相关属性
    @AttrField(Attr.Battle.MpMax)
    private int mpMax;
    
    @AttrField(Attr.Battle.CurMp)
    private int curMp;
    
    @AttrField(Attr.Battle.MpReg)
    private int mpReg;
    
    // 攻击相关属性
    @AttrField(Attr.Battle.DcMax)
    private int dcMax;
    
    @AttrField(Attr.Battle.DcMin)
    private int dcMin;
    
    @AttrField(Attr.Battle.DcPct)
    private int dcPct;
    
    // 防御相关属性
    @AttrField(Attr.Battle.Ac)
    private int ac;
    
    @AttrField(Attr.Battle.AcPct)
    private int acPct;
    
    // 命中与闪避
    @AttrField(Attr.Battle.Hit)
    private int hit;
    
    @AttrField(Attr.Battle.Dodge)
    private int dodge;
    
    // 会心与抗性
    @AttrField(Attr.Battle.LuckyStrike)
    private int luckyStrike;
    
    @AttrField(Attr.Battle.LuckyDef)
    private int luckyDef;
    
    @AttrField(Attr.Battle.PureDef)
    private int pureDef;
    
    // 暴击相关
    @AttrField(Attr.Battle.CritRatio)
    private int critRatio;
    
    @AttrField(Attr.Battle.CritDam)
    private int critDam;
    
    @AttrField(Attr.Battle.CritRatioDef)
    private int critRatioDef;
    
    @AttrField(Attr.Battle.CritDamDef)
    private int critDamDef;
    
    // 灵根属性
    @AttrField(Attr.Battle.JinAtk)
    private int jinAtk;
    
    @AttrField(Attr.Battle.MuAtk)
    private int muAtk;
    
    @AttrField(Attr.Battle.ShuiAtk)
    private int shuiAtk;
    
    @AttrField(Attr.Battle.HuoAtk)
    private int huoAtk;
    
    @AttrField(Attr.Battle.TuAtk)
    private int tuAtk;
    
    @AttrField(Attr.Battle.EleDef)
    private int eleDef;
    
    // 伤害属性
    @AttrField(Attr.Battle.DamPct)
    private int damPct;
    
    @AttrField(Attr.Battle.DamPctPeople)
    private int damPctPeople;
    
    @AttrField(Attr.Battle.DamPctElf)
    private int damPctElf;
    
    @AttrField(Attr.Battle.DamPctEvil)
    private int damPctEvil;
    
    @AttrField(Attr.Battle.DamPctFariy)
    private int damPctFariy;
    
    @AttrField(Attr.Battle.DamPctSpirit)
    private int damPctSpirit;
    
    @AttrField(Attr.Battle.DamPctSameSex)
    private int damPctSameSex;
    
    @AttrField(Attr.Battle.DamPctDiffSex)
    private int damPctDiffSex;
    
    // 抗性属性
    @AttrField(Attr.Battle.DefPct)
    private int defPct;
    
    @AttrField(Attr.Battle.DefPctPeople)
    private int defPctPeople;
    
    @AttrField(Attr.Battle.DefPctElf)
    private int defPctElf;
    
    @AttrField(Attr.Battle.DefPctEvil)
    private int defPctEvil;
    
    @AttrField(Attr.Battle.DefPctFariy)
    private int defPctFariy;
    
    @AttrField(Attr.Battle.DefPctSpirit)
    private int defPctSpirit;
    
    // 吸血与移动速度
    @AttrField(Attr.Battle.BloodLust)
    private int bloodLust;
    
    @AttrField(Attr.Battle.BloodLustPct)
    private int bloodLustPct;
    
    @AttrField(Attr.Battle.MoveSpeed)
    private int moveSpeed;
    
    @AttrField(Attr.Battle.CurMoveSpeed)
    private int curMoveSpeed;
    
    @AttrField(Attr.Battle.MoveSpeedPct)
    private int moveSpeedPct;
    
    // 技能相关
    @AttrField(Attr.Battle.MagicSpeed)
    private int magicSpeed;
    
    @AttrField(Attr.Battle.Haste)
    private int haste;
    
    @AttrField(Attr.Battle.Haste_Pct)
    private int hastePct;
    
    @AttrField(Attr.Battle.SkillStep)
    private int skillStep;
    
    @AttrField(Attr.Battle.SkillId)
    private int skillId;
    
    // 破甲与护盾
    @AttrField(Attr.Battle.ApPct)
    private int apPct;
    
    @AttrField(Attr.Battle.ApRatio)
    private int apRatio;
    
    @AttrField(Attr.Battle.Shield)
    private int shield;
    
    // 五行属性伤害增加
    @AttrField(Attr.Battle.DamJin)
    private int damJin;
    
    @AttrField(Attr.Battle.DamMu)
    private int damMu;
    
    @AttrField(Attr.Battle.DamShui)
    private int damShui;
    
    @AttrField(Attr.Battle.DamHuo)
    private int damHuo;
    
    @AttrField(Attr.Battle.DamTu)
    private int damTu;
    
    // 五行属性伤害百分比增加
    @AttrField(Attr.Battle.DamPctJin)
    private int damPctJin;
    
    @AttrField(Attr.Battle.DamPctMu)
    private int damPctMu;
    
    @AttrField(Attr.Battle.DamPctShui)
    private int damPctShui;
    
    @AttrField(Attr.Battle.DamPctHuo)
    private int damPctHuo;
    
    @AttrField(Attr.Battle.DamPctTu)
    private int damPctTu;
    
    // 五行属性伤害减少
    @AttrField(Attr.Battle.DefJin)
    private int defJin;
    
    @AttrField(Attr.Battle.DefMu)
    private int defMu;
    
    @AttrField(Attr.Battle.DefShui)
    private int defShui;
    
    @AttrField(Attr.Battle.DefHuo)
    private int defHuo;
    
    @AttrField(Attr.Battle.DefTu)
    private int defTu;
    
    // 五行属性伤害百分比减少
    @AttrField(Attr.Battle.DefPctJin)
    private int defPctJin;
    
    @AttrField(Attr.Battle.DefPctMu)
    private int defPctMu;
    
    @AttrField(Attr.Battle.DefPctShui)
    private int defPctShui;
    
    @AttrField(Attr.Battle.DefPctHuo)
    private int defPctHuo;
    
    @AttrField(Attr.Battle.DefPctTu)
    private int defPctTu;
    
    @AttrField(Attr.Battle.DefCure)
    private int defCure;
    
    // 武器精通类属性
    // 剑
    @AttrField(Attr.Battle.TechSword)
    private int techSword;
    
    @AttrField(Attr.Battle.DamSword)
    private int damSword;
    
    @AttrField(Attr.Battle.DamPctSword)
    private int damPctSword;
    
    @AttrField(Attr.Battle.DefSword)
    private int defSword;
    
    @AttrField(Attr.Battle.DefPctSword)
    private int defPctSword;
    
    // 刀
    @AttrField(Attr.Battle.TechKnife)
    private int techKnife;
    
    @AttrField(Attr.Battle.DamKnife)
    private int damKnife;
    
    @AttrField(Attr.Battle.DamPctKnife)
    private int damPctKnife;
    
    @AttrField(Attr.Battle.DefKnife)
    private int defKnife;
    
    @AttrField(Attr.Battle.DefPctKnife)
    private int defPctKnife;
    
    // 锤
    @AttrField(Attr.Battle.TechHammer)
    private int techHammer;
    
    @AttrField(Attr.Battle.DamHammer)
    private int damHammer;
    
    @AttrField(Attr.Battle.DamPctHammer)
    private int damPctHammer;
    
    @AttrField(Attr.Battle.DefHammer)
    private int defHammer;
    
    @AttrField(Attr.Battle.DefPctHammer)
    private int defPctHammer;
    
    // 枪
    @AttrField(Attr.Battle.TechSpear)
    private int techSpear;
    
    @AttrField(Attr.Battle.DamSpear)
    private int damSpear;
    
    @AttrField(Attr.Battle.DamPctSpear)
    private int damPctSpear;
    
    @AttrField(Attr.Battle.DefSpear)
    private int defSpear;
    
    @AttrField(Attr.Battle.DefPctSpear)
    private int defPctSpear;
    
    // 拳
    @AttrField(Attr.Battle.TechBoxing)
    private int techBoxing;
    
    @AttrField(Attr.Battle.DamBoxing)
    private int damBoxing;
    
    @AttrField(Attr.Battle.DamPctBoxing)
    private int damPctBoxing;
    
    @AttrField(Attr.Battle.DefBoxing)
    private int defBoxing;
    
    @AttrField(Attr.Battle.DefPctBoxing)
    private int defPctBoxing;
    
    // 符
    @AttrField(Attr.Battle.TechTally)
    private int techTally;
    
    @AttrField(Attr.Battle.DamTally)
    private int damTally;
    
    @AttrField(Attr.Battle.DamPctTally)
    private int damPctTally;
    
    @AttrField(Attr.Battle.DefTally)
    private int defTally;
    
    @AttrField(Attr.Battle.DefPctTally)
    private int defPctTally;
    
    // 盾
    @AttrField(Attr.Battle.TechShield)
    private int techShield;
    
    @AttrField(Attr.Battle.DamShield)
    private int damShield;
    
    @AttrField(Attr.Battle.DamPctShield)
    private int damPctShield;
    
    @AttrField(Attr.Battle.DefShield)
    private int defShield;
    
    @AttrField(Attr.Battle.DefPctShield)
    private int defPctShield;
    
    // 印
    @AttrField(Attr.Battle.TechSeal)
    private int techSeal;
    
    @AttrField(Attr.Battle.DamSeal)
    private int damSeal;
    
    @AttrField(Attr.Battle.DamPctSeal)
    private int damPctSeal;
    
    @AttrField(Attr.Battle.DefSeal)
    private int defSeal;
    
    @AttrField(Attr.Battle.DefPctSeal)
    private int defPctSeal;
    
    // 技能特殊状态
    @AttrField(Attr.Battle.SkillEyeStatus)
    private int skillEyeStatus;

    public BattleObject(int objId) {
        super(objId);
    }

    /**
     * 判断是否存活
     *
     * @return 如果存活返回true，否则返回false
     */
    public boolean isAlive() {
        return getStatus() == 0; // 假设0表示存活状态，可能需要根据项目常量调整
    }

    /**
     * 判断是否死亡
     *
     * @return 如果死亡返回true，否则返回false
     */
    public boolean isDead() {
        return !isAlive();
    }
    
    /**
     * 判断是否可以移动
     *
     * @return 如果可以移动返回true，否则返回false
     */
    public boolean canMove() {
        return isAlive() && getCurMoveSpeed() > 0;
    }
}
