package com.game.attr;

/**
 * 属性常量定义
 * 所有Obj拥有的属性、基本属性、战斗属性等常量
 */
public interface Attr {

    /**
     * 所有Obj拥有属性
     */
    interface Obj {
        /** 对象类型 */
        int ObjType = 1;
        /** 对象子类型 */
        int SubObjType = 2;
        /** 显示的名称 */
        int DisplayName = 3;
        /** 名字颜色 */
        int NameColor = 4;
        /** 生物状态 (0=活着 1=死亡) */
        int Status = 5;
        /** 外观, 当人物骑宠或变身也用这个值表示所寄宠物编号或变身后外观 */
        int Appr = 6;
        /** 当前动作，需要的话 */
        int Action = 7;
        /** 出现特效 1=显示特效 0=无特效 */
        int AppearEffect = 8;
    }

    /**
     * 基本属性 继承自Obj
     */
    interface Base extends Obj {
        /** 性别 1男 2女 */
        int Sex = 52;
        /** 等级 */
        int Level = 53;
        /** 模型id */
        int ModelId = 54;
        /** 发型id */
        int HairId = 55;
        /** 角色_眼睛 */
        int Eye = 56;
        /** 身体id */
        int BodyId = 57;
    }

    /**
     * 战斗属性 继承自Base
     */
    interface Battle extends Base {
        /** 气血 */
        int HpMax = 110;
        /** 当前气血 */
        int CurHp = 111;
        /** 基础气血 */
        int BaseHp = 112;
        /** 气血加成 */
        int HpPct = 113;
        /** 气血恢复 */
        int HpReg = 114;
        /** 灵力 */
        int MpMax = 115;
        /** 当前灵力 */
        int CurMp = 116;
        /** 灵力恢复 */
        int MpReg = 117;
        /** 最大攻击 */
        int DcMax = 118;
        /** 最小攻击 */
        int DcMin = 119;
        /** 攻击万分比 */
        int DcPct = 120;
        /** 防御 */
        int Ac = 121;
        /** 防御万分比 */
        int AcPct = 123;
        /** 命中 */
        int Hit = 124;
        /** 闪避 */
        int Dodge = 125;
        /** 会心 */
        int LuckyStrike = 126;
        /** 会心抗性 */
        int LuckyDef = 127;
        /** 神圣抗性 */
        int PureDef = 128;
        /** 暴击概率 */
        int CritRatio = 129;
        /** 暴击伤害 */
        int CritDam = 130;
        /** 暴击抗性 */
        int CritRatioDef = 131;
        /** 暴伤减免 */
        int CritDamDef = 132;
        /** 灵根-金 */
        int JinAtk = 133;
        /** 灵根-木 */
        int MuAtk = 134;
        /** 灵根-水 */
        int ShuiAtk = 135;
        /** 灵根-火 */
        int HuoAtk = 136;
        /** 灵根-土 */
        int TuAtk = 137;
        /** 灵根抗性 */
        int EleDef = 138;

        /** 万分比伤害 */
        int DamPct = 170;
        /** 对人族伤害万分比 */
        int DamPctPeople = 171;
        /** 对妖族伤害万分比 */
        int DamPctElf = 172;
        /** 对魔族伤害万分比 */
        int DamPctEvil = 173;
        /** 对仙族伤害万分比 */
        int DamPctFariy = 174;
        /** 对灵族伤害万分比 */
        int DamPctSpirit = 175;
        /** 对同性伤害万分比 */
        int DamPctSameSex = 176;
        /** 对异性伤害万分比 */
        int DamPctDiffSex = 177;
        /** 万分比抗性 */
        int DefPct = 180;
        /** 对人族抗性万分比 */
        int DefPctPeople = 181;
        /** 对妖族抗性万分比 */
        int DefPctElf = 182;
        /** 对魔族抗性万分比 */
        int DefPctEvil = 183;
        /** 对仙族抗性万分比 */
        int DefPctFariy = 184;
        /** 对灵族抗性万分比 */
        int DefPctSpirit = 185;
        /** 固定吸血 */
        int BloodLust = 200;
        /** 万分比吸血 */
        int BloodLustPct = 201;
        /** 移动速度 */
        int MoveSpeed = 202;
        /** 当前移速 */
        int CurMoveSpeed = 203;
        /** 移速加成 */
        int MoveSpeedPct = 204;
        /** 释放速度 */
        int MagicSpeed = 205;
        /** 技能急速 */
        int Haste = 206;
        /** 技能急速转换出的冷却缩减万分比 */
        int Haste_Pct = 320;
        /** 技能状态 */
        int SkillStep = 207;
        /** 当前释放技能id */
        int SkillId = 208;
        /** 破甲 */
        int ApPct = 209;
        /** 破甲概率 */
        int ApRatio = 210;
        /** 护盾 */
        int Shield = 211;

        /** 金属性伤害增加 */
        int DamJin = 212;
        /** 木属性伤害增加 */
        int DamMu = 213;
        /** 水属性伤害增加 */
        int DamShui = 214;
        /** 火属性伤害增加 */
        int DamHuo = 215;
        /** 土属性伤害增加 */
        int DamTu = 216;
        /** 金属性伤害百分比增加 */
        int DamPctJin = 225;
        /** 木属性伤害百分比增加 */
        int DamPctMu = 226;
        /** 水属性伤害百分比增加 */
        int DamPctShui = 227;
        /** 火属性伤害百分比增加 */
        int DamPctHuo = 228;
        /** 土属性伤害百分比增加 */
        int DamPctTu = 229;
        /** 金属性伤害减少 */
        int DefJin = 238;
        /** 木属性伤害减少 */
        int DefMu = 239;
        /** 水属性伤害减少 */
        int DefShui = 240;
        /** 火属性伤害减少 */
        int DefHuo = 241;
        /** 土属性伤害减少 */
        int DefTu = 242;
        /** 金属性伤害百分比减少 */
        int DefPctJin = 251;
        /** 木属性伤害百分比减少 */
        int DefPctMu = 252;
        /** 水属性伤害百分比减少 */
        int DefPctShui = 253;
        /** 火属性伤害百分比减少 */
        int DefPctHuo = 254;
        /** 土属性伤害百分比减少 */
        int DefPctTu = 255;
        /** 治疗效果降低 */
        int DefCure = 264;

        /** 精通-剑 */
        int TechSword = 280;
        /** 剑伤害增加 */
        int DamSword = 281;
        /** 剑伤害百分比增加 */
        int DamPctSword = 282;
        /** 剑伤害减少 */
        int DefSword = 283;
        /** 剑伤害百分比减少 */
        int DefPctSword = 284;
        /** 精通-刀 */
        int TechKnife = 285;
        /** 刀伤害增加 */
        int DamKnife = 286;
        /** 刀伤害百分比增加 */
        int DamPctKnife = 287;
        /** 刀伤害减少 */
        int DefKnife = 288;
        /** 刀伤害百分比减少 */
        int DefPctKnife = 289;
        /** 精通-锤 */
        int TechHammer = 290;
        /** 锤伤害增加 */
        int DamHammer = 291;
        /** 锤伤害百分比增加 */
        int DamPctHammer = 292;
        /** 锤伤害减少 */
        int DefHammer = 293;
        /** 锤伤害百分比减少 */
        int DefPctHammer = 294;
        /** 精通-枪 */
        int TechSpear = 295;
        /** 枪伤害增加 */
        int DamSpear = 296;
        /** 枪伤害百分比增加 */
        int DamPctSpear = 297;
        /** 枪伤害减少 */
        int DefSpear = 298;
        /** 枪伤害百分比减少 */
        int DefPctSpear = 299;
        /** 精通-拳 */
        int TechBoxing = 300;
        /** 拳伤害增加 */
        int DamBoxing = 301;
        /** 拳伤害百分比增加 */
        int DamPctBoxing = 302;
        /** 拳伤害减少 */
        int DefBoxing = 303;
        /** 拳伤害百分比减少 */
        int DefPctBoxing = 304;
        /** 精通-符 */
        int TechTally = 305;
        /** 符伤害增加 */
        int DamTally = 306;
        /** 符伤害百分比增加 */
        int DamPctTally = 307;
        /** 符伤害减少 */
        int DefTally = 308;
        /** 符伤害百分比减少 */
        int DefPctTally = 309;
        /** 精通-盾 */
        int TechShield = 310;
        /** 盾伤害增加 */
        int DamShield = 311;
        /** 盾伤害百分比增加 */
        int DamPctShield = 312;
        /** 盾伤害减少 */
        int DefShield = 313;
        /** 盾伤害百分比减少 */
        int DefPctShield = 314;
        /** 精通-印 */
        int TechSeal = 315;
        /** 印伤害增加 */
        int DamSeal = 316;
        /** 印伤害百分比增加 */
        int DamPctSeal = 317;
        /** 印伤害减少 */
        int DefSeal = 318;
        /** 印伤害百分比减少 */
        int DefPctSeal = 319;

        /** 技能死亡凝视状态--移动会造成伤害技能 0无状态 1影响中 */
        int SkillEyeStatus = 1393;
    }

    /**
     * 词条属性 继承自Battle
     */
    interface Affix extends Battle {
        /** 释放距离增加 */
        int Distance = 701;
        /** 吟唱时间缩短 */
        int ReadyTime = 702;
        /** 持续施法时间增加 */
        int LoopTime = 703;
        /** 判定间隔缩短 */
        int DamageInterval = 704;
        /** 单次判定伤害次数增加 */
        int DamageCount = 705;
        /** 技能消耗减少 */
        int Cost = 706;
        /** CD时间减少 */
        int Cd = 707;
        /** 技能伤害固定值增加 */
        int Damage = 708;
        /** 技能伤害系数增加 */
        int DamagePct = 709;
        /** 增强额外消耗减少 */
        int ExCost = 710;
        /** 持续效果持续时间增加 */
        int ObjLoopTime = 711;
        /** 持续效果伤害固定值增加 */
        int ObjDamage = 712;
        /** 持续效果伤害系数增加 */
        int ObjDamagePct = 713;
        /** buff持续时间增加 */
        int BuffTime = 714;
        /** 中毒buff叠加上限增加 */
        int BuffPoisionLimit = 715;
    }

    /**
     * 人物属性 继承自Battle
     */
    interface Hero extends Battle {
        /** 当前经验 */
        int CurExp = 1001;
        /** 升级所需经验 */
        int ExpMax = 1002;
        /** 付费产生的游戏币(仙玉) */
        int PayCoin = 1003;
        /** 付费产生的游戏币(绑定仙玉) */
        int BindPayCoin = 1004;
        /** 游戏内产出的货币(灵石) */
        int Coin = 1005;
        /** 游戏内产出的货币(绑定灵石) */
        int BindCoin = 1006;
        /** 当前玩家最大包裹数 */
        int MaxPackage = 1008;
        /** 当前玩家最大仓库数 */
        int MaxStorage = 1009;
        /** 角色全服唯一ID */
        int PlayerID = 1010;
        /** 用户id */
        int UserId = 1037;
        /** 机缘 */
        int Lucky = 1011;
        /** 年龄 */
        int Age = 1017;
        /** 炼丹资质 */
        int TechAlchemy = 1018;
        /** 炼器资质 */
        int TechRefiner = 1019;
        /** 药材资质 */
        int TechMedicine = 1020;
        /** 风水资质 */
        int TechFengshui = 1021;

        /** 悟性 */
        int Comprehension = 1023;
        /** 健康 */
        int Healthy = 1024;
        /** 魅力 */
        int Charm = 1025;
        /** 精力 */
        int Energy = 1026;

        /** 角色_脸型 */
        int FaceShape = 1028;
        /** 角色_眉毛 */
        int Eyebrow = 1029;
        /** 角色_鼻子 */
        int Nose = 1031;
        /** 角色_嘴型 */
        int Mouth = 1032;
        /** 角色_脸饰 */
        int FaceDecoration = 1033;

        /** 创角时间 */
        int CreateRoleTime = 1034;

        /** 死亡复活次数 */
        int DailyReliveTimes = 1044;
        /** 气运 */
        int Destiny = 1055;
        /** 公会每日俸禄 */
        int GuildShopDailyReward = 1056;

        /** 已学丹方 */
        int DrugList = 1057;

        /** 神识状态 */
        int GodViewStatus = 1062;

        /** 1059 正在渡劫 */
        int RescueStatus = 1059;
        /** 1063 参与他人渡劫中 */
        int JoinRescueStatus = 1063;
        /** 渡劫准备状态 开始渡劫的时候设为1 结束渡劫的时候设为0 */
        int RescuePrepareStatus = 1064;
        /** 渡劫帮助人数 */
        int RescueHelpCount = 1065;
        /** 渡劫窃取人数 */
        int RescueDrabCount = 1066;
        /** 渡劫结束时间 */
        int RescueEndTime = 1112;
        /** 1396 参与渡劫时目标玩家ObjId */
        int JoinRescueObjId = 1396;
        /** 1397 参与渡劫类型 0-帮助渡劫 1-窃取渡劫 */
        int JoinRescueType = 1397;

        /** 拍卖进行中 1正在进行拍卖 0拍卖结束 */
        int Auctioning = 1068;

        /** 修炼速度 */
        int ExpSpeed = 1070;
        /** 地图XY */
        int MapPosX = 1073;
        int MapPosY = 1074;

        /** 精力领取 */
        int EnergyGet = 1075;
        /** 公会任务购买次数 */
        int GuildTaskBuyCount = 1078;
        /** 贡献 */
        int Contribute = 1079;

        /** 上次带入副本的药的物品id */
        int LastDrugId = 1081;
        /** 丹药次数 */
        int DrugCount = 1082;

        /** 炼体等级 */
        int BodyRefine = 1084;

        /** 寻宝副本帮助别人次数 */
        int HuntHelpCount = 1086;
        /** 复活货币 */
        int ReliveCount = 1087;
        /** 上次改名时间 */
        int HeroChangeNameCd = 1339;

        /** 资质当前 */
        int Qualifications = 1089;
        /** 资质随机中 */
        int RandomQualifications = 1089;
        /** 后天随机气运 */
        int RandomDestiny = 1091;
        /** 经验丹每日限次 */
        int ExpDrugLimit = 1092;
        /** 使用增加属性物品的使用次数 */
        int ItemUseTimesWithAddAttr = 1093;
        /** 通用法宝精通 */
        int Tech = 1094;
        /** 通用五行资质 */
        int Ele = 1095;
        /** 充值赠送 */
        int RechargeGive = 1100;
        /** 充值获得的道具数量 */
        int RechargeItemNum = 1102;
        /** 首冲奖励领取时间 */
        int FirstRechargeAwardAt = 1103;
        /** 千机令 寻宝获得的道具 */
        int HuntCoin = 1106;
        /** 工会名称 */
        int GuildName = 1107;
        /** 工会职位 */
        int GuildOfficeId = 1108;
        /** 炼宝异火 */
        int MagicFire = 1109;

        /** 传送阵 */
        int Transfer = 1099;

        /** 精力添加时间 */
        int EnergyAddTime = 1039;
        /** 修炼是否开始 1是开始 */
        int ExpAddBegin = 1118;

        /** 势力等级 格式：campId:value,campId:value,campId:value */
        int CampLv = 1119;

        /** 系统设置 */
        int SysSeting = 1122;
        /** 获取的个人组件信息 */
        int GainAssembly = 1124;

        /** 天赋 格式：idA,idB,idC(id为 天赋升级表|InnatLv 里的唯一id) */
        int Innat = 1126;
        /** 天赋点 */
        int InnatCount = 1129;

        /** 灵宠的连续捕捉次数 */
        int SpiritPetContinuousDrawNum = 1131;
        /** 神兽秘境的连续捕捉次数 */
        int SpiritPetSeekNumAct = 1204;
        /** 搜寻到的宠物ID */
        int SpiritPetFind = 1113;
        /** 场景表现抓宠时的灵宠Id */
        int FindDisplayPetId = 1167;
        /** 搜寻到的宠物捕捉回合 */
        int SpiritPetCatchNum = 1115;

        /** 每日传道次数 */
        int TeachCount = 1143;
        /** 每日论道次数 */
        int DiscussCount = 1144;

        /** 装备的法宝id */
        int EquipMagic = 1139;

        /** 日常活动活跃值 */
        int ActivityNum = 1140;

        /** 偷窃有没有被npc发现 value:0未发现 1发现 */
        int StealFindStatus = 1146;
        /** npc求饶的状态 0求饶 1不求饶 */
        int NpcPardonStatus = 1149;
        /** 战斗的npcIndex */
        int BattleNpcId = 1153;
        /** pvp战斗的副本Id */
        int BattlePvpDuplicateId = 1237;
        /** 爬塔的层数 */
        int TowerNum = 1156;

        /** 灵宠搜寻是否开始 0未开始，1开始 */
        int PetSearchBegin = 1161;
        /** 搜寻到的灵宠位置 mapId:x:y */
        int PetSearchPos = 1164;
        /** 灵宠捕捉结果状态 0成功 1逃跑 2失败 */
        int PetCatchStatus = 1165;
        /** 灵宠捕捉使用道具 */
        int PetCatchItemId = 1166;
        /** 灵宠上一次搜寻的参数 */
        int SpiritLastSearchParam = 1135;
        /** 神兽秘境灵宠上一次搜寻的参数 */
        int SpiritLastSearchParamAct = 1204;

        /** 灵宠自动捕捉设置 */
        int PetAutoCatchSetting = 1242;

        /** 竞技场状态 0:默认 1:匹配中 2:匹配成功 3:战斗准备 4:战斗中 */
        int BattleStatus = 1173;
        /** 竞技场过程中的各种时间 */
        int BattlingTime = 1174;
        /** 竞技场剩余次数 */
        int BattleCount = 1175;
        /** 竞技场购买的次数 */
        int BattleBuyCount = 1176;
        /** 竞技场跨服id */
        int BattleCrossServerId = 1180;
        /** 竞技场跨服排名 */
        int BattleCrossRank = 1181;
        /** 竞技场每日参与次数 */
        int BattleDailyJoinCount = 1182;

        /** 爬塔的节点奖励[1,3,2] */
        int TowerReward = 1158;
        /** 扫荡的次数 */
        int TowerSweep = 1159;
        /** 镇妖塔扫荡购买次数 */
        int TowerSweepBuyTimes = 1230;
        /** 禁言解冻时间 */
        int ChatUnFreezeTime = 1163;
        /** 战斗设置的保存内容 */
        int BattleSetingData = 1170;
        /** 挂机经验 */
        int HExpLimit = 1171;

        /** 当前自然之力 */
        int CurNature = 1238;
        /** 自然之力基础值 */
        int BaseNature = 1239;

        /** 仙遗抽奖下次单抽免费时间戳(单位:秒) */
        int AncientLotteryNextFreeTime = 1329;
        /** 仙遗抽奖已使用单抽免费次数 */
        int AncientLotteryUsedFreeTimes = 1330;
        /** 仙遗抽奖已抽卡次数 */
        int AncientLotteryTimes = 1411;
        /** 已许愿次数 */
        int AncientLotteryWishTimes = 1406;
        /** 许愿奖励id */
        int AncientLotteryWishId = 1407;

        /** 天剑精粹 */
        int CampCount14 = 1190;
        /** 百川精粹 */
        int CampCount15 = 1191;
        /** 百瘴精粹 */
        int CampCount16 = 1192;
        /** 北岭精粹 */
        int CampCount17 = 1193;
        /** 天剑仙晶 */
        int CampCount18 = 1194;
        /** 百川仙晶 */
        int CampCount19 = 1195;
        /** 百瘴仙晶 */
        int CampCount20 = 1196;
        /** 北岭仙晶 */
        int CampCount21 = 1197;

        /** 挑战令牌 */
        int RepelCount = 1198;

        /** 绑定仙玉 */
        int FairyCrystal = 1395;

        /** 梦入仙途货币 */
        int GodAreaMoneyCoin = 1418;

        /** 梦入仙境当前位置 */
        int GodAreaNowGrid = 1183;
        /** 梦入仙途 功能货币 */
        int GodAreaCoin = 1206;
        /** 梦入仙途 货币 */
        int GodAreaShopCoin = 1209;
        /** 梦入仙途 货币 */
        int GodAreaScoreCoin = 1210;
        /** 梦入仙途已抽奖几次 */
        int GodAreaLotteryTimes = 1310;
        /** 梦入仙途已抽奖几次 保底了会重置 */
        int GodAreaLotteryGuarantee = 1311;

        /** 法宝当前方案 id */
        int MagicWeaponCurrent = 1218;
        /** 拾取掉落是否开始 默认0为开启 1为不开启 */
        int SettingDropIsOpen = 1220;

        /** 使用天气道具的时间 */
        int UseWeatherItemTime = 1219;

        /** 当前应用的战斗方案id */
        int BattlePlanId = 1236;

        /** 骑乘状态,  0不在骑乘 1乘船状态 2坐骑状态 */
        int RideState = 1243;
        /** 船的等级 */
        int BoatLevel = 1244;
        /** 骑乘的坐骑的id */
        int RideId = 1245;
        /** 坐骑的死亡时间 */
        int RideDeathTime = 1247;
        /** 坐骑的当前状态( 0=活着 1=死亡) */
        int RideStatus = 1248;
        /** 坐骑的当前气血 */
        int RideCurHp = 1249;
        /** 坐骑的气血总值 */
        int RideHpMax = 1250;

        /** 1398 骑乘状态-战斗中,  0不在骑乘,  1 坐骑状态 */
        int BattleRideState = 1398;

        /** 斩妖录奖励领取信息 */
        int MonsterSlainRewardState = 1246;
        /** 人物npc词条设置 */
        int NpcAffixSetting = 1258;
        /** npc免费双修次数（所有npc共用） */
        int NpcFreeCultivateNum = 1257;

        /** 人物战力 */
        int CombatValue = 1259;
        /** 洞府等级 */
        int CaveLevel = 1266;
        /** 洞府名字 */
        int CaveName = 1274;
        /** 金元 */
        int MetalEle = 1275;
        /** 木元 */
        int WoodEle = 1276;
        /** 水元 */
        int WaterEle = 1277;
        /** 火元 */
        int FireEle = 1278;
        /** 土元 */
        int EarthEle = 1279;

        /** boss副本共用限次已用次数 */
        int BossDuplicateShareLimit = 1264;

        /** 章节(升仙录)机缘抽奖池round */
        int ChapterLuckyRound = 1262;

        /** 功能开关是否解锁(GM使用) 0关闭 1开启 */
        int GmFuncUnlockOpen = 1300;
        /** 上一次骑乘的坐骑idx */
        int LastRideId = 1299;

        /** 特权卡id(等级),0表示未激活 */
        int PrivilegeCardId = 1298;

        /** 本服竞技场状态 0:默认 1:匹配中 2:匹配成功 3:战斗准备 4:战斗中 */
        int LocalBattleStatus = 1288;
        /** 本服竞技场过程中的各种时间 */
        int LocalBattlingTime = 1288;
        /** 本服竞技场剩余次数 */
        int LocalBattleCount = 1289;
        /** 本服竞技场购买的次数 */
        int LocalBattleBuyCount = 1290;
        /** 本服竞技场版本号 */
        int LocalBattleVersion = 1291;
        /** 本服竞技场每日任务 */
        int LocalBattleDailyTask = 1292;
        /** 本服竞技场赛季任务 */
        int LocalBattleTask = 1293;
        /** 本服竞技场每日参与次数 */
        int LocalBattleDailyJoinCount = 1296;
        /** 本服竞技场每日是否参加过 */
        int LocalBattleTodayIsBattle = 1303;
        /** 本服竞技场积分 */
        int LocalBattleScoreMoney = 1334;
        /** 本服竞技场积分 */
        int HandUpCoin = 1404;

        /** 新服目标活动积分 */
        int NewServerScore = 1285;

        /** 时装-套装 */
        int FashionSuit = 1316;
        /** 时装-发型 */
        int FashionHair = 1317;
        /** 时装-脸饰 */
        int FashionFaceDecoration = 1318;
        /** 时装-衣裳 */
        int FashionClothes = 1319;

        /** 当前佩戴的称号id */
        int CurHeroTitleId = 1313;

        /** 梦入仙途战令当前总的经验 */
        int GodAreaBattleOrderExp = 1241;
        /** 异火抽奖幸运值 */
        int MagicFireLotteryLuckyValue = 1322;
        /** 异火抽奖幸运值类型 */
        int MagicFireLotteryLuckyType = 1324;
        /** 异火抽奖剩余时间 */
        int MagicFireLotteryStartTime = 1323;
        /** 异火抽奖当前倍率 */
        int MagicFireLotteryMultiple = 1340;
        /** 当前穿戴的异火融合技能 */
        int MagicFireSkillId = 1327;

        /** 当前穿戴的异火融合技能 */
        int EquipSelfMagicShow = 1343;

        /** 坐骑图鉴经验值 */
        int RideBookExp = 1353;
        /** 坐骑图鉴等级 */
        int RiderBookLv = 1354;
        /** 伙伴图鉴经验值 */
        int NpcBookExp = 1347;
        /** 伙伴图鉴等级 */
        int NpcBookLv = 1348;
        /** 心法图鉴经验 */
        int HeartBookExp = 1355;
        /** 心法图鉴等级 */
        int HeartBookLv = 1356;
        /** 本命法宝图鉴经验值 */
        int SelfWeaponBookExp = 1349;
        /** 本命法宝图鉴等级 */
        int SelfWeaponBookLv = 1350;
        /** 异火图鉴经验值 */
        int MagicFireBookExp = 1351;
        /** 异火图鉴等级 */
        int MagicFireBookLv = 1352;
        /** 下一次npc切换的时间 */
        int NextNpcSwitchTime = 1368;
        /** 势力每日任务已接取次数（前一天接的不算） */
        int CampDailyTaskAcceptNum = 1442;
        /** 势力每日任务刷新次数 */
        int CampTaskRefreshNum = 1364;
        /** taptap评价奖励领取状态 1-已领取 */
        int CommentRewardReceiveStatus = 1392;
        /** 镇妖塔挂机开始时间 */
        int TowerHangUpStartTime = 1387;
        /** 镇妖塔已购买次数 */
        int TowerHangUpBuyCount = 1390;

        /** 预下载奖励领取状态:1 已领取，0 未领取 */
        int ResPackageRewardState = 1397;
        /** 邮件数量 */
        int TotalMailCount = 1400;

        /** 须臾幻境抽奖-刹影幻藏 累计抽奖次数 */
        int HandUpLotteryCount = 1415;

        /** 正在匹配的副本id */
        int DuplicateMatchId = 1412;
        /** 正在匹配的副本类型 取Logic.DuplicateType */
        int DuplicateMatchType = 1413;
        /** 匹配开始时间(单位:秒) */
        int DuplicateMatchStartTime = 1413;

        /** 免费礼遇奖励发放状态，1：已发放，0：未发放 */
        int FreeGiftStatus = 1410;
        /** 充值返利金额 */
        int RechargeRebateValue = 1420;
        /** 纳戒空间存放次数 */
        int UserBagStoredTimes = 1425;
        /** 先天气运重置状态 */
        int DestinyResetStatus = 1428;
        /** 诛魔却邪已挑战次数 */
        int RepelEvilChallengeTimes = 1430;
        /** 周常boss挑战次数 */
        int WeeklyBossFightCount = 1437;

        /** 角色充值次数 */
        int RoleRechargeCount = 1443;
    }

    /**
     * 竞技场状态
     */
    interface BattleStatus {
        /** 默认 未参与 */
        int DEFAULT = 0;
        /** 匹配中 */
        int MATCHING = 1;
        /** 匹配成功 准备连接 */
        int PREPARE = 2;
        /** 战斗准备 */
        int READY = 3;
        /** 战斗中 */
        int BATTLE = 4;
    }

    /**
     * 怪物属性 继承自Battle
     */
    interface Monster extends Battle {
        /** 怪物编号 */
        int MonsterIdx = 5001;
        /** 怪物类型:0.普通 1.精英 2.BOSS 3.召唤物 */
        int GradeType = 5002;
        /** 怪物类别(对应不同表) */
        int MonsterType = 5003;
        /** 仙门大比随机的怪物名称 */
        int MonsterName = 5004;
        /** 机器人id */
        int RobotId = 12001;
    }

    /**
     * 物品属性 继承自Battle
     */
    interface Item extends Battle {
        /** 道具类别（区分普通道具，装备，技能书） */
        int ItemType = 8051;
        /** 道具ID */
        int ItemIdx = 8052;
        /** 物品流水号 */
        int ItemId = 8053;
        /** 数量 */
        int Count = 8054;
        /** 包裹或仓库存放位置 */
        int SavePos = 8055;
        /** 配置绑定标记 0bit=1 内绑定; 1bit=1 不可丢弃; 2bit=1 不可存仓 */
        int Bound = 8056;
        /** 是否可以叠加 大于0就是可叠加的上限 */
        int AddLimit = 8057;
        /** 物品在地上属于的人POINTID */
        int ItemOwner = 8059;
        /** 词缀属性 */
        int Affix = 8060;
        /** 洗练词缀属性 */
        int RandomAffix = 8062;
        /** 使用次数 */
        int Dura = 8063;
        /** 装备强化等级 */
        int StrengthenLevel = 8065;
        /** 法宝凝练经验 */
        int ConciseExp = 8067;
        /** 寻宝状态 1是开启 */
        int HuntStatus = 8068;
        /** 寻宝x坐标 */
        int HuntPosX = 8069;
        /** 寻宝y坐标 */
        int HuntPosY = 8070;
        /** 装备位置 */
        int EquipPos = 8071;
        /** 器灵等级 */
        int SpiritLv = 8072;
        /** 器灵稳定值 */
        int SpiritStable = 8073;
        /** 绑定的器灵id */
        int BoundSpiritId = 8074;
        /** 器灵技能id */
        int SpiritSkillId = 8075;
        /** 炼化保存 */
        int LianHuaTemp = 8077;
        /** 法宝随机属性 */
        int WeaponProp = 8084;

        /** 炼宝 基础属性 */
        int LianBaoRandomProp = 8078;
        /** 炼宝额外属性 */
        int LianBaoProp = 8066;
        /** 炼宝天才地宝 */
        int LianBaoWorld = 8080;
        /** 原生属性 */
        int LianBaoPropLib = 8079;
        /** 天才地宝效果 */
        int WeaponEffect = 8085;
        /** 心法等级 */
        int HeartLevel = 8086;

        /** 炼宝异火 */
        int FireAffix = 8087;

        /** 品质 */
        int RealQuality = 8082;

        /** 是否是npc求饶道具 0不是 1是 */
        int IsNpcPardon = 8088;

        /** 法宝星级 */
        int MagicLevel = 8089;
        /** 本命法宝星级 */
        int SelfWeaponStar = 8097;
        /** 异火星级 */
        int MagicFireLevel = 8098;

        /** 道具创建时间 */
        int CreateTime = 8064;
        /** 已领取的图鉴经验值 */
        int ReceivedBookExp = 8103;
        /** 角色装备强化等级(初始为0级) */
        int HeroEquipLevel = 8101;
        /** 角色装备破碎状态(0-未破碎,1-已破碎) */
        int HeroEquipBroken = 8102;

        /** 器灵已破碎(0-未破碎,1-已破碎) */
        int SpiritIsBroken = 8104;
        /** 角色装备随机属性（包括npc装备） */
        int HeroEquipProp = 8105;
    }

    /**
     * 地面对象属性 继承自Battle
     */
    interface Floor extends Battle {
        /** Floor属性起始标记 */
        int FLOOROBJ_START = 10000;

        /** 释放技能id */
        int ReleaseSkillId = 10001;
        /** 目标 */
        int TargetObjId = 10002;
        /** 目标 */
        int SourceObjId = 10003;
        /** 起始角度 */
        int BeginAngle = 10004;
        /** 技能物的类型 */
        int ReleaseSkillType = 10005;
        /** 技能物的下标索引 */
        int SkillObjIndex = 10006;

        /** Floor属性结束标记 */
        int FLOOROBJ_END = 11000;
    }

    /**
     * 灵宠属性 继承自Battle
     */
    interface Pet extends Battle {
        /** 灵宠id */
        int PetId = 11001;
        /** 灵宠名字 */
        int PetName = 11003;
        /** 灵宠境界 */
        int PetGrade = 11004;
        /** 灵宠经验 */
        int PetExp = 11005;
        /** 灵宠是否上阵 0未上阵 1上阵 */
        int PetIsBattle = 11006;
        /** 灵巧 */
        int PetQuick = 11007;
        /** 烈性 */
        int PetViolent = 11008;
        /** 护甲 */
        int PetShield = 11009;
        /** 体魄 */
        int PetPhysique = 11010;
        /** 速度 */
        int PetSpeed = 11011;
        /** 潜力 */
        int PetPotential = 11013;
        /** 技能 */
        int PetSkill = 11016;
        /** 已装备技能 */
        int PetEquipSkill = 11017;
        /** 主人 */
        int HostObjId = 4001;
        /** 灵宠失败增加的概率 */
        int PetAddRate = 11012;
        /** 死亡时间 */
        int DeathTime = 4002;
        /** 加入图鉴标记(0 为加入，1 加入) */
        int PetBookTag = 11019;
        /** 灵宠是否可激活(0 可激活， 1 不可激活) */
        int PetActiva = 11020;
        /** 灵宠品阶 */
        int PetCrude = 11022;
        /** 灵宠升品返回成功率 */
        int PetReturnProb = 11021;
        /** 灵宠是否可以交易（交易行通过这个判定） */
        int PetIsTrain = 11023;
        /** 灵宠是否绑定（是否可交易增加这个判定）(1 已绑定，0没绑定) */
        int PetBind = 11026;
        /** 灵宠喂食记录，字符串五维属性:num,五维属性:num,... 服务器返回的字符串末尾有个逗号 */
        int PetFoodAttr = 11025;
        /** 工作中的建筑id,0表示不在工作中 */
        int PetBuildingId = 11033;
        /** 工作中的位置,0表示不在工作中,工作位置从1开始 */
        int PetBuildingPos = 11034;
        /** 洞府建筑生产周期,秒数,正数为增加,负数为减少 */
        int PetBPPeriod = 11035;
        /** 洞府建筑的生产速度 */
        int PetBPSpeed = 11036;
        /** 洞府建筑生产速度提升万分比 */
        int PetBPSpeedPct = 11037;
        /** 灵宠词条 id,id, */
        int PetAffix = 11043;
        /** 灵宠战力 */
        int CombatValue = 1259;
    }

    /**
     * Npc属性 继承自Battle
     */
    interface Npc extends Battle {
        /** 对应NpcRef表中Index字段并非Id字段 */
        int NpcIndex = 7001;
        /** npc好感度 */
        int NpcLikability = 7002;
        /** Npc修为 */
        int NpcExp = 7003;
        /** Npc小境界 */
        int NpcGrade = 7003;
        /** npc结缘状态(0-未结缘 1-已结缘) */
        int NpcBecomeLove = 7049;
        /** npc是否是伙伴 (0-未成为伙伴 1-已成为伙伴) */
        int NpcIsFriend = 7050;
        /** npc是否上阵 0未上阵 1主阵 2副阵 */
        int NpcIsBattle = 7005;
        /** npc状态 0存活 1死亡 */
        int NpcStatus = 7006;
        /** npc标记 0未标记 1标记 */
        int NpcMark = 7007;
        /** npc结缘时间 */
        int NpcBecomeLoveAt = 7009;
        /** npc切磋时间 */
        int NpcChallengeAt = 7014;
        /** npc索要时间 */
        int NpcAskForGiftAt = 7010;
        /** npc偷窃时间 */
        int NpcStealAt = 7017;
        /** npc每日传道次数 */
        int NpcTeachCount = 7015;
        /** npc每日论道次数 */
        int NpcDiscussCount = 7016;
        /** npc偷袭时间 */
        int NpcSneakAttackAt = 7019;
        /** 突破失败成功率补偿 */
        int NpcAddRate = 7021;
        /** npc品阶level(不是对应品阶) */
        int NpcPeriod = 7024;
        /** 主人 */
        int HostObjId = 7024;
        /** npc 脸型 */
        int FaceShape = 1028;
        /** 死亡时间 */
        int DeathTime = 4002;
        /** npc上阵位置 */
        int NpcPos = 7031;
        /** npc灵巧 */
        int NpcQuick = 7026;
        /** npc烈性 */
        int NpcViolent = 7027;
        /** npc护甲 */
        int NpcShield = 7028;
        /** npc体魄 */
        int NpcPhysique = 7029;
        /** npc速度 */
        int NpcSpeed = 7030;
        /** 是否请教过 0 未请教 1请教过了 */
        int NpcIsConsult = 7034;
        /** 是否已比武 0 未比武, 1 已比武 */
        int NpcCombatState = 7035;
        /** npc扫荡剩余次数 */
        int NpcSweep = 7036;
        /** npc扫荡购买次数 */
        int NpcSweepBuyTimes = 7037;
        /** 付费双修次数 */
        int NpcPayCultivateNum = 7033;
        /** npc炼体等级 */
        int NpcBodyRefine = 7042;
        /** npc使用了的道具 第几个index:itemNum,第几个index:itemNum */
        int NpcUsedItem = 7043;
        /** 求饶的道具index */
        int NpcPardonItemIndex = 7044;
        /** Npc战力 */
        int CombatValue = 1259;
        /** 已领取的伙伴图鉴经验值 */
        int ReceivedBookExp = 8103;
    }

    /**
     * 坐骑属性 继承自Battle
     */
    interface Ride extends Battle {
        /** 坐骑骑行状态 0未骑行 1骑行状态 */
        int RideWearStatus = 8091;
        /** 坐骑等级 */
        int RideLevel = 8092;
        /** 坐骑的经验 */
        int RideExp = 8095;
        /** 坐骑属性转化率 */
        int RideAttrRate = 8093;
        /** 坐骑星级 */
        int RideStar = 8094;
        /** 坐骑Id */
        int RideItemId = 8096;
        /** 坐骑气血恢复 */
        int RideHpReg = 8099;
        /** 已领取的坐骑图鉴经验值 */
        int ReceivedBookExp = 8103;
    }

    /**
     * 幻象属性 继承自Battle
     */
    interface Vision extends Battle {
        /** 主人 */
        int HostObjId = 4001;
        /** 装备的法宝id */
        int EquipMagic = 1139;
        /** 通过哪个技能造出的幻象 */
        int BySkillId = 4003;
        /** 坐骑的当前状态( 0=活着 1=死亡) */
        int RideStatus = 1248;
        /** 骑乘的坐骑的id */
        int RideId = 1245;
        /** 时装-套装 */
        int FashionSuit = 1316;
        /** 时装-发型 */
        int FashionHair = 1317;
        /** 时装-脸饰 */
        int FashionFaceDecoration = 1318;
        /** 时装-衣裳 */
        int FashionClothes = 1319;
    }

    /**
     * 属性分类
     */
    interface Category {
        /** 基础属性 */
        int Base = 1;
        /** 进阶 */
        int Advance = 2;
        /** 特殊 */
        int Special = 3;
        /** 强化 */
        int Strength = 4;
        /** 套装 */
        int Suit = 5;
        /** 打造 */
        int Make = 6;
        /** 需求属性 */
        int Condition = 7;
        /** 技能属性 */
        int Skill = 8;
        /** 皮肤属性 */
        int Skin = 9;
        /** 魂印属性 */
        int SOUL = 10;
        /** 极品属性 */
        int Nonsuch = 11;
        /** 战斗属性 */
        int Combat = 12;
        /** 人物属性 */
        int Hero = 13;
        /** 精通属性 */
        int Adept = 14;
        /** 灵宠属性 */
        int Pet = 15;
    }

    /**
     * 副本类型
     */
    interface DuplicateType {
        /** 副本 */
        int Duplicate = 1;
        /** 世界boss副本 */
        int WorldBoss = 2;
        /** 日常boss副本 */
        int DailyBoss = 3;
        /** 个人副本 */
        int PDuplicate = 4;
        /** 挂机副本 */
        int HDuplicate = 5;
        /** 爬塔副本 */
        int TDuplidate = 6;
        /** 寻宝副本 */
        int HuntDuplicate = 7;
        /** 势力挑战 */
        int GuildDuplicate = 8;
        /** 法宝护主 */
        int RescueSaving = 9;
        /** 挑战副本 */
        int Challenge = 10;
        /** npc切磋副本 */
        int NpcCompete = 11;
        /** npc寻仇副本 */
        int NpcSteal = 12;
        /** npc偷窃副本 */
        int NpcRevenge = 13;
        /** npc偷袭副本 */
        int NpcSneakAttack = 14;
        /** 论剑 */
        int LunJian = 15;
        /** 梦入仙途 */
        int GodArea = 16;
        /** 诛魔却邪 */
        int RepelEvil = 17;
        /** 奇遇副本 */
        int Meet = 18;
        /** npc比武副本 */
        int NpcCombat = 19;
        /** npc比武副本 */
        int LocalBattle = 20;
        /** 材料副本 */
        int Material = 21;
        /** 周长boss副本 */
        int WeeklyBoss = 22;
    }

    /**
     * 服务器效果类型
     */
    interface ServerEffectType {
        /** 增加伤害效果 */
        int AddDamage = 1;
    }

    /**
     * 灵宠属性分组 - 按照属性类别分组
     */
    interface PetProperty {
        /**
         * 灵宠基础属性组
         */
        int[] PET_BASE_ATTRS = {
            Pet.PetQuick,
            Pet.PetViolent,
            Pet.PetShield,
            Pet.PetPhysique,
            Pet.PetSpeed,
            Pet.PetPotential
        };

        /**
         * 灵宠战斗属性组
         */
        int[] COMBAT_ATTRS = {
            Battle.HpMax,
            Battle.HpPct,
            Battle.DcMin,
            Battle.DcMax,
            Battle.DcPct,
            Battle.Ac,
            Battle.AcPct,
            Battle.Hit,
            Battle.Dodge,
            Battle.HpReg,
            Battle.LuckyStrike,
            Battle.LuckyDef,
            Battle.CritRatio,
            Battle.CritDam,
            Battle.CritRatioDef,
            Battle.CritDamDef,
            Battle.EleDef,
            Battle.DamPct,
            Battle.DefPct,
            Battle.Haste_Pct
        };
    }
}