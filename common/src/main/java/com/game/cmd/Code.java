package com.game.cmd;

/**
 * 游戏系统错误码定义接口
 * 包含游戏中各种功能模块的错误码常量
 */
public interface Code {
    /** 成功 */
    int CODE_OK = 0;
    /** 从背包移除物品错误 */
    int CODE_REMOVE_FROM_BAG_ERROR = 10065;
    /** 时装已过期 */
    int CODE_FASHION_EXPIRED = 10227;
    /** 无法进入队伍 */
    int CODE_CAN_NOT_IN_TEAM = 10052;
    /** 章节任务不存在 */
    int CODE_CHAPTER_TASK_NOT_EXIST = 10214;
    /** 正在救援中 */
    int CODE_RESCUING = 10039;
    /** 坐骑处于空中障碍状态 */
    int CODE_RIDE_IS_AIR_BLOCK = 10201;
    /** 位置错误 */
    int CODE_ERROR_POSITION = 10026;
    /** 自然力不足 */
    int CODE_FORCE_OF_NATURE_NOT_ENOUGH = 10188;
    /** 已经在公会中 */
    int CODE_ALREADY_IN_GUILD = 10013;
    /** 地图收集物不存在 */
    int CODE_MAP_COLLECTION_NOT_EXISTS = 10175;
    /** 正在战斗中 */
    int CODE_IS_IN_BATTLE = 10162;
    /** 无法出售 */
    int CODE_CAN_NOT_SELL = 10149;
    /** 活动时间限制 */
    int CODE_ACTIVITY_TIME_LIMIT = 10136;
    /** 新加入成员阵营等级限制 */
    int CODE_NEW_JOIN_MEMBER_CAMP_LEVEL_LIMIT = 10298;
    /** 账号已冻结 */
    int CODE_ACCOUNT_FREEZED = 10123;
    /** 队长匹配中无法离开 */
    int CODE_CAPTAIN_CANNOT_LEAVE_WHEN_MATCHING = 10285;
    /** NPC药品达到上限 */
    int CODE_NPC_DRUG_MAX = 10110;
    /** 不在挂机战斗时间内 */
    int CODE_HAND_UP_NOT_IN_BATTLE_TIME = 10272;
    /** 讨论次数达到上限 */
    int CODE_DISCUSS_MAX = 10097;
    /** 需要登录激活码 */
    int CODE_NEED_LOGIN_ACTIVATE_CODE = 10259;
    /** 好友数量达到上限 */
    int CODE_ADD_FRIEND_MAX = 10084;
    /** 阵营日常任务已接受 */
    int CODE_CAMP_DAILY_TASK_HAS_ACCEPT = 10246;
    /** 充值金额限制 */
    int CODE_RECHARGE_AMOUNT_LIMIT = 10071;
    /** 魔法火焰技能错误 */
    int CODE_MAGIC_FIRE_SKILL_ERROR = 10233;
    /** 货币不足 */
    int CODE_CURRENCY_NOT_ENOUGH = 10058;
    /** 本地战斗匹配切换服务器错误 */
    int CODE_LOCAL_BATTLE_MATCH_SWITCH_SERVER_ERROR = 10220;
    /** 已在副本中 */
    int CODE_IN_DUPLICATE = 10045;
    /** 章节已完成 */
    int CODE_CHAPTER_HAS_FINSHED = 10207;
    /** 聊天消息为空 */
    int CODE_CHAT_MSG_EMPTY = 10032;
    /** 队伍自然力不足 */
    int CODE_TEAM_FORCE_OF_NATURE_NOT_ENOUGH = 10194;
    /** 不在公会中 */
    int CODE_NOT_IN_GUILD = 10019;
    /** 队伍成员正在战斗 */
    int CODE_TEAM_MEMBER_IS_FIGHT = 10181;
    /** 正在登录中 */
    int CODE_LOGING = 10006;
    /** 邂逅不存在 */
    int CODE_MEET_NOT_EXIST = 10168;
    /** 有正在拍卖的玩家 */
    int CODE_HAS_AUCTION_PLAYER = 10155;
    /** 战斗匹配中 */
    int CODE_BATTLE_MATCHING = 10142;
    /** 奖励已升级 */
    int CODE_REWARD_UPGRADED = 10304;
    /** 副本人数已满 */
    int CODE_DUPLICATE_FULL = 10129;
    /** 精灵已损坏无法装备 */
    int CODE_SPIRIT_BROKEN_NO_EQUIP = 10291;
    /** 激活错误4 */
    int CODE_ACTIVATE_ERROR_4 = 10116;
    /** 玩家正在切换线路 */
    int CODE_PLAYER_IS_SWITCHING_LINE = 10278;
    /** 宠物不存在 */
    int CODE_PET_NOT_EXIST = 10103;
    /** 无法在加入救援状态下移动 */
    int CODE_NO_MOVING_IN_JOIN_RESCUE_STATUS = 10265;
    /** 队伍等级限制 */
    int CODE_TEAM_LEVEL_LIMIT = 10090;
    /** 队伍成员自然力不足 */
    int CODE_TEAM_MEMBER_FORCE_OF_NATURE_NOT_ENOUGH = 10252;
    /** 举报错误-未阅读 */
    int CODE_DELATE_ERROR_NOT_READED = 10077;
    /** 已过期 */
    int CODE_EXPIRE_TIME = 10239;
    /** 不在可用装备中 */
    int CODE_NOT_IN_AVAILABLE_EQUIP = 10064;
    /** 时装未激活 */
    int CODE_FASHION_NOT_ACTIVATED = 10226;
    /** 地图事件未找到 */
    int CODE_MAP_EVENT_NOT_FOUND = 10051;
    /** 章节未开启 */
    int CODE_CHAPTER_NOT_OPEN = 10213;
    /** 计数限制 */
    int CODE_COUNT_LIMIT = 10038;
    /** NPC已经咨询过 */
    int CODE_NPC_IS_ALREADY_CONSULT = 10200;
    /** 已领取 */
    int CODE_ALREADY_RECEIVED = 10025;
    /** 宠物不是稀有的 */
    int CODE_PET_IS_NOT_RARE = 10187;
    /** 角色数量达到上限 */
    int CODE_MAX_ROLE_COUNT = 10012;
    /** 地图收集物限制 */
    int CODE_MAP_COLLECTION_LIMIT = 10174;
    /** 没有可申请的公会 */
    int CODE_NO_GUILD_CAN_APPLY = 10161;
    /** 公共状态限制 */
    int CODE_PUBLIC_STATUS_LIMIT = 10148;
    /** 跨服配置错误 */
    int CODE_CROSS_CONFIG_ERROR = 10135;
    /** 新加入成员自然力限制 */
    int CODE_NEW_JOIN_MEMBER_FORCE_OF_NATURE_LIMIT = 10297;
    /** 队长匹配中无法转让 */
    int CODE_CAPTAIN_CANNOT_TRANSFER_WHEN_MATCHING = 10284;
    /** NPC经验已满 */
    int CODE_NPC_EXP_MAX = 10109;
    /** 本地战斗已结束 */
    int CODE_LOCAL_BATTLE_BATTLE_IS_END = 10271;
    /** 教学次数达到上限 */
    int CODE_TEACH_MAX = 10096;
    /** 登录激活码无效 */
    int CODE_LOGIN_ACTIVATE_CODE_INVALID = 10258;
    /** 精灵宠物未找到 */
    int CODE_SPIRIT_PET_NOT_FOUND = 10083;
    /** 阵营日常任务接受数量限制 */
    int CODE_CAMP_DAILY_TASK_ACCEPT_NUM_LIMIT = 10245;
    /** 无效操作 */
    int CODE_INVALID_OPERATION = 10070;
    /** 魔法火焰无法连击 */
    int CODE_MAGIC_FIRE_CAN_NOT_COMBO = 10232;
    /** 经验不足 */
    int CODE_EXP_NOT_ENOUGH = 10057;
    /** 新服务器分数不足 */
    int CODE_NEW_SERVER_SCORE_NOT_ENOUGH = 10219;
    /** 功能关闭 */
    int CODE_FUNCTION_CLOSE = 10044;
    /** 没有可领取的奖励 */
    int CODE_NO_REWARD_TO_BE_RECEIVED = 10206;
    /** 无法强化 */
    int CODE_CAN_NOT_STRENGTHEN = 10031;
    /** 需要完成副本 */
    int CODE_NEED_COMPLETE_DUPLICATE = 10193;
    /** 没有权限 */
    int CODE_HAS_NO_AUTHORITY = 10018;
    /** 重新登录 */
    int CODE_RELOGIN = 10180;
    /** 服务器在线人数限制 */
    int CODE_SERVER_ONLINE_LIMIT = 10005;
    /** 服务器创建角色限制 */
    int CODE_SEVER_CREATE_ROLE_LIMIT = 10167;
    /** 出售总数限制 */
    int CODE_SELL_TOTAL_COUNT_LIMIT = 10154;
    /** 概率不满足 */
    int CODE_PROBABILITY_NOT = 10141;
    /** NPC装备背包已满 */
    int CODE_NPC_EQUIP_BAG_IS_FULL = 10303;
    /** 背包已满 */
    int CODE_PACKAGE_FULL = 10128;
    /** 精灵无法修复 */
    int CODE_SPIRIT_NO_REPAIR = 10290;
    /** 激活错误3 */
    int CODE_ACTIVATE_ERROR_3 = 10115;
    /** 挂机队伍成员限制 */
    int CODE_HAND_UP_TEAM_MEMBER_LIMIT = 10277;
    /** 精灵宠物药品已满 */
    int CODE_SPIRIT_PET_DRUG_MAX = 10102;
    /** 无法在救援状态下移动 */
    int CODE_NO_MOVING_IN_RESCUE_STATUS = 10264;
    /** NPC爱情不足 */
    int CODE_NPC_LOVE_NOT_ENOUGH = 10089;
    /** 队伍成员塔数量限制 */
    int CODE_TEAM_MEMBER_TOWER_NUM_LIMIT = 10251;
    /** 举报错误-带附件 */
    int CODE_DELATE_ERROR_WITH_ATTACHMENT = 10076;
    /** 条件限制 */
    int CODE_CONDITION_LIMIT = 10238;
    /** 当前位置已装备 */
    int CODE_CUR_POS_EQUIPPED = 10063;
    /** 英雄称号佩戴状态非法 */
    int CODE_HERO_TITLE_WEAR_STATUS_ILLEGAL = 10225;
    /** 狩猎地图未开启 */
    int CODE_HUNT_MAP_NOT_OPENED = 10050;
    /** 宠物正在工作 */
    int CODE_PET_IS_WORKING = 10212;
    /** 购买次数限制 */
    int CODE_BUY_COUNT_LIMIT = 10037;
    /** NPC功能检查错误 */
    int CODE_NPC_FUNC_CHECK_ERROR = 10199;
    /** 没有任务 */
    int CODE_HAS_NO_TASK = 10024;
    /** 宠物已培养 */
    int CODE_PET_IS_CULTIVATED = 10186;
    /** 保存玩家失败 */
    int CODE_SAVE_PLAYER_FAILED = 10011;
    /** 邂逅已奖励 */
    int CODE_MEET_IS_REWARD = 10173;
    /** 角色已删除 */
    int CODE_ROLE_IS_DELETED = 10160;
    /** 低于其他价格 */
    int CODE_LESS_THAN_OTHER_PRICE = 10147;
    /** 玩家背包无法保存已升级物品 */
    int CODE_USER_BAG_CANNOT_SAVE_ITEM_PROMOTED = 10309;
    /** 精灵宠物食物已满 */
    int CODE_SPIRIT_PET_FOOD_FULL = 10134;
    /** 新加入成员等级限制 */
    int CODE_NEW_JOIN_MEMBER_LEVEL_LIMIT = 10296;
    /** 激活错误9 */
    int CODE_ACTIVATE_ERROR_9 = 10121;
    /** 匹配完成成员地图不同 */
    int CODE_MATCH_FINISH_MEMBER_MAP_NOT_SAME = 10283;
    /** 潜行CD中 */
    int CODE_SNEAK_CD = 10108;
    /** 跳跃距离过远 */
    int CODE_JUMP_TOO_FAR = 10270;
    /** NPC讨论次数达到上限 */
    int CODE_NPC_DISCUSS_MAX = 10095;
    /** 登录激活码已使用 */
    int CODE_LOGIN_ACTIVATE_CODE_USED = 10257;
    /** 物品使用错误 */
    int CODE_ITEM_USE_ERROR = 10082;
    /** 心装备位置错误 */
    int CODE_HEART_EQUIP_POS_ERROR = 10244;
    /** 角色超时 */
    int CODE_ROLE_OVER_TIME = 10069;
    /** 没有可抽奖的奖励 */
    int CODE_NO_REWARD_CAN_LOTTERY = 10231;
    /** BUFF限制 */
    int CODE_BUFF_LIMIT = 10056;
    /** 任务未完成 */
    int CODE_TASK_NOT_FINISH = 10218;
    /** 耐心不足 */
    int CODE_PATIENCE_NOT_ENOUGH = 10043;
    /** 洞穴等级已达最大 */
    int CODE_CAVE_LEVEL_MAX = 10205;
    /** 位置无效 */
    int CODE_POSITION_INVALID = 10030;
    /** 海上救援 */
    int CODE_RESCUE_IN_SEA = 10192;
    /** 成员数量限制 */
    int CODE_MEMBER_COUNT_LIMIT = 10017;
    /** 邀请成员困难副本关闭 */
    int CODE_INVITE_MEMBER_HDUPLICATE_CLOSE = 10179;
    /** 登录无效 */
    int CODE_INVALID_LOGIN = 10004;
    /** 正在拍卖中 */
    int CODE_AUCTIONING = 10166;
    /** 出售数量限制 */
    int CODE_SELL_COUNT_LIMIT = 10153;
    /** 积分限制 */
    int CODE_SCORE_LIMIT = 10140;
    /** 新加入成员挂机锁定限制 */
    int CODE_NEW_JOIN_MEMBER_HAND_UP_LOCK_LIMIT = 10302;
    /** 集会日常限制 */
    int CODE_ASSEMBLY_DAILY_LIMIT = 10127;
    /** 精灵已损坏 */
    int CODE_SPIRIT_IS_BROKEN = 10289;
    /** 激活错误2 */
    int CODE_ACTIVATE_ERROR_2 = 10114;
    /** 宝箱已完成 */
    int CODE_BOX_IS_FINISHED = 10276;
    /** 精灵宠物经验已满 */
    int CODE_SPIRIT_PET_EXP_MAX = 10101;
    /** 救援位置已被占用 */
    int CODE_RESCUE_POS_HAS_OCCUPIED = 10263;
    /** NPC求助CD中 */
    int CODE_NPC_ASK_FOR_IN_CD = 10088;
    /** 塔数量限制 */
    int CODE_TOWER_NUM_LIMIT = 10250;
    /** 没有附件 */
    int CODE_NO_ATTACHMENT = 10075;
    /** 充值礼包时间未到 */
    int CODE_RECHARGE_GIFT_TIME_NOT_REACH = 10237;
    /** 需要点数限制 */
    int CODE_NEED_POINT_LIMIT = 10062;
    /** 英雄称号未找到 */
    int CODE_HERO_TITLE_NOT_FOUND = 10224;
    /** 对象未找到 */
    int CODE_OBJECT_NOT_FOUND = 10049;
    /** 自武器装备位置错误 */
    int CODE_SELF_WEAPON_EQUIP_POS_ERROR = 10211;
    /** 官员数量限制 */
    int CODE_OFFICER_COUNT_LIMIT = 10036;
    /** 抽奖宝石值不足 */
    int CODE_LOTTERY_GEM_VALUE_NOT_ENOUGH = 10198;
    /** 公会已被弹劾 */
    int CODE_GUILD_ALREADY_IMPEACHED = 10023;
    /** 宠物正在战斗中 */
    int CODE_PET_IS_IN_BATTLE = 10185;
    /** 保存用户失败 */
    int CODE_SAVE_USER_FAILED = 10010;
    /** 邂逅已完成 */
    int CODE_MEET_IS_COMPLETED = 10172;
    /** 狩猎物品不足 */
    int CODE_HUNT_ITEM_NOT_ENOUGH = 10159;
    /** 订单不存在 */
    int CODE_ORDER_NOT_EXIST = 10146;
    /** 操作过于频繁 */
    int CODE_OPERATION_FREQUENTLY = 10308;
    /** 新加入成员塔数量限制 */
    int CODE_NEW_JOIN_MEMBER_TOWER_NUM_LIMIT = 10295;
    /** 激活错误8 */
    int CODE_ACTIVATE_ERROR_8 = 10120;
    /** 队伍机器人无法踢出 */
    int CODE_TEAM_ROBOT_CANNOT_KICK = 10282;
    /** NPC魔法背包已满 */
    int CODE_NPC_MAGIC_BAG_IS_FULL = 10107;
    /** NPC教学次数已达上限 */
    int CODE_NPC_TEACH_MAX = 10094;
    /** 队伍成员任务未完成 */
    int CODE_TEAM_MEMBER_TASK_NOT_FINISH = 10256;
    /** 登录冲突 */
    int CODE_LOGING_CLASH = 10081;
    /** 代理已死亡 */
    int CODE_AGENT_DIE = 10243;
    /** 拍卖策略错误 */
    int CODE_ACUTION_STRATEGY_ERROR = 10068;
    /** 魔法火焰已存在 */
    int CODE_MAGIC_FIRE_EXISTS = 10230;
    /** 等级限制 */
    int CODE_LEVEL_LIMIT = 10055;
    /** 章节幸运池为空 */
    int CODE_CHAPTER_LUCKY_POOL_NULL = 10217;
    /** 已在拍卖中 */
    int CODE_ALREADY_IN_AUCTION = 10042;
    /** 英雄装备位置错误 */
    int CODE_HERO_EQUIP_POS_ERROR = 10204;
    /** 装备不存在 */
    int CODE_EQUIPMENT_NOT_EXISTS = 10029;
    /** 公会不存在 */
    int CODE_GUILD_NOT_EXISTS = 10016;
    /** 队伍成员困难副本关闭 */
    int CODE_TEAM_MEMBER_HDUPLICATE_CLOSE = 10178;
    /** 服务器忙 */
    int CODE_SERVER_BUSY = 10003;
    /** 操作重复 */
    int CODE_OPERATION_REPEAT = 10165;
    /** 价格限制 */
    int CODE_PRICE_LIMIT = 10152;
    /** 加入次数限制 */
    int CODE_JOIN_COUNT_LIMIT = 10139;
    /** 新加入成员困难副本关闭 */
    int CODE_NEW_JOIN_MEMBER_HDUPLICATE_CLOSE = 10301;
    /** 七日限制 */
    int CODE_SEVEN_DAY_LIMIT = 10126;
    /** 激活错误1 */
    int CODE_ACTIVATE_ERROR_1 = 10113;
    /** 任务已领取 */
    int CODE_TASK_IS_RECEIVED = 10275;
    /** 精灵宠物战斗错误 */
    int CODE_SPIRIT_PET_BATTLE_ERROR = 10100;
    /** 挂机次数限制 */
    int CODE_HAND_UP_COUNT_LIMIT = 10262;
    /** NPC不存在 */
    int CODE_NPC_NOT_EXIST = 10087;
    /** 队伍成员条件错误 */
    int CODE_TEAM_MEMBER_CONDITION_ERROR = 10249;
    /** 跳转地图等级限制 */
    int CODE_JUMP_MAP_LEVEL_LIMIT = 10074;
    /** 充值礼包未购买 */
    int CODE_RECHARGE_GIFT_NOT_BUY = 10236;
    /** 物品未找到 */
    int CODE_ITEM_NOT_FOUND = 10061;
    /** 英雄称号已激活 */
    int CODE_HERO_TITLE_HAS_ACTIVATED = 10223;
    /** 存在相同任务 */
    int CODE_EXISTS_SAME_TASK = 10048;
    /** 自武器书星级限制 */
    int CODE_SELF_WEAPON_BOOK_STAR_LIMIT = 10210;
    /** 玩家不在线 */
    int CODE_PLAYER_NOT_ONLINE = 10035;
    /** NPC成为爱人任务未完成 */
    int CODE_NPC_BECOME_LOVE_TASK_NOT_FINISH = 10197;
    /** 全部拒绝 */
    int CODE_DISAGREE_ALL = 10022;
    /** 宠物材料不足 */
    int CODE_PET_CRUDE_NOT_ENOUGH = 10184;
    /** 保存用户未找到 */
    int CODE_SAVE_USER_NOT_FOUND = 10009;
    /** 邂逅选择重复 */
    int CODE_MEET_CHOOSE_REPEATED = 10171;
    /** 驱邪踢出 */
    int CODE_REPEL_EVIL_KICK = 10158;
    /** 神域数量限制 */
    int CODE_GOD_AREA_COUNT_LIMIT = 10145;
    /** 周常BOSS副本解锁 */
    int CODE_WEEKLY_BOSS_DUPLICATE_UNLOCK = 10307;
    /** 邀请队伍超时 */
    int CODE_INVITE_TEAM_TIMEOUT = 10132;
    /** 新加入成员副本未通过 */
    int CODE_NEW_JOIN_MEMBER_DUPLICATE_NOT_PASS = 10294;
    /** 激活错误7 */
    int CODE_ACTIVATE_ERROR_7 = 10119;
    /** 只有队长可以操作 */
    int CODE_ONLY_TEAM_CAPTAIN_CAN_OPERATE = 10281;
    /** 阶段限制 */
    int CODE_STAGE_LIMIT = 10106;
    /** 玩家无法在战斗中加入队伍 */
    int CODE_PLAYER_CANNOT_JOIN_TEAM_IN_FIGHT = 10268;
    /** 队伍已有队伍 */
    int CODE_TEAM_HAS_TEAM = 10093;
    /** 困难副本购买上限 */
    int CODE_H_DUPLICATE_BUY_MAX = 10255;
    /** 世界BOSS成员未通过 */
    int CODE_WORLD_BOSS_MEMBER_NOT_PASS = 10080;
    /** 功能不允许 */
    int CODE_FUNCTION_NOT_ALLOW = 10242;
    /** 删除角色公会 */
    int CODE_DEL_ROLE_GUILD = 10067;
    /** 时装已激活 */
    int CODE_FASHION_ACTIVATED = 10229;
    /** 副本未开启 */
    int CODE_DUPLICATE_NOT_OPEN = 10054;
    /** 章节任务未完成 */
    int CODE_CHAPTER_TASK_NOT_FINISH = 10216;
    /** 地图限制 */
    int CODE_MAP_LIMIT = 10041;
    /** 英雄装备类型错误 */
    int CODE_HERO_EQUIP_TYPE_ERROR = 10203;
    /** 背包已满 */
    int CODE_BAG_IS_FULL = 10028;
    /** 坐骑经验达到上限 */
    int CODE_RIDE_EXP_MAX_LIMIT = 10190;
    /** 公会招募公告限制 */
    int CODE_GUILD_RECRUIT_ENOUNCE_LIMIT = 10015;
    /** 公会已申请 */
    int CODE_GUILD_ALREADY_REQUEST = 10177;
    /** 参数错误 */
    int CODE_PARAM_ERROR = 10002;
    /** 炼宝道具为零 */
    int CODE_LIAN_BAO_PROP_ZERO = 10164;
    /** 大小限制 */
    int CODE_SIZE_LIMIT = 10151;
    /** 战斗关闭 */
    int CODE_BATTLE_CLOSE = 10138;
    /** 新加入成员数量限制 */
    int CODE_NEW_JOIN_MEMBER_COUNT_LIMIT = 10300;
    /** 七日已领取 */
    int CODE_SEVEN_DAY_RECEIVE = 10125;
    /** 队伍成员信息变更 */
    int CODE_TEAM_MEMBER_INFO_CHANGE = 10287;
    /** 集会不存在 */
    int CODE_ASSEMBLY_NOT_EXIST = 10112;
    /** 挂机奖励为空 */
    int CODE_HAND_UP_REWARD_IS_NULL = 10274;
    /** 精灵宠物达到上限 */
    int CODE_SPIRIT_PET_MAX = 10099;
    /** 迷雾已解锁 */
    int CODE_FOG_ALREADY_UNLOCK = 10261;
    /** 信息错误 */
    int CODE_INFO_ERROR = 10086;
    /** 阵营日常任务已全部接受 */
    int CODE_CAMP_DAILY_TASK_ALL_ACCEPT = 10248;
    /** 改名时间限制 */
    int CODE_CHANGE_NAME_TIME_LIMIT = 10235;
    /** 公会名已存在 */
    int CODE_GUILD_NAME_EXISTS = 10060;
    /** 迷雾阻挡 */
    int CODE_FOG_BLOCK = 10222;
    /** 队伍成员物品不足 */
    int CODE_TEAM_MEMBER_ITEM_NOT_ENOUGH = 10047;
    /** 自武器书星级错误 */
    int CODE_SELF_WEAPON_BOOK_STAR_ERROR = 10209;
    /** 包含敏感词 */
    int CODE_INCLUDE_SESITIVE_WORDS = 10034;
    /** 答案错误 */
    int CODE_ANSWER_IS_WRONG = 10196;
    /** 时间限制 */
    int CODE_TIME_LIMIT = 10021;
    /** 宠物图鉴配置错误 */
    int CODE_PET_BOOK_CONFIG_ERROR = 10183;
    /** 名称已存在 */
    int CODE_NAME_EXISTS = 10008;
    /** 邂逅按钮限制 */
    int CODE_MEET_BUTTON_LIMIT = 10170;
    /** 没有申请的公会 */
    int CODE_NOT_HAVE_APPLY_GUILD = 10157;
    /** 神域已移动 */
    int CODE_GOD_AREA_ALREADY_MOVE = 10144;
    /** 周常BOSS大厅解锁 */
    int CODE_WEEKLY_BOSS_HALL_UNLOCK = 10306;
    /** 命运无法改变未重置 */
    int CODE_DESTINY_CANNOT_CHANGE_NOT_RESET = 10293;
    /** 激活错误6 */
    int CODE_ACTIVATE_ERROR_6 = 10118;
    /** 副本匹配中 */
    int CODE_DUPLICATE_MATCHING = 10280;
    /** NPC物品为空 */
    int CODE_NPC_ITEM_NULL = 10105;
    /** 无法在战斗中创建队伍 */
    int CODE_CANNOT_CREATE_TEAM_IN_FIGHT = 10267;
    /** 队伍不存在 */
    int CODE_TEAM_TEAM_NOT_EXIST = 10092;
    /** 队伍成员阵营等级不足 */
    int CODE_TEAM_MEMBER_CAMP_LEVEL_NOT_ENOUGH = 10254;
    /** 世界BOSS未通过 */
    int CODE_WORLD_BOSS_NOT_PASS = 10079;
    /** 功能数据错误 */
    int CODE_FUNCTION_DATA_ERROR = 10241;
    /** 不在队伍中 */
    int CODE_NOT_IN_TEAM = 10066;
    /** 物品已过期 */
    int CODE_ITEM_EXPIRED = 10228;
    /** 成员不在同一地图 */
    int CODE_MEMBER_NOT_IN_SAME_MAP = 10053;
    /** 章节任务未全部完成 */
    int CODE_CHAPTER_TASK_NOT_ALL_FINISH = 10215;
    /** 在CD中 */
    int CODE_IN_CD = 10040;
    /** 英雄装备背包已满 */
    int CODE_HERO_EQUIP_BAG_IS_FULL = 10202;
    /** 击杀数量限制 */
    int CODE_KILLED_COUNT_LIMIT = 10027;
    /** 坐骑不存在 */
    int CODE_RIDE_NOT_EXIST = 10189;
    /** 公会名称限制 */
    int CODE_GUILD_NAME_LIMIT = 10014;
    /** 用户登录限制 */
    int CODE_USER_LOGIN_LIMIT = 10176;
    /** 错误 */
    int CODE_ERROR = 10001;
    /** 目标好友已达上限 */
    int CODE_TARGET_FRIEND_MAX = 10163;
    /** 已成长 */
    int CODE_GROWTHED = 10150;
    /** 每日购买次数限制 */
    int CODE_DAILY_BUY_COUNT_LIMIT = 10137;
    /** 新加入成员任务未完成 */
    int CODE_NEW_JOIN_MEMBER_TASK_NOT_FINISH = 10299;
    /** 聊天已冻结 */
    int CODE_CHAT_FREEZED = 10124;
    /** 无法在匹配中创建队伍 */
    int CODE_CANNOT_CREATE_TEAM_WHEN_MATCHING = 10286;
    /** NPC关系限制 */
    int CODE_NPC_RELATION_LIMIT = 10111;
    /** 挂机副本锁定 */
    int CODE_HAND_UP_DUPLICATE_LOCK = 10273;
    /** 精灵宠物品质限制 */
    int CODE_SPIRIT_PET_QUALITY_LIMIT = 10098;
    /** 队伍我有队伍 */
    int CODE_TEAM_ME_HAS_TEAM = 10260;
    /** NPC已存在 */
    int CODE_NPC_ALREADY_EXIST = 10085;
    /** 阵营日常任务未接受 */
    int CODE_CAMP_DAILY_TASK_NOT_ACCEPT = 10247;
    /** 救援加入次数限制 */
    int CODE_RESCUE_JOIN_COUNT_LIMIT = 10072;
    /** 集会已结束 */
    int CODE_ASSEMBLY_HAS_FINISHED = 10234;
    /** 物品不足 */
    int CODE_ITEM_NOT_ENOUGH = 10059;
    /** 需要激活特权卡 */
    int CODE_NEED_ACTIVATE_PRIVILEGE_CARD = 10221;
    /** 队伍成员数量限制 */
    int CODE_TEAM_MEMBER_COUNT_LIMIT = 10046;
    /** 自武器已存在 */
    int CODE_SELF_WEAPON_IS_EXIST = 10208;
    /** 聊天CD中 */
    int CODE_IN_CHAT_CD = 10033;
    /** 坐骑死亡技能错误 */
    int CODE_RIDE_DIE_SKILL_ERROR = 10195;
    /** 长度限制 */
    int CODE_LENGTH_LIMIT = 10020;
    /** 宠物图鉴ID已存在 */
    int CODE_PET_BOOK_ID_EXISTS = 10182;
    /** 没有角色 */
    int CODE_NO_ROLE = 10007;
    /** 邂逅次数限制 */
    int CODE_MEET_COUNT_LIMIT = 10169;
    /** 订单已过期 */
    int CODE_ORDER_EXPIRED = 10156;
    /** 神域移动限制 */
    int CODE_GOD_AREA_MOVE_LIMIT = 10143;
    /** 周常BOSS次数限制 */
    int CODE_WEEKLY_BOSS_COUNT_LIMIT = 10305;
    /** 拍卖最后NPC */
    int CODE_AUCTION_LAST_NPC = 10130;
    /** 命运无法重复重置 */
    int CODE_DESTINY_CANNOT_RESET_REPEATLY = 10292;
    /** 激活错误5 */
    int CODE_ACTIVATE_ERROR_5 = 10117;
    /** 游戏维护中 */
    int CODE_WORLD_MAINTENANCE = 10279;
    /** NPC偷窃CD中 */
    int CODE_NPC_STEAL_IN_CD = 10104;
    /** 队伍战斗中无法加入 */
    int CODE_TEAM_IS_FIGHT_CANNOT_JOIN = 10266;
    /** 队伍成员已达上限 */
    int CODE_TEAM_MEMBER_MAX = 10091;
    /** 阵营等级不足 */
    int CODE_CAMP_LEVEL_NOT_ENOUGH = 10253;
    /** 狩猎已退出 */
    int CODE_HUNT_ALREADY_EXIT = 10078;
    /** 物品类型错误 */
    int CODE_ITEM_TYPE_ERROR = 10240;
    /** 玩家不存在 */
    int CODE_PLAYER_NOT_EXISTS = 10800;
    /** 物品不存在 */
    int CODE_ITEM_NOT_EXISTS = 10801;
    /** 物品数量不足 */
    int CODE_ITEM_COUNT_NOT_ENOUGH = 10802;
    /** 物品不可使用 */
    int CODE_ITEM_CANNOT_USE = 10803;
}
