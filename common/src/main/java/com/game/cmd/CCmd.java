package com.game.cmd;

public interface CCmd {

    int HEARTBEAT = 10001;  // 心跳

    // 登录相关
    int USER_LOGIN = 10003;             // 用户登录
    int CREATE_ROLE = 10005;            // 创建角色
    int ROLE_LOGIN = 10007;             // 角色登录
    int CLIENT_READY = 10009;           // 客户端加载完毕(可以刷地图了)
    int ROLE_OPERATION = 10010;         // 操作角色
    int USER_LOGIN_ACTIVATE_CODE = 10018; // 使用激活码登录
    int EXIT_GAME = 10565;              // 注销角色登录
    int ROLE_LIST = 10013;              // 拉取角色列表
    int CROSS_LOGIN = 10015;            // 跨服登录
    int HERO_CHANGE_NAME = 11381;       // 角色改名

    // 战斗地图
    int IDLE = 10114;                   // 待机
    int MOVE = 10112;                   // 移动
    int ATTACK = 10127;                 // 攻击
    int JUMP_POINT = 10125;             // 地图触发跳转点
    int RELIVE = 10131;                 // 复活
    int SKILL_OBJ_HIT_RPT = 10141;      // 由客户端控制的技能物击中通知

    // 世界地图
    int WHOLE_IDLE = 10123;             // 待机
    int WHOLE_MOVE = 10121;             // 移动
    int BIG_SCREEN_NEARBY_OBJ = 30258;  // 获取大地图玩家附近的对象

    // 物品及包裹
    int EQUIP = 10205;                  // 装备穿戴
    int USE_ITEM = 10209;               // 批量使用道具

    // 炼丹
    int MAKE_DRUG = 10443;              // 炼丹

    // 聊天
    int CHAT = 10421;                   // 聊天

    // 心法
    int HEART_LEARN = 11036;            // 收录心法
    int HEART_UPDATE = 10226;           // 升级心法
    int HEART_REALIZE = 10228;          // 心法参悟
    int HEART_REALIZE_SAVE = 10231;     // 心法参悟保存
    int HEART_EQUIP = 10219;            // 心法穿戴
    int HEART_UNEQUIP = 10221;          // 心法卸载
    int HEART_REALIZE_GIVEUP = 10240;   // 放弃参悟结果

    // 法宝
    int WEAPON_EQUIP = 10236;           // 法宝穿戴
    int WEAPON_UNEQUIP = 10238;         // 法宝卸下

    // 角色装备
    int HERO_EQUIPMENT_EQUIP = 11155;   // 角色装备穿戴req
    int HERO_EQUIPMENT_UN_EQUIP = 11157; // 角色装备卸下req

    // 角色装备强化
    int HERO_EQUIPMENT_UPGRADE = 11159; // 角色装备强化req, 通用请求 value1为objId
    int HERO_EQUIPMENT_REPAIR = 11161;  // 角色装备破碎修复req, 通用请求 value1为objId

    // Npc角色装备
    int NPC_EQUIPMENT_EQUIP = 11163;    // npc装备穿戴req
    int NPC_EQUIPMENT_UN_EQUIP = 11165; // npc装备卸下req

    // Npc角色装备强化
    int NPC_EQUIPMENT_UPGRADE = 11167;  // npc装备强化req, 通用请求 value1为npcObjId value2为objId
    int NPC_EQUIPMENT_REPAIR = 11169;   // npc装备破碎修复req, 通用请求 value1为objId

    // 法宝凝练
    int WEAPON_CONCISE = 10447;         // 法宝凝练

    // 器灵
    int SPIRIT_EQUIP = 10515;           // 器灵 装备和卸下请求
    int SPIRIT_LEVEL_UP = 10547;        // 器灵注灵请求
    int SPIRIT_RECOVER = 10549;         // 器灵分解请求
    int SPIRIT_REPAIR = 11566;          // 器灵修复请求

    // 装备
    int EQUIPMENT_STRENGTHEN = 10254;   // 装备强化

    // 修炼 渡劫
    int UPDATE_LV = 10232;              // 升级
    int RESCUE_START = 10430;           // 渡劫
    int RESCUE_JOIN = 10433;            // 参与渡劫
    int RESCUE_RECEIVE_JOIN_REWARD = 10435; // 领取参与渡劫奖励
    int ENTER_RESCUE_SAVING = 10484;    // 请求进入法宝护主
    int LEAVE_RESCUE_SAVING = 10483;    // 退出法宝护主

    // 商会
    int CITY_SHOP_SELL = 10246;         // 商会出售

    // 首充
    int FIRST_RECHARGE_REWARD = 10537;  // 领取首充奖励

    // 月卡
    int MONTH_CARD_REWARD = 10535;      // 领取月卡奖励

    // 特权
    int RECEIVE_PRIVILEGE_CARD_REWARD = 11291; // 领取特权卡奖励

    // 商城
    int SHOP_BUY = 10542;               // 商城购买

    // 门派
    int GUILD_INFO = 30111;             // 请求门派信息
    int GUILD_LIST = 30101;             // 请求门派列表
    int SEARCH_GUILD = 30103;           // 搜索工会
    int JOIN_GUILD = 30105;             // 加入工会请求
    int CREATE_GUILD = 10401;           // 创建工会请求
    int JOIN_GUILD_LIST = 30107;        // 申请加入工会列表
    int ANSWER_JOIN_GUILD = 30109;      // 回答申请加入
    int EXIT_GUILD = 30120;             // 退出工会请求
    int GUILD_NOTICE = 30114;           // 设置公告
    int GUILD_RECRUIT_SET = 30126;      // 招人设置请求
    int GUILD_KICKOUT = 30122;          // 门派踢人请求
    int SET_OFFICE_AUTHORITY = 30118;   // 设置职位权限
    int GUILD_IMPEACH = 10403;          // 发起工会弹劾
    int ANSWER_IMPEACH_GUILD = 30124;   // 回答弹劾
    int GUILD_SET_OFFICE = 30116;       // 设置职位
    int GET_GUILD_SHOP_LIMIT_INFO = 10424; // 获取公会商店限购信息
    int GUILD_SHOP_BUY = 10427;         // 商店购买商品
    int GUILD_DAILY_REWARD = 10441;     // 领取公会每日俸禄
    int ONE_KEY_APPLY_GUILD = 10409;    // 一键申请公会

    // 任务
    int RECEIVE_TASK_REWARD = 10407;    // 领取任务奖励
    int DO_TASK = 10551;                // 做任务
    int UPDATE_TASK_TRACKING_STATE = 11123; // 更新任务的跟踪状态请求
    int GAIN_TASK_AFTER_TALK_RPF = 11122; // 获取对话完成后的任务请求

    // 炼宝
    int LIAN_BAO = 10216;               // 练宝申请

    // 炼化
    int WEAPON_ARTIFICE = 10259;        // 法宝炼化
    int WEAPON_ARTIFICE_SAVE = 10256;   // 炼化保存

    // 拍卖行
    int ENTER_AUCTION = 10272;          // 进入拍卖行
    int LEAVE_AUCTION = 10274;          // 离开拍卖行
    int AUCTION_ROUND_START = 10276;    // 每轮拍卖开始
    int AUCTION_ACTION = 10278;         // 进行拍卖
    int AUCTION_STRATEGY = 10280;       // 使用拍卖策略
    int GET_AUCTION_RECORD = 10283;     // 获取拍卖纪录
    int GET_AUCTION_ITEM_LIST = 10285;  // 获取拍卖行道具

    // 副本
    int RAID_SET_DRUG = 10477;          // 副本设置带入丹药
    int RAID_INVITE_ANSWER = 10459;     // 世界boss副本邀请答复请求
    int RAID_BOSS_LEAVE = 10470;        // 离开世界boss副本
    int RAID_JUMP_ROOM = 10471;         // 世界boss副本跳转房间

    // 世界Boss副本
    int WORLD_BOSS_RANK = 10465;        // 获取世界boss副本排行
    int WORLD_BOSS_ENTER = 30241;       // 进入世界boss
    int WORLD_BOSS_BUY_COUNT = 10462;   // 世界boss副本购买次数

    // 日常副本
    int DAILY_BOSS_RANK = 11069;        // 获取日常副本排行
    int DAILY_BOSS_ENTER = 30346;       // 日常boss挑战

    // 组队
    int TEAM_LIST = 30201;              // 队伍列表
    int TEAM_INFO = 30203;              // 队伍信息
    int TEAM_APPLY_JOIN_LIST = 30205;   // 申请列表
    int TEAM_JOIN = 30207;              // 申请加入
    int TEAM_LEAVE = 30209;             // 申请离开
    int TEAM_TRANSFER = 30211;          // 转让队长
    int TEAM_KICK = 30213;              // 踢出玩家
    int TEAM_SET_INFO = 30215;          // 设置信息
    int TEAM_AGREE_JOIN = 30217;        // 同意申请
    int TEAM_REFUSE_JOIN = 30219;       // 拒绝申请
    int TEAM_CREAT = 30221;             // 创建队伍
    int TEAM_INVITE = 30225;            // 邀请加入
    int TEAM_DEAL_INVITE = 30227;       // 处理邀请
    int GET_INVITE_PLAYER_INFO = 30348; // 获取Other的组队信息 由[邀请组队/申请入队]调用
    int BUSY_STATUS_SETTING = 10522;    // 设置队友状态忙
    int TEAM_MATE_POWER = 30231;        // 队伍成员战力请求

    // 精力
    int ENERGY_GET = 10474;             // 精力领取

    // 门派任务
    int DO_CAMP_TASK = 10419;           // 做势力任务

    // 寻宝
    int DO_HUNT = 10501;                // 挖宝请求
    int HUNT_CHALLENGE = 30243;         // 寻宝挑战
    int HUNT_FINISH_ASSEMBLY = 10602;   // 完成寻宝个人组件请求

    // 好友
    int QUERY_SUGGEST_FRIEND = 30303;   // 查询建议好友
    int REQUEST_ADD_FRIEND = 30305;     // 发起好友申请
    int AGREE_ADD_FRIEND = 30307;       // 同意好友申请
    int REFUSE_ADD_FRIEND = 30309;      // 不同意
    int AGREE_ALL_ADD_FRIEND = 30319;   // 好友申请全部同意
    int REFUSE_ALL_ADD_FRIEND = 30341;  // 好友申请全部拒绝
    int DEL_FRIEND = 30311;             // 删除好友
    int GET_FRIEND_LIST = 30313;        // 主动获取好友列表
    int GET_TARGET_PLAYER_DATA = 30260; // 获取目标角色的个人信息req
    int GET_PLAYER_TEAM_ID = 30314;     // 获取目标角色的队伍信息

    // 个人boss
    int PERSONAL_CHALLENGE = 10520;     // 个人副本挑战

    // 个人组件
    int PERSONAL_COMP_LIST = 10527;     // 个人组件信息请求
    int FINISH_PERSONAL_COMP = 10530;   // 完成个人组件请求
    int GET_TYPE_ASSEMBLY_LIST = 11429; // 个人类型组件信息请求(按照类型返回一张地图的未完成的组件)
    int CREATE_PDUPLICATE = 10728;      // 创建个人副本

    // 个人组件扫荡
    int PERSON_COMP_SWEEP = 11231;      // 个人组件扫荡请求
    int PERSON_COMP_SWEEP_BUY_NUM = 11234; // 个人组件购买扫荡次数

    // 传送阵
    int TRANSFER = 10532;               // 请求传送
    int TRANSFER_ACTIVATE = 10557;      // 请求传送阵激活

    // 炼体
    int BODY_REFINE = 10479;            // 炼体
    int SYNTHESIS = 10481;              // 炼体合成

    // 逆天改命
    int ADD_DESTINY_ATTR = 10505;       // 增加先天气运请求
    int RESET_DESTINY = 10507;          // 开始重置先天气运
    int CHANGE_DESTINY = 10509;         // 重置先天气运后，更改先天气运

    // 引导
    int NOVICE_GUIDE_RECORD = 10560;    // 玩家新手引导记录

    // 角色修为
    int GET_EXP_RPT = 10519;            // 获取经验上报
    int EXP_ADD_BEGIN = 10563;          // 开始获取经验

    // 势力挑战
    int LIBRARY_CHALLENGE = 10567;      // 势力挑战
    int LEAVE_LIBRARY_CHALLENGE = 10570; // 离开势力挑战

    // 势力每日任务
    int CAMP_DAILY_TASK_ACCEPT = 11433; // 势力每日任务领取
    int CAMP_DAILY_TASK_FINISH = 11435; // 势力每日任务完成
    int CAMP_DAILY_TASK_GIVE_UP = 11437; // 势力每日任务放弃
    int CAMP_DAILY_TASK_SUBMIT = 11439; // 势力每日任务提交道具
    int CAMP_DAILY_TASK_REFRESH = 11441; // 势力每日任务刷新
    int CAMP_DAILY_TASK_TRACK = 11443;  // 势力每日任务追踪

    // 邮件
    int GET_MAIL_LIST = 10580;          // 获取邮件列表
    int READ_MAIL = 10583;              // 读邮件
    int READ_MAIL_BATCH = 10585;        // 一键读取邮件
    int RECEIVE_ATTACHMENT = 10587;     // 领取附件
    int RECEIVE_ATTACHMENT_BATCH = 10589; // 一键领取附件
    int DELETE_MAIL = 10591;            // 删除邮件
    int DELETE_MAIL_BATCH = 10593;      // 一键删除邮件

    // 论剑
    int GET_BATTLE_INFO = 30137;        // 获取竞技场主界面信息
    int BATTLE_MATCH = 11001;           // 匹配
    int BATTLE_CANCEL_MATCH = 11004;    // 取消匹配
    int BATTLE_QUIT_RPT = 11018;        // 竞技场投降
    int BATTLE_BUY_COUNT = 11011;       // 购买论道次数
    int BATTLE_RECEIVE_TASK_REWARD = 11016; // 领取竞技场任务奖励
    int BATTLE_GET_RANK_LIST = 30139;   // 竞技场排行榜
    int BATTLE_GET_LOG_LIST = 11013;    // 战报
    int BATTLE_ENTER = 11006;           // 进入战斗(跨服协议)
    int BATTLE_EXIT = 11008;            // 退出战斗(跨服协议)
    int BATTLE_JUMP_BACK_RPT = 11019;   // 竞技场返回大地图

    // 仙遗探宝抽奖
    int ANCIENT_LOTTERY = 11366;        // 仙遗抽奖请求
    int ANCIENT_LOTTERY_RECORD_LIST = 30396; // 仙遗抽奖请求
    int ANCIENT_LOTTERY_WISH = 11522;   // 心愿设置

    // 寄售行
    int GET_TRADE_FOCUS_ORDER_LIST = 10831; // 获取交易行关注物品
    int TRADE_ORDER_FOCUS = 30335;      // 关注物品
    int TRADE_ORDER_CANCEL_FOCUS = 10833; // 取消关注物品
    int TRADE_ORDER_SELL = 10835;       // 出售物品(上架)
    int TRADE_ORDER_AUCTION = 10837;    // 竞价
    int GET_TRADE_SUMMARY_ORDER_LIST = 30321; // 获取交易行一级页物品
    int GET_TRADE_ORDER_LIST = 30323;   // 获取交易行二级页物品
    int GET_TRADE_SELL_ORDER_LIST = 30325; // 获取交易行出售物品
    int GET_TRADE_SUMMARY_PUBLIC_ORDER_LIST = 30327; // 获取交易行公示一级页物品
    int GET_TRADE_PUBLIC_ORDER_LIST = 30329; // 获取交易行公示二级页物品
    int TRADE_ORDER_BUY = 30331;        // 购买物品
    int TRADE_ORDER_TAKE_OFF = 30333;   // 下架物品
    int TRADE_ORDER_PUT_ON = 10841;     // 重新上架物品
    int GET_TRADE_FOCUS_ID_LIST = 10839; // 获取交易行关注订单号
    int TRADE_ORDER_BIDDING = 30337;    // 获取订单价格信息

    // 神兽秘境
    int ENTER_PET_SECRET = 11031;       // 进入神兽秘境活动
    int LEAVE_PET_SECRET = 11033;       // 离开神兽秘境活动

    // npc
    int NPC_ACTIVE = 10639;             // npc激活 req
    int NPC_BUILD_RELATION = 10618;     // Npc结缘
    int NPC_GO_INTO_BATTLE = 10641;     // npc上下阵 req
    int NPC_BREAKTHROUGH = 10643;       // npc突破 req
    int DUPLICATE_GIVE_UP = 10755;      // 战斗认输请求

    int NPC_ASK_FOR_GIFT = 10650;       // NPC索要礼物
    int NPC_CHAT = 10771;               // NPC交谈次数

    int NPC_CONSULT = 10776;            // NPC请教
    int NPC_SETTING_AFFIX = 10787;      // npc请教词条设置

    // npc重修
    int NPC_REBORN = 10768;             // npc重修请求

    // npc赠礼
    int NPC_SEND_REWARD = 10611;        // 获取NPC赠礼

    // npc切磋
    int NPC_CHALLENGE = 10655;          // npc挑战副本
    int LEAVE_NPC_CHALLENGE = 10658;    // npc挑战副本

    // npc寻仇
    int NPC_REVENGE_CHOICE = 10752;     // npc寻仇操作
    int NPC_LEAVE_REVENGE_CHALLENGE = 10699; // 离开npc寻仇战斗req

    // npc偷窃
    int NPC_STEAL = 10684;              // npc偷窃req
    int NPC_STEAL_CHALLENGE = 10686;    // npc偷窃战斗req
    int NPC_LEAVE_STEAL_CHALLENGE = 10695; // 离开npc偷窃战斗req

    // npc求饶
    int NPC_ASK_FOR_PARDON_NPC = 10688; // 人物求饶npc req
    int NPC_ASK_FOR_PARDON = 10690;     // npc求饶req

    // npc偷袭
    int NPC_SNEAK_ATTACK = 10757;       // 偷袭npc req
    int NPC_LEAVE_SNEAK_ATTACK = 10759; // 离开偷袭npc副本

    // npc比武
    int NPC_COMBAT = 10778;             // npc比武请求
    int NPC_SWEEP = 10780;              // npc扫荡
    int BUY_NPC_SWEEP_TIMES = 10782;    // 购买npc扫荡次数
    int NPC_COMBAT_LEAVE = 10784;       // 离开npc比武副本

    // npc修炼
    int NPC_EXP_IMPROVE = 10762;        // 提升npc修为

    // npc升品
    int NPC_UP_PERIOD = 10766;          // npc升品

    // npc法宝升星
    int NPC_WEAPON_UP_STAR = 10764;     // npc法宝升星req

    // npc专属法宝
    int NPC_EXCLUSIVE_WEAPON_WEAR = 11400; // npc专属法宝穿戴请求
    int NPC_EXCLUSIVE_WEAPON_UNWEAR = 11402; // npc专属法宝卸下请求
    int NPC_EXCLUSIVE_WEAPON_LVUP = 11404; // npc专属法宝升级请求

    // npc心法
    int NPC_HEART_UPGRADE = 10486;      // npc心法升级
    int NPC_HEART_REALIZE = 10488;      // npc心法参悟
    int NPC_HEART_REALIZE_SAVE = 10490; // npc心法参悟保存
    int NPC_HEART_REALIZE_GIVEUP = 10497; // npc心法参悟放弃

    // npc炼体
    int NPC_EQUIP_EQUIPMENT = 10791;    // npc穿上炼体装备
    int NPC_BODY_REFINE = 10793;        // npc炼体

    // npc双修
    int NPC_CULTIVATE = 11125;          // npc双修请求

    // 挂机副本
    int HANDUP_CHALLENGE = 30249;       // 挂机副本挑战
    int HAND_UP_DUPLICATE_GIVE_UP = 11467; // 挂机副本放弃
    int HAND_UP_RECEIVE_REWARD = 11504; // 挂机副本领取奖励

    // 刹影幻藏 须臾幻境抽奖
    int HAND_UP_LOTTERY = 11551;        // 刹影幻藏 抽奖req
    int HAND_UP_LOTTERY_REWARD = 11553; // 刹影幻藏 抽奖 挑战奖励领取req
    int HAND_UP_LOTTERY_RECORD_LIST = 30401; // 刹影幻藏抽奖探险记录获取

    // 系统设置
    int SYS_SETING = 10595;             // 系统设置请求
    int BATTLE_DROP_SETTING = 11038;    // 战斗掉落设置

    int RECORD_CLIENT_DATA = 10597;     // 记录客户端自己需要的数据
    int GET_RECORD_CLIENT_DATA = 10605; // 获取客户端对应的数据

    int LEAVE_CHALLENGE_CHALLENGE = 10607; // 挑战副本 req

    // 灵宠
    int SPIRIT_PET_GO_INTO_BATTLE = 10623; // 灵宠上阵请求
    int SPIRIT_PET_CHANGE_NAME = 10625; // 灵宠改名请求
    int SPIRIT_PET_IMPROVE_CULTIVATION = 10627; // 灵宠提升修为请求
    int SPIRIT_PET_BREAKTHROUGH = 10629; // 灵宠突破请求
    int SPIRIT_PET_RELEASE = 10631;     // 灵宠放生请求
    int PET_REBORN = 10720;             // 灵宠重生请求

    // 灵宠血脉
    int SPIRIT_PET_BLOOD_RANDOM_BLOOD = 10660; // 灵宠随机血脉属性请求
    int SPIRIT_PET_BLOOD_REPLACE_BLOOD = 10662; // 灵宠替换血脉属性请求
    int SPIRIT_PET_BLOOD_GIVE_UP = 10664; // 灵宠放弃血脉属性请求

    // 灵宠喂食
    int SPIRIT_PET_GIVE_FOOD = 10718;   // 灵宠喂食req

    // 灵宠技能
    int PET_LEARN_SKILL = 10667;        // 灵宠学习技能
    int PET_SKILL_POS = 10669;          // 灵宠技能位置
    int PET_SKILL_DEL = 10706;          // 灵宠删除技能

    // 灵宠图鉴
    int PETBOOK = 10714;                // 激活灵宠请求
    int PETBOOK_OUT = 10716;            // 取出灵宠请求

    // 灵宠捕捉
    int PET_SEARCH_STATUS = 10708;      // 灵宠搜寻状态
    int PET_SEARCH = 10555;             // 灵宠搜寻
    int PET_CATCH = 10704;              // 灵宠捕捉
    int PET_CATCH_GIVE_UP = 10637;      // 灵宠捕捉放弃
    int PET_CATCH_FINISH = 10710;       // 灵宠捕捉结束

    // 灵宠自动捕捉
    int PET_AUTO_CATCH_SET = 10726;     // 灵宠自动捕捉设置

    // 灵宠升品
    int PET_CRUDE = 10712;              // 升品请求

    // 天赋
    int INNAT_UP_LV = 10600;            // 天赋升级
    int INNAT_RESET = 10614;            // 天赋重置

    // 活动大厅
    int ATV_DAILY_DRAW_BOX = 10678;     // 日常活动活跃度领取宝箱奖励

    // 活跃(每日任务)
    int RECEIVE_ALL_ACTIVITY_POINT = 11426; // 一键领取所有未领取的活跃度请求

    // 镇妖塔
    int TOWER_CHALLENGE = 10802;        // 镇妖塔副本挑战
    int TOWER_REWARD = 10806;           // 镇妖塔副本挑战
    int TOWER_SWEEP = 10808;            // 镇妖塔副本挑战
    int TOWER_SWEEP_BUY_TIMES = 10812;  // 镇妖塔购买扫荡次数

    // 镇妖塔挂机
    int TOWER_HANGUP_GET_DISPLAY_REWARD = 11471; // 查询要展示的奖励
    int TOWER_HANGUP_RECEIVE_REWARD = 11473; // 请求领取奖励
    int TOWER_HANGUP_BUY_COUNT = 11475; // 请求购买次数

    // 兑换码
    int ATV_GIFT_CODE = 10288;          // 使用兑换码

    // 签到
    int SIGN_IN = 10814;                // 请求签到

    // 战斗设置
    int BATTLE_SETING = 10820;          // 设置请求

    // 切换线路
    int GET_SERVER_NUM = 30253;         // 获取线路
    int SWITCH_SERVER = 30255;          // 切换线路

    // 神农录
    int USE_DRUG_ITEM = 10609;          // 使用神农录道具

    // 合成心法
    int COMPOSE = 10234;                // 合成心法

    // 梦入仙途
    int GOD_AREA_ACTIVITY_MOVE = 10851; // 梦入仙途活动移动
    int GOD_AREA_LEAVE_CHALLENGE = 10854; // 梦入仙途活动离开副本

    // 梦入仙途 抽奖
    int GOD_AREA_LOTTERY = 11301;       // 梦入仙途抽奖请求
    int GOD_AREA_LOTTERY_REWARD = 11303; // 抽奖任务领取奖励请求
    int GOD_AREA_LOTTERY_RECORD = 30390; // 抽奖记录请求

    // 领仙途购买礼包
    int GOD_AREA_GET_REWARD = 11309;    // 领取仙途礼包

    // 梦入仙途 战令领奖
    int GOD_AREA_BATTLE_ORDER_RECEIVE = 10860; // 梦入仙途战令领奖

    // 梦入仙途 签到
    int GOD_AREA_SIGN_IN = 10857;       // 梦入仙途签到

    // 诛魔却邪
    int REPEL_EVIL_GET_MY_INFO = 30405; // 诛魔却邪活动获取我的信息req
    int REPEL_EVIL_CHALLENGE = 30403;   // 诛魔却邪活动挑战req
    int REPEL_EVIL_GET_RANK = 30350;    // 诛魔却邪活动获取排行榜req

    // 天气
    int WEATHER_ITEM_USE = 10810;       // 使用天气道具
    int GET_WEATHER_CHANGE_RECORD = 30339; // 获取玩家使用天气道具的记录

    // 奇遇
    int MEET_CHOOSE_BUTTON = 11041;     // 选择奇遇按钮
    int MEET_CREATE = 11043;            // 创建奇遇
    int MEET_RECEIVE_REWARD = 11049;    // 领取奇遇奖励
    int PUBLIC_MEET_CHOOSE_BUTTON = 11056; // 选择公共奇遇按钮
    int MEET_CHALLENGE = 11053;         // 选择公共奇遇按钮

    // 道具兑换
    int ITEM_EXCHANGE = 10774;          // 道具兑换req

    // 小地图收藏点位
    int MAP_COLLECT_ADD = 11061;        // 增加点位
    int MAP_COLLECT_DELETE = 11064;     // 删除点位

    int BATTLE_PLAN_SAVE = 11081;       // 保存并战斗方案
    int BATTLE_PLAN_UPDATE_NAME = 11083; // 修改方案名称
    int BATTLE_PLAN_GET_LIST = 11085;   // 获取战斗方案列表
    int BATTLE_PLAN_UPDATE_PRESET = 11087; // 更新预设方案
    int BATTLE_PLAN_SWITCH = 11089;     // 切换当前方案和预设方案

    int RIDE_CHANGE_STATUS = 11090;     // 骑乘坐骑
    int RIDE_ADD_EXP = 11092;           // 坐骑增加经验
    int RIDE_LEVEL_UP = 11094;          // 坐骑升级
    int RIDE_STAR_UP = 11096;           // 坐骑升星

    // 坐骑图鉴
    int BOOK_GET_EXP = 11421;           // 请求领取坐骑图鉴经验

    int SWITCH_TERRAIN_STATE = 11111;   // 切换地形req

    // 斩妖录
    int MONSTER_SLAIN_GET_REWARD = 11115; // 领取斩妖录奖励

    // 洞府
    int CAVE_UPGRADE = 11181;           // 升级洞府
    int CAVE_BUILDING_RECEIVE = 11183;  // 领取洞府建筑生产的物资
    int CAVE_PET_WORKING = 11186;       // 灵宠派遣请求,通用请求;value1为灵宠objId;value2为0表示召回,>0表示派遣位置;value3为洞府建筑id,召回时不需要传
    int CAVE_BUILDING_STATE_CONFIRM_RPT = 11192; // 洞府生产建筑状态确认

    // 洞府合成
    int CAVE_COMPOSE = 11190;           // 洞府合成请求

    // 升仙录
    int CHAPTER_RECEIVE_TASK_REWARD = 11143; // 领取章节任务奖励请求
    int CHAPTER_FINISH_REWARD = 11145;  // 完成章节所有任务后，领取章节奖励请求
    int CHAPTER_LUCKY_RAFFLE = 11148;   // 章节机缘抽奖请求

    int SELF_WEAPON_EQUIP = 11210;      // 本命法宝装备
    int SELF_WEAPON_UN_EQUIP = 11212;   // 本命法宝卸下

    // 本服竞技场(仙门大比)
    int LOCAL_BATTLE_INFO = 30143;      // 获取竞技场主界面信息
    int LOCAL_BATTLE_MATCH = 11251;     // 匹配
    int LOCAL_BATTLE_CANCEL_MATCH = 11254; // 取消匹配
    int LOCAL_BATTLE_QUIT = 11268;      // 竞技场投降
    int LOCAL_BATTLE_BUY_COUNT = 11261; // 购买论道次数
    int LOCAL_BATTLE_TASK_REWARD = 11266; // 领取竞技场任务奖励
    int LOCAL_BATTLE_GET_RANK_LIST = 30144; // 竞技场排行榜
    int LOCAL_BATTLE_GET_LOG_LIST = 11263; // 战报
    int LOCAL_BATTLE_ENTER = 30146;     // 进入战斗
    int LOCAL_BATTLE_EXIT = 11258;      // 退出战斗

    // 本命法宝-升星
    int SELF_WEAPON_UP_STAR = 11203;    // 本命法宝升星

    // 本命法宝-激活
    int SELF_WEAPON_ACTIVATE = 11201;   // 本命法宝激活

    // 谁与争锋(活动排行)
    int RANK_ACTIVITY_GET_RANK_LIST = 30376; // 排行活动获取排行榜数据
    int RANK_ACTIVITY_RECEIVE_REWARD = 11351; // 排行活动领取阶段奖励请求
    int RANK_ACTIVITY_GET_TOP_RANK = 30378; // 排行活动获取所有排行榜的第一名数据

    // 新服目标
    int NEW_SERVER_GOAL_GET_SCORE_REWARD = 12145; // 新服目标获取分数奖励
    int NEW_SERVER_GOAL_GET_TASK_REWARD = 12143; // 新服目标获取任务奖励

    int MAGIC_FIRE_ACTIVATE = 11331;    // 异火激活
    int MAGIC_FIRE_UPGRADE = 11333;     // 异火升级

    int MAGIC_FIRE_LOTTERY = 11336;     // 异火抽奖请求
    int MAGIC_FIRE_LOTTERY_REFRESH = 11338; // 异火刷新请求

    // 异火融合
    int MAGIC_FIRE_EQUIP = 11340;       // 异火装备
    int MAGIC_FIRE_UN_EQUIP = 11342;    // 异火卸下
    int MAGIC_FIRE_EQUIP_SKILL = 11344; // 异火装备技能
    int MAGIC_FIRE_ONE_KEY_EQUIP = 11346; // 异火一键装备

    int BOX_LOTTERY = 11362;            // 地图异火抽奖请求
    int BOX_LOTTERY_GIVE_UP = 11364;    // 地图异火放弃抽奖请求

    // 时装
    int FASHION_ACTIVATE = 11321;       // 时装激活
    int FASHION_WEAR = 11323;           // 时装穿戴
    int FASHION_CONFIRM_EXPIRED_RPT = 11326; // 时装过期确认

    // 称号
    int HERO_TITLE_ACTIVATE = 11313;    // 称号激活
    int HERO_TITLE_WEAR = 11315;        // 称号穿戴

    // 充值礼包
    int RECHARGE_GIFT_ACT_RECEIVE = 11397; // 玩家在充值购买礼包后，可领取购买之日起第X天的奖励

    // 充值礼包(新)
    int NEW_RECHARGE_GIFT_ACT_RECEIVE = 11602; // 充值礼包活动领取奖励, 通用请求, value1:活动id value2:礼包id

    // 物品合成
    int ITEM_MERGE = 10211;             // 物品合成

    // GM
    int GM_COMMAND = 10142;             // GM命令

    // 设置副本可以攻击
    int DUPLICATE_SET_CAN_ATTACK_RPT = 11393; // 设置副本可以攻击

    // 材料副本
    int SWEEP_MATERIAL_DUPLICATE = 11451; // 材料副本扫荡
    int MATERIAL_DUPLICATE_BUY_TIMES = 11453; // 材料副本购买次数
    int CHALLENGE_MATERIAL_DUPLICATE = 30398; // 材料副本挑战

    // 战斗中切换伙伴
    int SWITCH_BATTLE_NPC = 10795;      // 战斗中切换伙伴

    // 免费礼遇(企业微信跳转)
    int FREE_GIFT_GET_BINDING_CODE = 11483; // 免费礼遇获取绑定码

    // 限时礼包
    int LIMIT_TIME_GIFT_BUY = 11413;    // 限时礼包购买
    int LIMIT_TIME_GIFT_TRIGGER_RPT = 11416; // 限时礼包触发上报

    // 赛季(天道桎梏)
    int SEASON_GET_RANK_LIST = 30407;   // 获取赛季排行榜请求，通用请求，value1值为1时代表只获取前三名

    // taptap评价
    int COMMENT_REWARD_RECEIVE = 11481; // 评价奖励领取

    // 客户端迷雾解锁
    int CLIENT_UNLOCK_FOG = 11490;      // 客户端迷雾解锁

    // 聚灵圣种(消耗返利)
    int UPGRADE_SPEND_RESERVE = 11583;  // 升级聚灵圣种奖励请求 通用请求 value1为活动id
    int RECEIVE_SPEND_RESERVE = 11585;  // 领取聚灵圣种奖励请求 通用请求 value1为活动id

    // 预下载奖励领取
    int RECEIVE_RES_PACKAGE_REWARD = 11494; // 预下载奖励领取

    // 充值
    int CREATE_ORDER = 10020;           // 创建充值订单

    int GM_DAMAGE_RECORD = 10144;       // GM伤害记录

    // 多人副本优化
    int WORLD_BOSS_RECEIVE_REWARD = 11530; // 世界boss领取奖励
    int DUPLICATE_MATCH = 30394;        // 副本匹配
    int DUPLICATE_CANCEL_MATCH = 30392; // 副本取消匹配

    // 战令
    int BATTLE_PASS_RECEIVE_REWARD = 11562; // 战令领取奖励

    // 脱离卡死
    int MAP_ESCAPE_STUCK = 11541;       // 地图上脱离卡死，传送到当前地图默认坐标, null
    int USE_USER_BAG = 11568;           // 使用个人背包

    int RECEIVE_RECHARGE_REBATE = 11572; // 领取充值返利

    int WEEKLY_BOSS_CHALLENGE = 11592;  // 周常boss挑战
    int WEEKLY_BOSS_GET_MONSTER_DATA = 11594; // 周常boss大厅消息

    // 一键应用流派
    int SUGGEST_MAJOR_EQUIP = 11511;    // 推荐主要装备
    int SUGGEST_MAJOR_INNAT = 11513;    // 推荐主要天赋

    int TEAM_RECRUIT_JOIN_TEAM = 30233; // 队伍招募
    int RECHARGE_GET_REBATE_RESULT = 11575; // 获取返利信息
}
