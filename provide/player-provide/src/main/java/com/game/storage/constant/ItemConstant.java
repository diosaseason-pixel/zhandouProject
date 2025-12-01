package com.game.storage.constant;

import com.game.attr.Attr;

import java.util.Map;

public interface ItemConstant {

    /**
     * 物品类型
     */
    interface Type {
        int UNKNOW = 0;         // 未知(概念上需要 别删除!!!)
        int PROP = 1;           // 道具
        int EQUIP = 2;          // 炼体装备
        int WEAPON = 3;         // 法宝
        int HEART = 4;          // 心法
        int SPIRIT = 5;         // 器灵

        int NPC_WEAPON = 6;     // NPC法宝
        int RIDE = 7;           // 坐骑
        int HEROEQUIP = 8;      // 角色装备
        int SELF_WEAPON = 9;    // 本命法宝
        int MAGIC_FIRE = 10;    // 异火

        int PET = 1001;         // 寄售行中才会使用
    }

    /**
     * 存储类型
     */
    interface StorageType {
        int PACKAGE = 1;        // 背包
        int EQUIPWEAR = 2;      // 炼体装备
        int DEPOT = 3;          // 仓库区
        int HEART = 4;          // 心法存储区
        int HEARTWEAR = 5;      // 心法穿着区
        int WEAPONWEAR = 6;     // 法宝穿着区
        int HEROEQUIPWEAR = 7;  // 角色装备穿着区
        int SELF_WEAPON_WEAR = 8;   // 本命法宝穿着区
        int MAGIC_FIRE_WEAR = 9;    // 异火穿戴区
        int PUBLIC_SPACE = 11;      // 空间纳戒-账户装备法术公共存储区
    }

    /**
     * NPC存储类型
     */
    interface NpcStorageType {
        int PACKAGE = 1;                // 背包
        int EQUIPWEAR = 2;              // 炼体装备
        int HEART = 4;                  // 心法存储区
        int HEARTWEAR = 5;              // 心法穿着区
        int WEAPONWEAR = 6;             // 法宝穿着区
        int HEROEQUIPWEAR = 7;          // 角色装备穿着区
        int SELF_WEAPON_WEAR = 8;       // 本命法宝穿着区
        int EXCLUSIVE_WEAPON_WEAR = 10; // 专属法宝穿戴区（服务器的存储类型不分人、npc，9已经用了）
    }

    /**
     * 宠物存储类型
     */
    interface PetStorageType {
        /**
         * 本命法宝穿着区
         */
        int SELF_WEAPON_WEAR = 8;
    }

    /**
     * 道具大类
     */
    interface Kind {
        int MAT = 1;                     // 材料
        int CHOOSE = 2;                  // 单选道具类(玩家自主选择物品)
        int RANDOM = 3;                  // 随机道具类(系统随机分配物品)
        int PACK = 4;                    // 包裹类
        int VALUE = 5;                   // 值类型道具（不进入背包）
        int DRUG = 6;                    // 药品类
        int BUFF = 7;                    // buff类
        int TRANSFER = 8;                // 传送类
        int MSG = 9;                     // 消息类
        int MAGIC = 10;                  // 炼宝材料
        int ELIXIR = 11;                 // 炼丹图鉴
        int SHOW = 12;                   // 展示道具
        int HUNTMAP = 13;                // 寻宝图
        int FIRE = 14;                   // 异火道具
        int GIFT = 15;                   // 礼物
        int HEART_DEBRIS = 16;           // 心法碎片
        int PET_DRUG = 17;               // 灵宠经验丹
        int PET_SKILL = 18;              // 灵宠技能
        int NPC_DRUG = 19;               // NPC丹药
        int ITEM_UPGRADE = 20;           // 强化道具
        int PET_TICKET = 21;             // 灵宠券
        int NPC_TICKET = 22;             // NPC道具券
        int WEATHER_ITEM = 23;           // 天气道具
        int MEET_CREATE = 24;            // 创建奇遇组件
        int NPC_JIE_YUAN = 25;           // npc结缘道具
        int NPC_DEBRIS = 26;             // npc碎片
        int RIDE_ITEM = 27;              // 坐骑道具
        int RIDE_DEBRIS = 28;            // 坐骑碎片
        int DEBRIS = 29;                 // 碎片类道具
        int SELF_WEAPON_DEBRIS = 30;     // 本命法宝碎片
        int ACTIVATE_RECHARGE = 31;      // 激活充值(月卡, 特权卡)
        int FASHION = 32;                // 时装
        int HERO_TITLE_NEED_ITEM = 33;   // 角色称号激活道具
    }

    /**
     * 材料道具小类
     */
    interface MatType {
        int DRUG = 1;                 // 药材
        int QUENCH = 2;               // 淬炼材料
        int HEART = 3;                // 心法材料
        int CONCISE = 4;              // 凝练材料
        int LUCK = 5;                 // 气运类
        int BODY = 6;                 // 炼体类
        int REFINE = 7;               // 炼化类
        int SPIRT_POUR = 8;           // 注灵
        int SECTS = 9;                // 门派
        int REPUTATION = 10;          // 声望
        int STONE = 11;               // 灵石
        int SHOVEL = 12;              // 寻宝铲子
        int FIND_PET = 13;            // 灵宠搜寻
        int CATCH_PET = 14;           // 灵宠捕捉
        int WASHING_PET = 15;         // 灵宠洗练
        int DUPLICATE = 16;           // 深渊副本券
        int PERSON_COMP = 17;         // 个人组件
        int NPC_WEAPON_MAT = 18;      // npc法宝升星材料
        int CAMP_SHOP_MAT = 19;       // 势力商店兑换材料
        int RELIVE = 20;              // 重生材料
        int TASK = 21;                // 任务材料
        int NPC_CULTIVATION = 22;     // npc双修
        int FLYING_ARTIFACT = 23;     // 御空法器
        int LOTTERY_ITEM = 24;        // 抽奖类道具
        int MAGIC_FIRE_ITEM = 25;     // 异火碎片
        int NPC_PERIOD_ITEM = 26;     // 伙伴升品万能材料
        int NPC_EXCLUSIVE_WEAPON = 27;// 伙伴专武碎片
        int STRENGTHEN_ITEM = 28;     // 强化类道具
        int REPAIR_ITEM = 29;         // 修复类道具
        int SWEEP = 30;               // 扫荡券
        int CHANGE_NAME_ITEM = 31;    // 改名道具
        int CALL_FIRE = 32;           // 召唤异火
        int WEAPON_PERCEPTION = 33;   // 法术感悟
    }

    /**
     * 单选道具小类
     */
    interface ChooseType {
        int NPC_GIFT = 1;             // npc礼物任选
    }

    /**
     * 角标种类
     */
    interface LabelType {
        int GRADE = 1;                // 凡人炼气筑基...
        int DRUG = 2;                 // 九品八品七品...
        int MAGIC_FIRE = 3;           // 九星八星七星...
        int BODYREFINE = 4;           // 凡身易筋锻骨...
        int HEART = 5;                // 凡阶黄阶玄阶...
    }

    /**
     * 药品类型
     */
    interface DrugType {
        int Recover = 1;              // 恢复类药品
        int Exp = 2;                  // 增加修为
        int Rescue = 3;               // 渡劫丹
        int Break = 4;                // 突破丹
        int Attr = 5;                 // 属性丹药
        int Energy = 6;               // 精力丹
        int Relive = 7;               // 复活丹
        int Boss = 8;                 // Boss内丹
        int LimitAttr = 9;            // 限制属性丹
        int RecoveryHpPotion = 10;    // 持续恢复红药
        int RecoveryMpPotion = 11;    // 持续恢复蓝药
        int Innat = 12;               // 天赋丹
        int Healthy = 13;             // 健康回复丹
        int Attr2 = 14;               // 不配置神农录里可使用的 属性丹
        int LimitAttr2 = 15;          // 不配置神农录里可使用的 限制属性丹
    }

    /**
     * 值类型小类
     */
    interface ValueType {
        int Energy = 6;               // 精力
    }

    /**
     * 角色装备类型
     */
    interface HeroEquipType {
        int Hero = 1;                 // 角色的角色装备
        int Npc = 2;                  // Npc的角色装备
    }

    /**
     * 宠物丹药类型
     */
    interface PetDrugType {
        int Break = 1;                // 突破丹
        int Exp = 2;                  // 增加修为
        int Rescue = 3;               // 渡劫石
        int Qualifications = 4;       // 资质丹
    }

    /**
     * NPC丹药类型
     */
    interface NpcDrugType {
        int Break = 1;                // 突破丹
        int Exp = 2;                  // 增加修为
        int Rescue = 3;               // 渡劫石
    }

    /**
     * 丹药品质
     */
    interface DrugQuality {
        int JiuPin = 1;               // 九品
        int BaPin = 2;                // 八品
        int QiPin = 3;                // 七品
        int LIUPin = 4;               // 六品
        int WuPin = 5;                // 五品
        int SiPin = 6;                // 四品
        int SanPin = 7;               // 三品
        int ErPin = 8;                // 二品
        int YiPin = 9;                // 一品
    }

    /**
     * 异火星级
     */
    interface MagicFireStarLevel {
        int JiuXing = 1;              // 九星
        int BaXing = 2;               // 八星
        int QiXing = 3;               // 七星
        int LIUXing = 4;              // 六星
        int WuXing = 5;               // 五星
        int SiXing = 6;               // 四星
        int SanXing = 7;              // 三星
        int ErXing = 8;               // 二星
        int YiXing = 9;               // 一星
    }

    /**
     * 异火品质
     */
    interface MagicFireQuality {
        int White = 1;                // 白色品质
        int Green = 2;                // 绿色品质
        int Blue = 3;                 // 蓝色品质
        int Purple = 4;               // 紫色品质
        int Orange = 5;               // 橙色品质
        int Red = 6;                  // 红色品质
        int Gold = 7;                 // 金色品质
    }

    /**
     * 炼宝种类
     */
    interface MagicKind {
        int EMBRYO = 1;               // 器胚
        int ELEMENT = 2;              // 五行材料
        int COST = 3;                 // 辅助材料
        int RareMat = 4;              // 天材地宝
    }

    /**
     * 器灵品质
     */
    interface SpiritQuality {
        int FanPin = 1;               // 凡品
        int LowGrade = 2;             // 下品
        int MediumGrade = 3;          // 中品
        int TopGrade = 4;             // 上品
        int BestGrade = 5;            // 极品
        int JuePin = 6;               // 绝品
        int XianPin = 7;              // 尊品
        int XianPin1 = 8;             // 尊品1 占位 包装名暂未确定
        int XianPin2 = 9;             // 尊品2 占位 包装名暂未确定
    }

    /**
     * 品质
     */
    interface Quality {
        int FanPin = 1;               // 凡品
        int LowGrade = 2;             // 下品
        int MediumGrade = 3;          // 中品
        int TopGrade = 4;             // 上品
        int BestGrade = 5;            // 极品
        int JuePin = 6;               // 绝品
        int XianPin = 7;              // 尊品
        int Max = 7;                  // 取品质最大值时用这个
    }

    /**
     * 丹方类型
     */
    interface ElixirType {
        int Aid = 1;                  // 急救
        int Exp = 2;                  // 修炼
        int Break = 3;                // 突破
        int Rescue = 4;               // 渡劫
        int Special = 5;              // 特殊
        int Heal = 6;                 // 疗伤
        int Attr = 7;                 // 属性
    }

    /**
     * 包裹类型小类
     */
    interface PackType {
        int MonsterCore = 1;          // 魔核
    }

    /**
     * 升级类型
     */
    interface UpgradeType {
        int SPIRIT = 1;               // 器灵强化券
    }

    /**
     * 充值激活类型
     */
    interface ActivateRechargeType {
        int Sponsor = 1;              // 特权卡激活道具
        int MonthCard = 2;            // 月卡激活道具
    }

    /**
     * 装备部位
     */
    interface EquipPos {
        // 防具
        int HAT = 1;                  // 1.发冠
        int CLOTHES = 2;              // 2.衣服
        int BELT = 3;                 // 3.腰带
        int BOOTS = 4;                // 4.靴子

        // 饰品
        int NECKLACE = 5;             // 5.护符
        int BRACELET = 6;             // 6.手镯
        int RING = 7;                 // 7.戒指
        int JADE = 8;                 // 8.玉佩

        int MAX = 8;                  // 上限
    }

    /**
     * 法宝位置
     */
    interface WeaponPos {
        int Wj = 1;                   // 武技
        int Sf = 2;                   // 身法
        int Jj = 3;                   // 绝技
        int St = 4;                   // 神通
        int RideSkill_Zd = 5;         // 骑宠主动技能的位置
        int MagicFireSkill_Pos1 = 8;  // 异火主动技能的位置
    }

    /**
     * 法宝类型和器灵类型一样
     */
    interface WeaponType {
        int TechSword = 1;            // 剑
        int TechKnife = 2;            // 刀
        int TechHammer = 3;           // 锤
        int TechSpear = 4;            // 枪
        int TechBoxing = 5;           // 拳
        int TechTally = 6;            // 符
        int TechShield = 7;           // 盾
        int TechSeal = 8;             // 印
    }

    /**
     * 心法位置
     */
    interface HeartPos {
        int QIAN = 1;                 // 1.乾
        int XUN = 2;                  // 2.巽
        int KAN = 3;                  // 3.坎
        int GEN = 4;                  // 4.艮
        int KUN = 5;                  // 5.坤
        int ZHEN = 6;                 // 6.震
        int LI = 7;                   // 7.离
        int DUI = 8;                  // 8.兑
    }

    /**
     * 元素类型
     */
    interface ElementType {
        int JIN = 1;                  // 金
        int MU = 2;                   // 木
        int SHUI = 3;                 // 水
        int HUO = 4;                  // 火
        int TU = 5;                   // 土
    }

    /**
     * 心法页签 - 通用
     */
    interface HeartTypeNormal {
        int Type0 = 0;                // 全部
        int Type1 = 1;                // 通用
        int Type2 = 2;                // 剑
        int Type3 = 3;                // 刀
        int Type4 = 4;                // 锤
        int Type5 = 5;                // 枪
        int Type6 = 6;                // 拳
        int Type7 = 7;                // 符
    }

    /**
     * 心法页签 - 特殊
     */
    interface HeartTypeSpecial {
        int Type1 = 1;                // 后天
        int Type2 = 2;                // 先天
    }

    /**
     * 心法分类
     */
    interface HeartKind {
        int Kind1 = 1;                // 通用
        int Kind2 = 2;                // 特殊
    }

    /**
     * 心法重修类型
     */
    interface HeartRebuildType {
        int Single = 1;               // 单本重修
        int All = 2;                  // 整本重修
    }

    /**
     * 绑定类型
     */
    interface WearBind {
        int NoBind = 0;               // 穿戴后不自动绑定
        int Bind = 1;                 // 穿戴后自动绑定
    }

    /**
     * 法宝绑定状态
     */
    interface WeaponBindState {
        int Bind = 1;                 // 已绑定
        int WearBind = 2;             // 穿戴后绑定
        int CanSale = 3;              // 可交易
    }

    /**
     * 炼体装备穿戴错误
     */
    interface EquipWearError {
        int BodyRefineLevelLower = 1; // 装备的炼体等级高于人炼体等级
        int BodyRefineLevelHigher = 2;// 装备的炼体等级低于人炼体等级
        int HasWeared = 3;            // 已经穿上了这个装备
    }

    /**
     * 红点条件
     */
    interface ITEM_RED_CONDITION {
        int COND_CHANGE = 1;          // 条件变化
        int COND_ENOUGH = 2;          // 条件满足
        int COND_ADDED = 3;           // 条件添加
        int COND_REMOVE = 4;          // 条件移除
    }

    /**
     * 道具索引
     */
    interface PropIdx {
        int EXP = 50300;                    // 经验
        int PayCoin = 50100;                // 目前是仙玉
        int Coin = 50200;                   // 目前是灵石
        int BindPayCoin = 50400;            // 目前是绑定仙玉（停用）
        int BindCoin = 50500;               // 目前是绑定灵石
        int Energy = 50600;                 // 精力
        int Contribute = 50700;             // 门派贡献
        int ReliveCoin = 50800;             // 复活币
        int HuntCoin = 50900;               // 千机令 寻宝获得的物品
        int LSD = 60100;                    // 疗伤丹
        int InnatCount = 51000;             // 天赋点
        int PetExp = 51201;                 // 灵宠经验
        int NpcExp = 51301;                 // Npc经验
        int CampCount14 = 51400;            // 天剑精粹
        int CampCount15 = 51401;            // 百川精粹
        int CampCount16 = 51402;            // 百瘴精粹
        int CampCount17 = 51403;            // 北岭精粹
        int CampCount18 = 51404;            // 天剑仙晶
        int CampCount19 = 51405;            // 百川仙晶
        int CampCount20 = 51406;            // 百瘴仙晶
        int CampCount21 = 51407;            // 北岭仙晶
        int RepelCount = 51500;             // 挑战令牌
        int GodAreaCoin = 51600;            // 梦入仙途步数货币
        int GodAreaScoreCoin = 51700;       // 梦入仙途积分货币
        int GodAreaShopCoin = 51800;        // 梦入仙途商店货币
        int MetalEle = 52001;               // 金元
        int WoodEle = 52002;                // 木元
        int WaterEle = 52003;               // 水元
        int FireEle = 52004;                // 火元
        int EarthEle = 52005;               // 土元
        int NewServerScore = 53100;         // 新服目标活动积分
        int FairyCrystal = 53300;           // 绑定仙玉
        int LocalBattleScoreMoney = 53400;  // 仙门大比积分
        int HandUpCoin = 53500;             // 须臾幻境货币
        int GodAreaMoneyCoin = 53600;       // 梦入仙途货币
    }

    // 是否是绑定的货币
    Map<Integer, Boolean> IsBindCoin = Map.of(
            ItemConstant.PropIdx.BindPayCoin, true,
            ItemConstant.PropIdx.BindCoin, true
    );


    Map<Integer, Integer> CoinToBindCoin = Map.of(
            ItemConstant.PropIdx.PayCoin, ItemConstant.PropIdx.BindPayCoin,
            ItemConstant.PropIdx.Coin, ItemConstant.PropIdx.BindCoin
    );

    Map<Integer, Integer> BindCoinToCoin = Map.of(
            ItemConstant.PropIdx.BindPayCoin, ItemConstant.PropIdx.PayCoin,
            ItemConstant.PropIdx.PayCoin, ItemConstant.PropIdx.PayCoin,
            ItemConstant.PropIdx.BindCoin, ItemConstant.PropIdx.Coin,
            ItemConstant.PropIdx.Coin, ItemConstant.PropIdx.Coin
    );

    // 值类型道具
    Map<Integer, Boolean> ValueProp = Map.ofEntries(
            Map.entry(ItemConstant.PropIdx.PayCoin, true),
            Map.entry(ItemConstant.PropIdx.Coin, true),
            Map.entry(ItemConstant.PropIdx.Energy, true),
            Map.entry(ItemConstant.PropIdx.EXP, true),
            Map.entry(ItemConstant.PropIdx.Contribute, true),
            Map.entry(ItemConstant.PropIdx.ReliveCoin, true),
            Map.entry(ItemConstant.PropIdx.HuntCoin, true),
            Map.entry(ItemConstant.PropIdx.InnatCount, true),
            Map.entry(ItemConstant.PropIdx.CampCount14, true),
            Map.entry(ItemConstant.PropIdx.CampCount15, true),
            Map.entry(ItemConstant.PropIdx.CampCount16, true),
            Map.entry(ItemConstant.PropIdx.CampCount17, true),
            Map.entry(ItemConstant.PropIdx.CampCount18, true),
            Map.entry(ItemConstant.PropIdx.CampCount19, true),
            Map.entry(ItemConstant.PropIdx.CampCount20, true),
            Map.entry(ItemConstant.PropIdx.CampCount21, true),
            Map.entry(ItemConstant.PropIdx.RepelCount, true),
            Map.entry(ItemConstant.PropIdx.GodAreaCoin, true),
            Map.entry(ItemConstant.PropIdx.GodAreaShopCoin, true),
            Map.entry(ItemConstant.PropIdx.GodAreaScoreCoin, true),
            Map.entry(ItemConstant.PropIdx.MetalEle, true),
            Map.entry(ItemConstant.PropIdx.WoodEle, true),
            Map.entry(ItemConstant.PropIdx.WaterEle, true),
            Map.entry(ItemConstant.PropIdx.FireEle, true),
            Map.entry(ItemConstant.PropIdx.EarthEle, true),
            Map.entry(ItemConstant.PropIdx.NewServerScore, true),
            Map.entry(ItemConstant.PropIdx.FairyCrystal, true),
            Map.entry(ItemConstant.PropIdx.LocalBattleScoreMoney, true),
            Map.entry(ItemConstant.PropIdx.HandUpCoin, true),
            Map.entry(ItemConstant.PropIdx.GodAreaMoneyCoin, true)
    );

    // 消耗货币所对应的Attr
    Map<Integer, Integer> ExpendAttr = Map.ofEntries(
            Map.entry(ItemConstant.PropIdx.Coin, Attr.Hero.Coin),
            Map.entry(ItemConstant.PropIdx.BindCoin, Attr.Hero.BindCoin),
            Map.entry(ItemConstant.PropIdx.PayCoin, Attr.Hero.PayCoin),
            Map.entry(ItemConstant.PropIdx.BindPayCoin, Attr.Hero.BindPayCoin),
            Map.entry(ItemConstant.PropIdx.Energy, Attr.Hero.Energy),
            Map.entry(ItemConstant.PropIdx.Contribute, Attr.Hero.Contribute),
            Map.entry(ItemConstant.PropIdx.ReliveCoin, Attr.Hero.ReliveCount),
            Map.entry(ItemConstant.PropIdx.EXP, Attr.Hero.CurExp),
            Map.entry(ItemConstant.PropIdx.InnatCount, Attr.Hero.InnatCount),
            Map.entry(ItemConstant.PropIdx.PetExp, Attr.Pet.PetExp),
            Map.entry(ItemConstant.PropIdx.NpcExp, Attr.Npc.NpcExp),
            Map.entry(ItemConstant.PropIdx.CampCount14, Attr.Hero.CampCount14),
            Map.entry(ItemConstant.PropIdx.CampCount15, Attr.Hero.CampCount15),
            Map.entry(ItemConstant.PropIdx.CampCount16, Attr.Hero.CampCount16),
            Map.entry(ItemConstant.PropIdx.CampCount17, Attr.Hero.CampCount17),
            Map.entry(ItemConstant.PropIdx.CampCount18, Attr.Hero.CampCount18),
            Map.entry(ItemConstant.PropIdx.CampCount19, Attr.Hero.CampCount19),
            Map.entry(ItemConstant.PropIdx.CampCount20, Attr.Hero.CampCount20),
            Map.entry(ItemConstant.PropIdx.CampCount21, Attr.Hero.CampCount21),
            Map.entry(ItemConstant.PropIdx.GodAreaCoin, Attr.Hero.GodAreaCoin),
            Map.entry(ItemConstant.PropIdx.GodAreaShopCoin, Attr.Hero.GodAreaShopCoin),
            Map.entry(ItemConstant.PropIdx.GodAreaScoreCoin, Attr.Hero.GodAreaScoreCoin),
            Map.entry(ItemConstant.PropIdx.MetalEle, Attr.Hero.MetalEle),
            Map.entry(ItemConstant.PropIdx.WoodEle, Attr.Hero.WoodEle),
            Map.entry(ItemConstant.PropIdx.WaterEle, Attr.Hero.WaterEle),
            Map.entry(ItemConstant.PropIdx.FireEle, Attr.Hero.FireEle),
            Map.entry(ItemConstant.PropIdx.EarthEle, Attr.Hero.EarthEle),
            Map.entry(ItemConstant.PropIdx.NewServerScore, Attr.Hero.NewServerScore),
            Map.entry(ItemConstant.PropIdx.FairyCrystal, Attr.Hero.FairyCrystal),
            Map.entry(ItemConstant.PropIdx.LocalBattleScoreMoney, Attr.Hero.LocalBattleScoreMoney),
            Map.entry(ItemConstant.PropIdx.HandUpCoin, Attr.Hero.HandUpCoin),
            Map.entry(ItemConstant.PropIdx.GodAreaMoneyCoin, Attr.Hero.GodAreaMoneyCoin),
            Map.entry(ItemConstant.PropIdx.RepelCount, Attr.Hero.RepelCount)
    );

}
