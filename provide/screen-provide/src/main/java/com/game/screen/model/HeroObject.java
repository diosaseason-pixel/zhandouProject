package com.game.screen.model;

import com.game.attr.Attr;
import com.game.common.model.BattleObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroObject extends BattleObject {

    public HeroObject(int objId) {
        super(objId);
    }

    // 基础属性
    @AttrField(Attr.Hero.CurExp)
    private int curExp;

    @AttrField(Attr.Hero.ExpMax)
    private int expMax;

    // 货币相关
    @AttrField(Attr.Hero.PayCoin)
    private int payCoin;

    @AttrField(Attr.Hero.BindPayCoin)
    private int bindPayCoin;

    @AttrField(Attr.Hero.Coin)
    private int coin;

    @AttrField(Attr.Hero.BindCoin)
    private int bindCoin;

    @AttrField(Attr.Hero.FairyCrystal)
    private int fairyCrystal;

    // 背包相关
    @AttrField(Attr.Hero.MaxPackage)
    private int maxPackage;

    @AttrField(Attr.Hero.MaxStorage)
    private int maxStorage;

    // 角色ID相关
    @AttrField(Attr.Hero.PlayerID)
    private int playerID;

    @AttrField(Attr.Hero.UserId)
    private int userId;

    // 人物资质属性
    @AttrField(Attr.Hero.Lucky)
    private int lucky;

    @AttrField(Attr.Hero.Age)
    private int age;

    @AttrField(Attr.Hero.TechAlchemy)
    private int techAlchemy;

    @AttrField(Attr.Hero.TechRefiner)
    private int techRefiner;

    @AttrField(Attr.Hero.TechMedicine)
    private int techMedicine;

    @AttrField(Attr.Hero.TechFengshui)
    private int techFengshui;

    @AttrField(Attr.Hero.Comprehension)
    private int comprehension;

    @AttrField(Attr.Hero.Healthy)
    private int healthy;

    @AttrField(Attr.Hero.Charm)
    private int charm;

    @AttrField(Attr.Hero.Energy)
    private int energy;

    // 角色外观
    @AttrField(Attr.Hero.FaceShape)
    private int faceShape;

    @AttrField(Attr.Hero.Eyebrow)
    private int eyebrow;

    @AttrField(Attr.Hero.Nose)
    private int nose;

    @AttrField(Attr.Hero.Mouth)
    private int mouth;

    @AttrField(Attr.Hero.FaceDecoration)
    private int faceDecoration;

    // 时装
    @AttrField(Attr.Hero.FashionSuit)
    private int fashionSuit;

    @AttrField(Attr.Hero.FashionHair)
    private int fashionHair;

    @AttrField(Attr.Hero.FashionFaceDecoration)
    private int fashionFaceDecoration;

    @AttrField(Attr.Hero.FashionClothes)
    private int fashionClothes;

    // 角色状态
    @AttrField(Attr.Hero.CreateRoleTime)
    private int createRoleTime;

    @AttrField(Attr.Hero.DailyReliveTimes)
    private int dailyReliveTimes;

    @AttrField(value = Attr.Hero.Destiny, isString = true)
    private String destiny;

    @AttrField(Attr.Hero.CombatValue)
    private int combatValue;

    // 资质相关
    @AttrField(Attr.Hero.Qualifications)
    private int qualifications;

    @AttrField(Attr.Hero.RandomQualifications)
    private int randomQualifications;

    @AttrField(Attr.Hero.RandomDestiny)
    private int randomDestiny;

    // 渡劫相关
    @AttrField(Attr.Hero.RescueStatus)
    private int rescueStatus;

    @AttrField(Attr.Hero.JoinRescueStatus)
    private int joinRescueStatus;

    @AttrField(Attr.Hero.RescuePrepareStatus)
    private int rescuePrepareStatus;

    @AttrField(Attr.Hero.RescueHelpCount)
    private int rescueHelpCount;

    @AttrField(Attr.Hero.RescueDrabCount)
    private int rescueDrabCount;

    @AttrField(Attr.Hero.RescueEndTime)
    private int rescueEndTime;

    @AttrField(Attr.Hero.JoinRescueObjId)
    private int joinRescueObjId;

    @AttrField(Attr.Hero.JoinRescueType)
    private int joinRescueType;

    // 修炼相关
    @AttrField(Attr.Hero.ExpSpeed)
    private int expSpeed;

    @AttrField(Attr.Hero.MapPosX)
    private int mapPosX;

    @AttrField(Attr.Hero.MapPosY)
    private int mapPosY;

    @AttrField(Attr.Hero.EnergyAddTime)
    private int energyAddTime;

    @AttrField(Attr.Hero.ExpAddBegin)
    private int expAddBegin;

    @AttrField(Attr.Hero.EnergyGet)
    private int energyGet;

    @AttrField(Attr.Hero.HExpLimit)
    private int hExpLimit;

    // 公会相关
    @AttrField(Attr.Hero.GuildShopDailyReward)
    private int guildShopDailyReward;

    @AttrField(Attr.Hero.GuildName)
    private String guildName;

    @AttrField(Attr.Hero.GuildOfficeId)
    private int guildOfficeId;

    @AttrField(Attr.Hero.GuildTaskBuyCount)
    private int guildTaskBuyCount;

    @AttrField(Attr.Hero.Contribute)
    private int contribute;

    // 道具相关
    @AttrField(Attr.Hero.LastDrugId)
    private int lastDrugId;

    @AttrField(Attr.Hero.DrugCount)
    private int drugCount;

    @AttrField(Attr.Hero.DrugList)
    private String drugList;

    @AttrField(Attr.Hero.ExpDrugLimit)
    private int expDrugLimit;

    @AttrField(Attr.Hero.ItemUseTimesWithAddAttr)
    private int itemUseTimesWithAddAttr;

    // 法宝相关
    @AttrField(Attr.Hero.EquipMagic)
    private int equipMagic;

    @AttrField(Attr.Hero.Tech)
    private int tech;

    @AttrField(Attr.Hero.MagicFire)
    private int magicFire;

    @AttrField(Attr.Hero.MagicWeaponCurrent)
    private int magicWeaponCurrent;

    @AttrField(Attr.Hero.MagicFireSkillId)
    private int magicFireSkillId;

    @AttrField(Attr.Hero.EquipSelfMagicShow)
    private int equipSelfMagicShow;

    // 坐骑相关
    @AttrField(Attr.Hero.RideState)
    private int rideState;

    @AttrField(Attr.Hero.BoatLevel)
    private int boatLevel;

    @AttrField(Attr.Hero.RideId)
    private int rideId;

    @AttrField(Attr.Hero.RideDeathTime)
    private int rideDeathTime;

    @AttrField(Attr.Hero.RideStatus)
    private int rideStatus;

    @AttrField(Attr.Hero.RideCurHp)
    private int rideCurHp;

    @AttrField(Attr.Hero.RideHpMax)
    private int rideHpMax;

    @AttrField(Attr.Hero.BattleRideState)
    private int battleRideState;

    @AttrField(Attr.Hero.LastRideId)
    private int lastRideId;

    // 竞技场相关
    @AttrField(Attr.Hero.BattleStatus)
    private int battleStatus;

    @AttrField(Attr.Hero.BattlingTime)
    private int battlingTime;

    @AttrField(Attr.Hero.BattleCount)
    private int battleCount;

    @AttrField(Attr.Hero.BattleBuyCount)
    private int battleBuyCount;

    @AttrField(Attr.Hero.BattleCrossServerId)
    private int battleCrossServerId;

    @AttrField(Attr.Hero.BattleCrossRank)
    private int battleCrossRank;

    @AttrField(Attr.Hero.BattleDailyJoinCount)
    private int battleDailyJoinCount;

    @AttrField(Attr.Hero.BattlePlanId)
    private int battlePlanId;

    @AttrField(Attr.Hero.BattleSetingData)
    private String battleSetingData;

    @AttrField(Attr.Hero.BattleNpcId)
    private int battleNpcId;

    @AttrField(Attr.Hero.BattlePvpDuplicateId)
    private int battlePvpDuplicateId;

    // 本服竞技场
    @AttrField(Attr.Hero.LocalBattleStatus)
    private int localBattleStatus;

    @AttrField(Attr.Hero.LocalBattlingTime)
    private int localBattlingTime;

    @AttrField(Attr.Hero.LocalBattleCount)
    private int localBattleCount;

    @AttrField(Attr.Hero.LocalBattleBuyCount)
    private int localBattleBuyCount;

    @AttrField(Attr.Hero.LocalBattleVersion)
    private int localBattleVersion;

    @AttrField(Attr.Hero.LocalBattleDailyTask)
    private String localBattleDailyTask;

    @AttrField(Attr.Hero.LocalBattleTask)
    private String localBattleTask;

    @AttrField(Attr.Hero.LocalBattleDailyJoinCount)
    private int localBattleDailyJoinCount;

    @AttrField(Attr.Hero.LocalBattleTodayIsBattle)
    private int localBattleTodayIsBattle;

    @AttrField(Attr.Hero.LocalBattleScoreMoney)
    private int localBattleScoreMoney;

    // 爬塔相关
    @AttrField(Attr.Hero.TowerNum)
    private int towerNum;

    @AttrField(Attr.Hero.TowerReward)
    private String towerReward;

    @AttrField(Attr.Hero.TowerSweep)
    private int towerSweep;

    @AttrField(Attr.Hero.TowerSweepBuyTimes)
    private int towerSweepBuyTimes;

    @AttrField(Attr.Hero.TowerHangUpStartTime)
    private int towerHangUpStartTime;

    @AttrField(Attr.Hero.TowerHangUpBuyCount)
    private int towerHangUpBuyCount;

    // NPC相关
    @AttrField(Attr.Hero.StealFindStatus)
    private int stealFindStatus;

    @AttrField(Attr.Hero.NpcPardonStatus)
    private int npcPardonStatus;

    @AttrField(Attr.Hero.NpcAffixSetting)
    private String npcAffixSetting;

    @AttrField(Attr.Hero.NpcFreeCultivateNum)
    private int npcFreeCultivateNum;

    @AttrField(Attr.Hero.NextNpcSwitchTime)
    private int nextNpcSwitchTime;

    // 灵宠相关
    @AttrField(Attr.Hero.SpiritPetContinuousDrawNum)
    private int spiritPetContinuousDrawNum;

    @AttrField(Attr.Hero.SpiritPetSeekNumAct)
    private int spiritPetSeekNumAct;

    @AttrField(Attr.Hero.SpiritPetFind)
    private int spiritPetFind;

    @AttrField(Attr.Hero.FindDisplayPetId)
    private int findDisplayPetId;

    @AttrField(Attr.Hero.SpiritPetCatchNum)
    private int spiritPetCatchNum;

    @AttrField(Attr.Hero.PetSearchBegin)
    private int petSearchBegin;

    @AttrField(Attr.Hero.PetSearchPos)
    private String petSearchPos;

    @AttrField(Attr.Hero.PetCatchStatus)
    private int petCatchStatus;

    @AttrField(Attr.Hero.PetCatchItemId)
    private int petCatchItemId;

    @AttrField(Attr.Hero.SpiritLastSearchParam)
    private int spiritLastSearchParam;

    @AttrField(Attr.Hero.PetAutoCatchSetting)
    private int petAutoCatchSetting;

    // 图鉴相关
    @AttrField(Attr.Hero.NpcBookExp)
    private int npcBookExp;

    @AttrField(Attr.Hero.NpcBookLv)
    private int npcBookLv;

    @AttrField(Attr.Hero.HeartBookExp)
    private int heartBookExp;

    @AttrField(Attr.Hero.HeartBookLv)
    private int heartBookLv;

    @AttrField(Attr.Hero.SelfWeaponBookExp)
    private int selfWeaponBookExp;

    @AttrField(Attr.Hero.SelfWeaponBookLv)
    private int selfWeaponBookLv;

    @AttrField(Attr.Hero.MagicFireBookExp)
    private int magicFireBookExp;

    @AttrField(Attr.Hero.MagicFireBookLv)
    private int magicFireBookLv;

    @AttrField(Attr.Hero.RideBookExp)
    private int rideBookExp;

    @AttrField(Attr.Hero.RiderBookLv)
    private int riderBookLv;

    // 五行元素
    @AttrField(Attr.Hero.Ele)
    private int ele;

    @AttrField(Attr.Hero.MetalEle)
    private int metalEle;

    @AttrField(Attr.Hero.WoodEle)
    private int woodEle;

    @AttrField(Attr.Hero.WaterEle)
    private int waterEle;

    @AttrField(Attr.Hero.FireEle)
    private int fireEle;

    @AttrField(Attr.Hero.EarthEle)
    private int earthEle;

    // 势力相关
    @AttrField(Attr.Hero.CampLv)
    private String campLv;

    @AttrField(Attr.Hero.CampCount14)
    private int campCount14;

    @AttrField(Attr.Hero.CampCount15)
    private int campCount15;

    @AttrField(Attr.Hero.CampCount16)
    private int campCount16;

    @AttrField(Attr.Hero.CampCount17)
    private int campCount17;

    @AttrField(Attr.Hero.CampCount18)
    private int campCount18;

    @AttrField(Attr.Hero.CampCount19)
    private int campCount19;

    @AttrField(Attr.Hero.CampCount20)
    private int campCount20;

    @AttrField(Attr.Hero.CampCount21)
    private int campCount21;

    @AttrField(Attr.Hero.CampDailyTaskAcceptNum)
    private int campDailyTaskAcceptNum;

    @AttrField(Attr.Hero.CampTaskRefreshNum)
    private int campTaskRefreshNum;

    // 充值相关
    @AttrField(Attr.Hero.RechargeGive)
    private int rechargeGive;

    @AttrField(Attr.Hero.RechargeItemNum)
    private int rechargeItemNum;

    @AttrField(Attr.Hero.FirstRechargeAwardAt)
    private int firstRechargeAwardAt;

    @AttrField(Attr.Hero.RechargeRebateValue)
    private int rechargeRebateValue;

    @AttrField(Attr.Hero.RoleRechargeCount)
    private int roleRechargeCount;

    // 洞府相关
    @AttrField(Attr.Hero.CaveLevel)
    private int caveLevel;

    @AttrField(Attr.Hero.CaveName)
    private String caveName;

    // 其他属性
    @AttrField(Attr.Hero.GodViewStatus)
    private int godViewStatus;

    @AttrField(Attr.Hero.Auctioning)
    private int auctioning;

    @AttrField(Attr.Hero.BodyRefine)
    private int bodyRefine;

    @AttrField(Attr.Hero.HuntHelpCount)
    private int huntHelpCount;

    @AttrField(Attr.Hero.ReliveCount)
    private int reliveCount;

    @AttrField(Attr.Hero.HeroChangeNameCd)
    private int heroChangeNameCd;

    @AttrField(Attr.Hero.HuntCoin)
    private int huntCoin;

    @AttrField(Attr.Hero.Transfer)
    private int transfer;

    @AttrField(Attr.Hero.SysSeting)
    private String sysSeting;

    @AttrField(Attr.Hero.GainAssembly)
    private String gainAssembly;

    @AttrField(Attr.Hero.Innat)
    private String innat;

    @AttrField(Attr.Hero.InnatCount)
    private int innatCount;

    @AttrField(Attr.Hero.TeachCount)
    private int teachCount;

    @AttrField(Attr.Hero.DiscussCount)
    private int discussCount;

    @AttrField(Attr.Hero.ActivityNum)
    private int activityNum;

    @AttrField(Attr.Hero.ChatUnFreezeTime)
    private int chatUnFreezeTime;

    @AttrField(Attr.Hero.CurNature)
    private int curNature;

    @AttrField(Attr.Hero.BaseNature)
    private int baseNature;

    @AttrField(Attr.Hero.SettingDropIsOpen)
    private int settingDropIsOpen;

    @AttrField(Attr.Hero.UseWeatherItemTime)
    private int useWeatherItemTime;

    @AttrField(Attr.Hero.MonsterSlainRewardState)
    private String monsterSlainRewardState;

    @AttrField(Attr.Hero.BossDuplicateShareLimit)
    private int bossDuplicateShareLimit;

    @AttrField(Attr.Hero.ChapterLuckyRound)
    private int chapterLuckyRound;

    @AttrField(Attr.Hero.GmFuncUnlockOpen)
    private int gmFuncUnlockOpen;

    @AttrField(Attr.Hero.PrivilegeCardId)
    private int privilegeCardId;

    @AttrField(Attr.Hero.NewServerScore)
    private int newServerScore;

    @AttrField(Attr.Hero.CurHeroTitleId)
    private int curHeroTitleId;

    @AttrField(Attr.Hero.RepelCount)
    private int repelCount;

    @AttrField(Attr.Hero.RepelEvilChallengeTimes)
    private int repelEvilChallengeTimes;

    @AttrField(Attr.Hero.CommentRewardReceiveStatus)
    private int commentRewardReceiveStatus;

    @AttrField(Attr.Hero.ResPackageRewardState)
    private int resPackageRewardState;

    @AttrField(Attr.Hero.TotalMailCount)
    private int totalMailCount;

    @AttrField(Attr.Hero.HandUpLotteryCount)
    private int handUpLotteryCount;

    @AttrField(Attr.Hero.HandUpCoin)
    private int handUpCoin;

    @AttrField(Attr.Hero.DuplicateMatchId)
    private int duplicateMatchId;

    @AttrField(Attr.Hero.DuplicateMatchType)
    private int duplicateMatchType;

    @AttrField(Attr.Hero.DuplicateMatchStartTime)
    private int duplicateMatchStartTime;

    @AttrField(Attr.Hero.FreeGiftStatus)
    private int freeGiftStatus;

    @AttrField(Attr.Hero.UserBagStoredTimes)
    private int userBagStoredTimes;

    @AttrField(Attr.Hero.DestinyResetStatus)
    private int destinyResetStatus;

    @AttrField(Attr.Hero.WeeklyBossFightCount)
    private int weeklyBossFightCount;
}
