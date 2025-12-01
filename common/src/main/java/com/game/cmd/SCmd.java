package com.game.cmd;

/**
 * SCmd 协议号常量定义
 * 自动生成，来源于 int lua 与 CSProtoId.txt
 */
public interface SCmd {

    int HEARTBEAT = 10002; // 心跳返回

    int USER_LOGIN = 10004; //  用户登录返回
    int CREATE_ROLE = 10006; //  创建角色返回
    int ROLE_LOGIN = 10008; //  角色登录
    int ROLE_OPERATION = 10011; //  操作角色返回
    int UPDATE_GLOBE_PARAM = 10032; //  更新全局变量
    int SEVER_PUSH_END = 10102; //  服务器数据推送完毕
    int KICKOUT = 10012; //  被踢下线
    int EXIT_GAME = 10566; //  注销角色登录
    int CROSS_LOGIN = 10016; //  跨服登录返回 resp通用返回
    int DATA_SEND_FINISH = 10017; //  数据发送完毕
    int ROLE_LIST = 10014; // 拉取角色列表 返回
    int HERO_CHANGE_NAME = 11382; // 角色改名

    int UN_KNOW_ERROR_NTF = 11496; //  未知的错误ntf给客户端，用于客户端上报日志

    int APPEAR_MAP_PROPERTY = 10103; //  出现在地图的地图属性
    int ENTER_GRID_MAP_INIT_NTF = 11423; // 进入过的格子地图列表推送
    int ENTER_GRID_MAP_UPDATE_NTF = 11424; // 进入新的格子地图推送
    int HERO_DATA_INFO = 10101; //  上线通知角色属性
    int OBJ_APPEARANCE_CHANGE = 10110; //  对象外观改变
    int OBJ_APPEAR = 10104; //  对象出现包
    int OBJ_DISAPPEAR = 10105; //  对象消失包
    int OBJ_IDLE = 10107; //  对象待机包
    int OBJ_MOVE = 10106; //  对象移动包
    int OBJ_CHARGE_MOVE = 10130; //  对象冲锋移动包
    int OBJ_JUMP = 10116; //  移动反馈
    int OBJ_ATTACK = 10108; //  对象攻击包
    int OBJ_BE_HIT_NTF = 11425; //  对象受击包
    int ATTACK_TARGETS_NTF = 10135; //  技能攻击到多个目标
    int OBJ_ATTACK_SYNC = 10136; //  与客户端同步由服务器决定的技能参数
    int BATTLE_RESET_NTF = 10134; //  技能攻击到多个目标
    int OBJ_DIE = 10109; //  对象死亡包
    int HP_MP_CHANGE = 10129; //  角色红蓝变化包（关联到施法者）
    int IDLE = 10115; //  待机反馈
    int MOVE = 10113; //  移动反馈
    int ATTACK = 10128; //  攻击反馈
    int JUMP_POINT = 10126; //  地图触发跳转点反馈
    int RELIVE = 10132; //  复活反馈
    int TRAP_ALARM_NTF = 10440; //  机关预警 (目前只有渡劫惊雷坐标)
    int TRAP_TRIGGER_NTF = 10446; //  机关触发 (目前只有渡劫惊雷坐标)
    int JUMP_MAP_NTF = 10559;
    int ZERO_TIME_NTF = 10819; // 服务器时间到零点
    int OBJ_DIRECTION_NTF = 10140; //  对象朝向同步
    int OBJ_RELIVE_NTF = 11392; //  复活ntf
    int OBJ_DEFEAT_POS_SYNC_NTF = 11391; //  击退新位置同步

    //  怪物数量通知
    int MONSTER_NUM_NTF = 30251;

    int WHOLE_OBJ_APPEAR = 10117; //  对象出现包
    int WHOLE_OBJ_DISAPPEAR = 10118; //  对象消失包
    int WHOLE_OBJ_IDLE = 10120; //  对象待机包
    int WHOLE_OBJ_MOVE = 10119; //  对象移动包
    int WHOLE_IDLE = 10124; //  待机反馈
    int WHOLE_MOVE = 10122; //  移动反馈

    int BIG_SCREEN_NEARBY_OBJ = 30259; //  返回大地图玩家附近的对象

    int HERO_ATTR_CHANGE = 10111; // 角色属性改变

    int EQUIP = 10206; //  装备返回
    int HEART_EQUIP = 10220; //  装备心法返回
    int HEART_UNEQUIP = 10222; //  心法卸下返回
    int WEAPON_EQUIP = 10237; //  法宝穿戴返回
    int WEAPON_UNEQUIP = 10239; //  法宝卸下返回
    int HEART_REALIZE_GIVEUP = 10241; // 放弃心法参悟结果返回

    // 角色装备
    int HERO_EQUIPMENT_EQUIP = 11156; // 角色装备穿戴req
    int HERO_EQUIPMENT_UN_EQUIP = 11158; // 角色装备卸下req

    // 角色装备强化
    int HERO_EQUIPMENT_UPGRADE = 11160; //  角色装备强化resp, 通用返回 value为结果(0-成功,1-失败,2-破碎)
    int HERO_EQUIPMENT_REPAIR = 11162; //  角色装备破碎修复resp, 通用返回

    // Npc角色装备
    int NPC_EQUIPMENT_EQUIP = 11164; // npc装备穿戴resp 通用返回
    int NPC_EQUIPMENT_UN_EQUIP = 11166; // npc装备卸下resp 通用返回

    // Npc角色装备强化
    int NPC_EQUIPMENT_UPGRADE = 11168; //  npc装备强化resp, CS_NpcEquipmentUpgradeResp
    int NPC_EQUIPMENT_REPAIR = 11170; //  npc装备破碎修复resp, 通用返回

    int STORAGE_ITEM = 10201; //  包裹物品
    int ITEM_INTO_STORAGE = 10202; //  物品进入包裹
    int ITEM_OUTOF_STORAGE = 10203; //  物品离开包裹
    int ITEM_PROPERTY_CHANGE = 10204; // 物品属性改变
    int ITEM_MOVE_PACKAGE = 10258; // 物品包裹移动
    int ITEM_USE_TIME = 10287; // 使用道具时间
    int USE_ITEM = 10210; // 使用物品(玩家包裹)结果

    //  炼丹
    int MAKE_DRUG = 10444; //  练丹返回

    int HEART_REALIZE = 10229; // 心法参悟返回
    int HEART_REALIZE_SAVE = 10231; // 心法参悟保存替换
    int HEART_UPDATE = 10227; // 升级心法返回
    int HEART_LEARN = 11037; // 收录心法返回

    int UPDATE_LV = 10233; // 升级返回

    //  渡劫
    int GET_RESCUE_NTF = 10429; // 渡劫信息
    int RESCUE_START = 10431; // 渡劫返回
    int RESCUE_RESULT_NTF = 10432; // 渡劫结果
    int RESCUE_JOIN = 10434; // 参与渡劫返回
    int RESCUE_RECEIVE_JOIN_REWARD = 10436; // 领取参与渡劫奖励返回
    int RESCUE_NEW_JOIN_ROLE = 10445; // 更新新加入渡劫人员
    int ENTER_RESCUE_SAVING = 10485; //  进入法宝护主放回

    int CITY_SHOP_SELL = 10247; // 商会出售返回

    //  首充，
    int FIRST_RECHARGE_REWARD = 10538; // 领取首冲奖励resp

    // 月卡
    int MONTH_CARD_REWARD = 10536; // 领取月卡每日奖励resp
    int MONTH_CARD_INFO_NTF = 10539; //  月卡信息

    //  特权
    int RECEIVE_PRIVILEGE_CARD_REWARD = 11292;
    int PRIVILEGE_CARD_REWARD_GET_NTF = 11296;

    // 充值
    int SUCCESS_RECHARGE_ID_INIT_NTF = 10511;
    int RECHARGE_NTF = 10545;

    //  商店
    int SHOP_LIMIT = 10541; //  商店限购信息
    int SHOP_BUY = 10543; // 商店购买返回
    int SHOP_NTF = 10544; //  商店信息返回
    int SHOP_GET_NTF = 10576; //  普通商店信息返回

    int GET_BUFF_LIST_NTF = 10248; // 身上buff或状态
    int UPDATE_BUFF_NTF = 10249; // 增加或删除buff或状态

    // 门派
    int GUILD_LIST = 30102; // 门派列表结果
    int SEARCH_GUILD = 30104; // 搜索门派结果
    int JOIN_GUILD = 30106; // 加入门派结果
    int CREATE_GUILD = 10402; // 创建工会结果
    int GUILD_INFO = 30112; // 获取工会信息
    int UPDATE_GUILD_INFO_NTF = 30113; // 更新工会信息
    int JOIN_GUILD_LIST = 30108; // 申请加入公会列表
    int ANSWER_JOIN_GUILD = 30110; //  回答申请加入的返回
    int EXIT_GUILD = 30121; //  退出工会返回
    int GUILD_NOTICE = 30115; //  设置公告返回
    int GUILD_RECRUIT_SET = 30127; //  招人设置返回
    int GUILD_KICKOUT = 30123; //  门派踢人返回
    int SET_OFFICE_AUTHORITY_RESP = 30119; // 设置职位权限返回
    int IMPEACH_GUILD_RESP = 10404; // 发起工会弹劾返回
    int ANSWER_IMPEACH_GUILD_RESP = 30125; // 回答弹劾返回
    int SET_OFFICE_RESP = 30117; // 设置职位返回
    int GUILD_KICKED_OUT_NTF = 30128; // 被踢消息
    int GET_GUILD_SHOP_LIMIT_INFO = 10425; // 公会商店限购信息返回
    int UPDATE_GUILD_SHOP_LIMIT_INFO_NTF = 10426; // 公会商店限购信息更新推送
    int GUILD_SHOP_BUY = 10428; // 购买商品返回
    int GUILD_DAILY_REWARD = 10442; // 领取公会每日俸禄返回
    int GUILD_JOINED_SYS_GUILD_ARRAY = 10261; // 加入过的系统门派数组
    int GUILD_APPLY_NTF = 30141; //  有人申请加入门派（用于上线刷新红点）
    int GUILD_APPLY_DATA_NTF = 10438; //  门派申请数据ntf(申请了哪些门派)
    int GUILD_APPLY_DATA_CHANGE_NTF = 10439; //  门派申请数据更改ntf
    int ONE_KEY_APPLY_GUILD = 10410; //  一键申请公会

    //  宗门大比
    int GUILD_CHALLENGE_RESULT = 10451; //  公会晋升挑战结果

    int SKILL_LIST = 10301; // 返回技能列表中的技能
    int ADD_SKILL = 10302; // 新增技能
    int DEL_SKILL = 10303; // 删除技能
    int SYNC_SKILL_CD = 10304; // 同步服务器技能CD
    int SKILL_COUNT_NTF = 10305; // 技能可释放次数

    int EQUIPMENT_STRENGTHEN = 10255; // 装备强化返回

    int DO_TASK = 10552; //  做任务返回
    int GET_TASK_LIST_NTF = 10405; // 任务列表
    int UPDATE_TASK_LIST_NTF = 10406; // 刷新任务
    int RECEIVE_TASK_REWARD = 10408; // 领取奖励返回
    int RECEIVED_TASK_LIST_NTF = 10492; // 完成的任务
    int UPDATE_TASK_TRACKING_STATE = 11124; //  更新任务的跟踪状态返回
    int SYS_MESSAGE_NTF = 10031; //  系统消息
    int SYS_MULTI_MESSAGE_NTF = 10034; // 多条系统消息

    int CHAT_RESP = 10422; //  聊天返回
    int CHAT_NTF = 10423; //  聊天广播
    int DELETE_CHAT_LOG_NTF = 10573; //  删除某人的聊天记录

    // 炼宝
    int LIAN_BAO = 10217; // 练宝申请

    int WEAPON_ARTIFICE = 10260; // 法宝炼化返回
    int WEAPON_ARTIFICE_SAVE = 10257; // 炼化保存

    // 法宝凝练
    int WEAPON_CONCISE_RESP = 10448; // 法宝凝练返回

    // 器灵
    int SPIRIT_EQUIP = 10516; //  附灵 和 剥离返回
    int SPIRIT_LEVEL_UP = 10548; //  器灵注灵返回
    int SPIRIT_RECOVER = 10550; //  器灵分解返回
    int SPIRIT_REPAIR = 11567; // 器灵修复返回

    //  拍卖行
    int GET_AUCTION_DATA = 10270; //  获取拍卖行信息
    int UPDATE_AUCTION_DATA = 10271; //  拍卖行信息更新
    int ENTER_AUCTION = 10273; //  进入拍卖行返回
    int LEAVE_AUCTION = 10275; //  离开拍卖行返回
    int AUCTION_ROUND_START = 10277; //  每轮拍卖开始返回
    int AUCTION_ACTION = 10279; //  进行拍卖返回
    int AUCTION_STRATEGY = 10281; //  使用拍卖策略返回
    int AUCTION_RESULT = 10282; //  返回拍卖结果
    int GET_AUCTION_RECORD = 10284; //  获取拍卖纪录返回
    int GET_AUCTION_ITEM_LIST = 10286; //  获取拍卖纪录返回

    // 副本
    int RAID_SET_DRUG = 10478; //  副本设置带入丹药返回
    int RAID_INVITE_ANSWER = 10460; //  世界boss副本邀请答复返回
    int RAID_INVITE_NTF = 10458; //  副本邀请
    int RAID_INVITE_RESPONSE_NTF = 10461; // 世界boss副本邀请广播
    int RAID_CHALLENGE_RESULT = 10469; // 世界boss挑战结果
    int WORLD_RAID_DROP_LIST = 10473; // 副本掉落
    int WORLD_REWARD_LIST = 10464; //  上线推送所有副本掉落
    int RAID_JUMP_ROOM = 10472; //  副本跳转房间返回
    int COMMON_RAID_NTF = 10476; //  战斗通用信息
    int COMPLETE_DUPLICATE_DATA_NTF = 10499; //  已通关副本id
    int COMPLETE_NEW_DUPLICATE_NFT = 10500; //  新通关副本id 副本完成ntf

    // 世界Boss副本
    int WORLD_BOSS_ENTRY_LIST = 10453; // 世界boss副本入口信息
    int WORLD_BOSS_UPDATE_ENTRY_LIST = 10454; // 世界boss副本入口信息更新
    int WORLD_BOSS_INIT_LIST = 10455; // 世界boss副本列表
    int WORLD_BOSS_DUPLICATE_INFO = 10457; //  世界boss副本信息
    int WORLD_BOSS_UPDATE_LIST = 10456; // 世界boss副本列表更新
    int WORLD_BOSS_RANK = 10466; // 获取世界boss副本排行返回
    int WORLD_BOSS_ENTER = 30242; // 进入世界boss返回
    int WORLD_BOSS_BUY_COUNT = 10463; // 世界boss副本购买次数返回

    //  日常副本
    int DAILY_BOSS_ENTRY_LIST = 11070; // 世界boss副本入口信息
    int DAILY_BOSS_UPDATE_ENTRY_LIST = 11071; // 世界boss副本入口信息更新
    int DAILY_BOSS_INIT_LIST = 11066; // 日常boss列表
    int DAILY_BOSS_UPDATE_LIST = 11067; //  日常boss列表更新
    int DAILY_BOSS_RANK = 11069; // 获取日常boss副本排行
    int DAILY_BOSS_ENTER = 30347; // 进入日常boss返回

    // 寻宝
    int DO_HUNT = 10502; // 挖宝返回
    int HUNT_CHALLENGE = 30244; // 寻宝挑战返回
    int HUNT_MAP_EVENT_LIST_NTF = 10503; // 寻宝地图组件信息
    int UPDATE_HUNT_MAP_EVENT_LIST_NTF = 10504; // 寻宝地图组件信息更新
    int HUNT_FINISH_ASSEMBLY = 10603; //  完成寻宝个人组件返回

    // 好友
    int FRIEND_LIST_NTF = 30301;
    int UPDATE_FRIEND_LIST_NTF = 30316;

    int GET_FRIEND_LIST = 30317; // 主动获取好友列表 返回
    int INIT_FRIEND_APPLY_LIST = 30302;
    int UPDATE_FRIEND_APPLY_LIST = 30343;

    int QUERY_SUGGEST_FRIEND = 30304;
    int REQUEST_ADD_FRIEND = 30306; // 发起好友申请  返回
    int DEL_FRIEND = 30312; // 删除好友 返回

    int AGREE_ADD_FRIEND = 30308; // 同意 返回
    int REFUSE_ADD_FRIEND = 30310; // 不同意 返回

    int AGREE_ALL_ADD_FRIEND = 30320; //  好友申请全部同意
    int REFUSE_ALL_ADD_FRIEND = 30342; //  好友申请全部拒绝

    int AGREE_APPLY_FRIEND_NTF = 30318; //  通知添加好友被同意了


    int GET_TARGET_PLAYER_DATA = 30261; //  获取目标角色的个人信息 返回
    int GET_PLAYER_TEAM_ID = 30315; //  获取目标角色的队伍信息

    //  个人副本
    int PERSONAL_EVENT_LIST_NTF = 10524; //  个人副本组件信息
    int UPDATE_PERSONAL_EVENT_LIST = 10525; // 个人副本组件信息更新
    int PERSONAL_CHALLENGE = 10521; //  个人副本挑战返回

    //  个人组件
    int CS_GET_ASSEMBLY_LIST_NTF = 11127; //  个人组件信息推送
    int PERSONAL_COMP_LIST = 10528; //  个人组件信息请求
    int UPDATE_PERSONAL_COMP = 10529; //  个人组件信息更新
    int FINISH_PERSONAL_COMP = 10531; //  完成个人组件请求
    int DAILY_USE_NTF = 10817; // 个人组件每日使用信息
    int DAILY_USE_CHANGE_NTF = 10818; // 个人组件使用次数变化
    int GAIN_ASSEMBLY_NTF = 10823; // 组件新增通知
    int GAIN_ASSEMBLY_DATA_NTF = 10849; //  所有获得的组件集合
    int UPDATE_ITEM_ASSEMBLY_LIST_NTF = 11114; //   道具资源点信息更新

    int GET_TYPE_ASSEMBLY_LIST = 11430; //  个人类型组件信息返回(按照类型返回一张地图的未完成的组件)

    int FINISHED_ASSEMBLY_LIST_INIT_NTF = 10534; //  个人组件已完成ID推送

    int UNION_BOX_ASSEMBLY_INIT_NTF = 11461; //  已完成的联合组件id初始推送
    int UNION_BOX_ASSEMBLY_UPDATE_NTF = 11462; //  新完成的联合组件id更新推送

    int RELATED_POS_ASSEMBLY_INIT_NTF = 11463; //  推送根据其他组件的坐标生成的组件
    int RELATED_POS_ASSEMBLY_UPDATE_NTF = 11464; //  增量推送根据其他组件的坐标生成的组件

    int CREATE_PDUPLICATE = 10729; // 创建个人副本

    //  个人组件扫荡
    int PERSON_COMP_SWEEP_NTF = 11233; // 扫荡组件推送
    int PERSON_COMP_SWEEP = 11232; // 个人组件扫荡请求
    int PERSON_COMP_SWEEP_BUY_NUM = 11235; // 个人组件购买扫荡次数

    //  传送阵
    int TRANSFER = 10533; //  请求传送返回
    int TRANSFER_ACTIVATE = 10558; //  请求激活传送阵返回

    // 组队
    int TEAM_LIST = 30202; // 队伍列表
    int TEAM_MYTEAM_INFO = 30204; //  自己队伍信息
    int TEAM_APPLY_JOIN_LIST = 30206; // 申请列表
    int TEAM_JOIN = 30208; // 申请加入
    int TEAM_LEAVE = 30210; // 申请离开
    int TEAM_TRANSFER = 30212; // 转让房主
    int TEAM_KICK = 30214; // 踢出玩家
    int TEAM_SET_INFO = 30216; // 设置信息
    int TEAM_AGREE_JOIN = 30218; // 同意申请
    int TEAM_REFUSE_JOIN = 30220; // 拒绝申请
    int TEAM_CREAT = 30222; // 创建队伍
    int TEAM_KICK_MEMBER_OUT = 30223; // 被踢出队伍的notice
    int TEAM_APPLY_JOIN_NTF = 30224; // 申请队伍的notice
    int TEAM_INVITE = 30226; //  邀请加入 返回
    int TEAM_DEAL_INVITE = 30228; //  处理邀请 返回
    int TEAM_INVITE_NTF = 30229; //  邀请加入notice
    int TEAM_DEAL_INVITE_NTF = 30230; //  处理邀请notice
    int GET_INVITE_PLAYER_INFO = 30349; //  获取被邀请人的信息
    int BUSY_STATUS_SETTING = 10523; //  处理设置队友状态忙
    int TEAM_MATE_POWER = 30232; //  队伍成员战力返回

    // 精力
    int ENERGY_GET = 10475;

    // 门派任务
    int GUILD_TASK_LIST = 10411; // 获取公会任务列表
    int UPDATE_GUILD_TASK_LIST = 10412; // 更新公会任务列表
    int DO_CAMP_TASK = 10420; //  势力任务

    // 炼体
    int BODY_REFINE = 10480; // 炼体
    int SYNTHESIS = 10482; // 炼体合成

    //  引导
    int NOVICE_GUIDE_RECORD_NTF = 10562; // 玩家新手引导记录
    int NOVICE_GUIDE_RECORD = 10561; // 玩家新手引导记录返回

    // 逆天改命
    int ADD_DESTINY_ATTR = 10506; // 增加先天气运返回
    int RESET_DESTINY = 10508; // 开始重置先天气运返回
    int CHANGE_DESTINY = 10510; // 重置先天气运后，更改先天气运返回

    int EXP_ADD_BEGIN = 10564;

    //  势力挑战
    int LIBRARY_CHALLENGE_RESULT_NTF = 10569;
    int LIBRARY_CHALLENGE = 10568;
    int LEAVE_LIBRARY_CHALLENGE = 10571;

    // 势力每日任务
    int CAMP_DAILY_TASK_NTF = 11431; // 势力每日任务推送
    int CAMP_DAILY_TASK_UPDATE_NTF = 11432; // 势力每日任务更新推送
    int CAMP_DAILY_TASK_ACCEPT = 11434; // 势力每日任务领取
    int CAMP_DAILY_TASK_FINISH = 11436; // 势力每日任务完成
    int CAMP_DAILY_TASK_GIVE_UP = 11438; // 势力每日任务放弃
    int CAMP_DAILY_TASK_SUBMIT = 11440; // 势力每日任务提交道具
    int CAMP_DAILY_TASK_REFRESH = 11442; // 势力每日任务刷新
    int CAMP_DAILY_TASK_TRACK = 11444; // 势力每日任务追踪

    //  神农录
    int DRUG_ITEM_USE_INFO_NTF = 10574;

    //  挂机副本
    int HANDUP_CHALLENGE = 30250;
    int HAND_UP_DUPLICATE_GIVE_UP = 11468;
    int HANDUP_REWARD_NTF = 11072;
    int HAND_UP_DUPLICATE_INFO_INIT_NTF = 11500;
    int HAND_UP_DUPLICATE_INFO_UPDATE_NTF = 11501;
    int HAND_UP_REWARD_INFO_INIT_NTF = 11502;
    int HAND_UP_REWARD_INFO_UPDATE_NTF = 11503;
    int HAND_UP_RECEIVE_REWARD = 11505;

    //  刹影幻藏 须臾幻境抽奖
    int HAND_UP_LOTTERY = 11552; //  刹影幻藏 抽奖resp
    int HAND_UP_LOTTERY_REWARD = 11554; //  刹影幻藏 抽奖 挑战奖励领取resp
    int HAND_UP_LOTTERY_RECORD_LIST = 30402; //  刹影幻藏抽奖探险记录获取返回
    int HAND_UP_LOTTERY_RECV_ID_NTF = 11555; //  刹影幻藏 抽奖 挑战奖励已领取id推送
    int HAND_UP_LOTTERY_NEW_RECORD_NTF = 11556; //  刹影幻藏 抽奖 新抽奖记录广播推送
    int HAND_UP_LOTTERY_GUARANTEE_NTF = 11557; //  刹影幻藏 抽奖 保底次数推送

    // 仙遗探宝抽奖
    int ANCIENT_LOTTERY = 11367;
    int ANCIENT_LOTTERY_RECORD_LIST = 30397;
    int ANCIENT_LOTTERY_NEW_RECORD_NTF = 11368;
    int ANCIENT_LOTTERY_SHOW_RESULT_NTF = 11369;
    int ANCIENT_LOTTERY_GUARANTEE_NTF = 11370;
    int ANCIENT_LOTTERY_WISH = 11523;


    //  npc
    int NPC_ACTIVE = 10640; //  npc激活 resp
    int NPC_BUILD_RELATION = 10619; //  npc结缘 resp
    int NPC_GO_INTO_BATTLE = 10642; // npc上下阵 resp
    int NPC_BREAKTHROUGH = 10644; //  npc突破 resp
    int NPC_INFO_NTF = 10645; //  初始化npc信息ntf
    int NPC_UPDATE_NTF = 10770; //  npc更新信息ntf
    int NPC_ADD_NTF = 10646; //  npc生成通知
    int NPC_REMOVE_NTF = 10647; // npc消失通知
    int GAIN_NPC_INDEX_LIST_NTF = 10797; //  上线服务器会通过这条协议推见过哪些道友下来
    int GAIN_NPC_INDEX_ADD_NTF = 10798; //  上线后服务器会通过这条协议推见过哪些道友下来
    int NPC_LOSE_LIKE_INIT_NTF = 10799; //  失去好感度
    int NPC_LOSE_LIKE_UPDATE_NTF = 10800; //  失去好感度npcNtf
    int NPC_ASK_FOR_GIFT = 10651; // npc 索要 resp
    int DUPLICATE_GIVE_UP = 10756; //  战斗认输返回
    int NPC_CHAT = 10772; //  npc交谈

    int NPC_CONSULT = 10777; // NPC请教
    int NPC_SETTING_AFFIX = 10788; // npc请教词条设置
    int NPC_SETTING_AFFIX_NTF = 10790; // npc请教词条设置NTF

    //  npc重修
    int NPC_REBORN = 10769; //  npc重修返回

    //  npc物品
    int ITEM_INTO_NPC_STORAGE = 10652; // 物品进入npc包裹
    int ITEM_OUTOF_NPC_STORAGE = 10653; // 物品离开npc包裹
    int NPC_ITEM_PROPERTY_CHANGE = 10654; // npc物品属性改变

    //  npc赠礼
    int NPC_SEND_REWARD = 10612;

    //  npc切磋
    int NPC_CHALLENGE = 10656; //  npc切磋副本
    int NPC_CHALLENGE_RESULT_NTF = 10657; //  切磋结果
    int LEAVE_NPC_CHALLENGE = 10659; //  离开切磋副本

    //  npc寻仇
    int NPC_REVENGE_CHOICE = 10753; //  npc寻仇操作
    int NPC_REVENGE_NTF = 10751; //
    int NPC_REVENGE_RESULT_NTF = 10754; //  寻仇副本结果
    int NPC_LEAVE_REVENGE_CHALLENGE = 10700; // 离开npc寻仇战斗resp

    //  npc偷窃
    int NPC_STEAL_INFO_NTF = 10692; //  npc偷窃信息ntf
    int NPC_STEAL = 10685; //  npc偷窃返回
    int NPC_STEAL_CHALLENGE = 10687; //  npc偷窃战斗返回
    int NPC_LEAVE_STEAL_CHALLENGE = 10696; //  离开npc偷窃战斗返回
    int NPC_STEAL_CHALLENGE_RESULT_NTF = 10697; //  偷窃副本结果

    //  npc求饶
    int NPC_PARDON_INFO = 10693; //  求饶信息ntf
    int NPC_ASK_FOR_PARDON_NPC = 10689; //  人物求饶npc返回
    int NPC_ASK_FOR_PARDON = 10691; //  npc求饶返回

    //  npc偷袭
    int NPC_SNEAK_ATTACK = 10758; //  偷袭npc req
    int NPC_LEAVE_SNEAK_ATTACK = 10760; //  离开偷袭npc副本
    int NPC_SNEAK_ATTACK_RESULT = 10761; //  偷袭副本结果

    //  npc比武
    int NPC_COMBAT = 10779; //  npc比武请求
    int NPC_SWEEP = 10781; //  npc扫荡
    int BUY_NPC_SWEEP_TIMES = 10783; //  购买npc扫荡次数
    int NPC_COMBAT_LEAVE = 10785; // 离开npc比武副本
    int NPC_COMBAT_RESULT = 10786; // npc比武结果

    //  npc修炼
    int NPC_EXP_IMPROVE = 10763;

    //  npc升品
    int NPC_UP_PERIOD = 10767;

    //  npc法宝升星
    int NPC_WEAPON_UP_STAR = 10765; // npc法宝升星req

    //  npc专属法宝
    int NPC_EXCLUSIVE_WEAPON_WEAR = 11401; // npc专属法宝穿戴返回
    int NPC_EXCLUSIVE_WEAPON_UNWEAR = 11403; // npc专属法宝卸下返回
    int NPC_EXCLUSIVE_WEAPON_LVUP = 11405; // npc专属法宝升级返回

    //  npc心法
    int NPC_HEART_UPGRADE = 10487; // npc心法升级返回
    int NPC_HEART_REALIZE = 10489; // npc心法参悟返回
    int NPC_HEART_REALIZE_SAVE = 10491; // npc心法参悟保存返回
    int NPC_HEART_REALIZE_GIVEUP = 10498; // npc心法参悟放弃返回

    //  npc炼体
    int NPC_EQUIP_EQUIPMENT = 10792; // npc穿上炼体装备 value表示npc的ObjId
    int NPC_BODY_REFINE = 10794; //  npc炼体 value表示npc的ObjId

    //  npc双修
    int NPC_CULTIVATE = 11126; // npc双修请求返回

    //  邮件
//  int GET_MAIL_LIST = enum("CS_GET_MAIL_LIST_NTF")   //  邮件列表
    int GET_NEW_MAIL_NTF = 10579; //  邮件红点信息
    int GET_MAIL_LIST = 10581; //  获取邮件列表
    int UPDATE_MAIL_LIST = 10582; //  邮件更新列表
    int READ_MAIL = 10584; //  读邮件返回
    int READ_MAIL_BATCH = 10586; //  一键读取邮件返回
    int RECEIVE_ATTACHMENT = 10588; //  领取附件返回
    int RECEIVE_ATTACHMENT_BATCH = 10590; //  一键领取附件返回
    int DELETE_MAIL = 10592; //  删除邮件返回
    int DELETE_MAIL_BATCH = 10594; //  一键删除邮件返回

    int ITEM_CHANGE = 10546;

    int SYS_SETING = 10596;
    int BATTLE_DROP_SETTING = 11039;
    int BATTLE_DROP_SETTING_NTF = 11040;

    int CLIENT_DATA_CHANGE_NTF = 10599; //  记录客户端自己需要的数据
    int RECORD_CLIENT_DATA = 10598; //  记录客户端自己需要的数据
    int GET_RECORD_CLIENT_DATA = 10606; //  获取客户端对应的数据

    int ASSEMBLE_CHALLENGE_RESULT_NTF = 10604; //  个人组件挑战ntf
    int LEAVE_CHALLENGE_CHALLENGE = 10608; // 挑战副本 req

    int USE_DRUG_PUBLIC_CD_NTF = 10575; //  使用药水公共CD通知

    //  灵宠
    int SPIRIT_PET_INFO_NTF = 10633; //  初始化灵宠信息ntf
    int SPIRIT_PET_UPDATE_NTF = 10725; //  灵宠update信息
    int SPIRIT_PET_ADD_NTF = 10634; //  灵宠生成ntf
    int SPIRIT_PET_REMOVE_NTF = 10635; //  灵宠消失ntf
    int SPIRIT_PET_GO_INTO_BATTLE = 10624; //  灵宠上阵返回
    int SPIRIT_PET_CHANGE_NAME = 10626; //  灵宠改名返回
    int SPIRIT_PET_IMPROVE_CULTIVATION = 10628; //  灵宠提升修为返回
    int SPIRIT_PET_BREAKTHROUGH = 10630; //  灵宠突破返回
    int SPIRIT_PET_RELEASE = 10632; //  灵宠放生返回
    int PET_REBORN = 10721; // 灵宠重生返回
    int PET_USE_ITEM_ADD_NTF = 10724; //  使用道具灵宠生成通知

    //  灵宠血脉
    int SPIRIT_PET_BLOOD_INFO = 10666; //  灵宠血脉信息ntf
    int SPIRIT_PET_BLOOD_RANDOM_BLOOD = 10661; //  灵宠随机血脉属性返回
    int SPIRIT_PET_BLOOD_REPLACE_BLOOD = 10663; //  灵宠替换血脉属性返回
    int SPIRIT_PET_BLOOD_GIVE_UP = 10665; //  灵宠放弃血脉属性返回

    //  灵宠喂食
    int SPIRIT_PET_GIVE_FOOD = 10719; //  灵宠喂食resp

    int PET_LEARN_SKILL = 10668;
    int PET_SKILL_POS = 10670;
    int PET_SKILL_DEL = 10707;

    //  灵宠图鉴
    int PETBOOK = 10715; //  激活灵宠返回
    int PETBOOK_OUT = 10717; //  取出灵宠返回

    //  灵宠捕捉
    int PET_SEARCH_STATUS = 10709; //  灵宠搜寻状态
    int PET_SEARCH = 10554; //  灵宠搜寻返回
    int PET_CATCH = 10556; //  灵宠捕捉返回
    int PET_CATCH_GIVE_UP = 10638; //  灵宠捕捉放弃
    int PET_COLLECT_NTF = 10636; //  灵宠收集信息
    int PET_CATCH_FINISH = 10711; //  灵宠捕捉结束

    int PET_SEARCH_NTF = 10722; //  pet搜寻ntf
    int PET_CATCH_NTF = 10723; //  pet抓捕ntf

    //  灵宠自动捕捉
    int PET_AUTO_CATCH_SET = 10727; // 灵宠自动捕捉设置返回

    //  灵宠升品
    int PET_CRUDE = 10713; //  升品请求返回

    //  天赋
    int INNAT_UP_LV = 10601; //  天赋升级返回
    int INNAT_RESET = 10615; //  天赋重置返回
    int INNAT_START_NTF = 10850; //  天赋触发推送

    //  活动大厅
    int ATV_DAILY_INIT_BOX_LIST = 10677; //  活动大厅奖励上线推送
    int ATV_DAILY_DRAW_BOX = 10679; //  活动大厅领奖结果
    int ATV_DAILY_METHOD_LIST = 10680; //
    int ATV_DAILY_METHOD_CHANGE = 10681; //  活动次数

    //  活跃(每日任务)
    int ACTIVITY_TASK_COUNT_NTF = 11428; // 每日任务初始化通知
    int ATV_DAILY_TASK_CHANGE = 10801; // 每日任务信息更新通知
    int RECEIVE_ALL_ACTIVITY_POINT = 11427; //  一键领取所有未领取的活跃度返回，通用返回

    //  运营活动
    int GET_ACTIVITY_INFO_NTF = 10901; //  运营活动信息
    int UPDATE_ACTIVITY_INFO_NTF = 10902; //  运营活动信息

    //  论剑
    int BATTLE_ENTER = 11007; //  进入战斗(跨服协议)
    int BATTLE_EXIT = 11009; //  退出战斗(跨服协议)

    int GET_MST_BATTLE_INFO_NTF = 10903; //  竞技场活动表信息
    int GET_BATTLE_INFO = 30138; //  获取竞技场主界面返回
    int BATTLE_RECEIVED_TASK_ID_LIST_NTF = 11015; //  已领取竞技场任务奖励id列表
    int BATTLE_RECEIVE_TASK_REWARD = 11017; //  领取竞技场任务奖励返回
    int BATTLE_GET_RANK_LIST = 30140; //  竞技场排行榜返回
    int BATTLE_GET_LOG_LIST = 11014; //  战报返回
    int BATTLE_MATCH_NTF = 11003; //  匹配通知
    int BATTLE_MATCH = 11002; //  匹配返回
    int BATTLE_CANCEL_MATCH = 11005; //  取消匹配返回
    int BATTLE_RESULT_NTF = 11010; //  战斗结果(跨服协议)、本服对方认输也返回这个消息

    int BATTLE_BUY_COUNT = 11012; //  购买论道次数返回

    //  寄售行
    int GET_TRADE_FOCUS_ORDER_LIST = 10832; //  获取交易行关注物品返回
    int TRADE_ORDER_FOCUS = 30336; //  关注物品返回
    int TRADE_ORDER_CANCEL_FOCUS = 10834; //  取消关注物品返回
    int TRADE_ORDER_SELL = 10836; //  出售物品返回
    int TRADE_ORDER_AUCTION = 10838; //  竞价返回
    int GET_TRADE_SUMMARY_ORDER_LIST = 30322; //  获取交易行一级页物品返回
    int GET_TRADE_ORDER_LIST = 30324; //  获取交易行二级页物品返回
    int GET_TRADE_SELL_ORDER_LIST = 30326; //  获取交易行出售物品返回
    int GET_TRADE_SUMMARY_PUBLIC_ORDER_LIST = 30328; //  获取交易行公示一级页物品返回
    int GET_TRADE_PUBLIC_ORDER_LIST = 30330; //  获取交易行公示二级页物品返回
    int TRADE_ORDER_BUY = 30332; //  购买物品返回
    int TRADE_ORDER_TAKE_OFF = 30334; //  下架物品返回
    int TRADE_ORDER_PUT_ON = 10842; //  重新上架物品返回
    int GET_TRADE_FOCUS_ID_LIST = 10840; //  获取交易行关注订单号返回
    int TRADE_ORDER_BIDDING = 30338; //  获取订单价格信息返回

    //  神兽秘境
    int ENTER_PET_SECRET = 11032; // 进入神兽秘境活动返回
    int LEAVE_PET_SECRET = 11034; // 离开神兽秘境活动返回
    int GET_MST_PET_SECRET_CONFIG_NTF = 10906; // 活动配置表

    //  兑换码
    int ATV_GIFT_CODE = 10289; // 使用兑换码返回

    // 镇妖塔
    int TOWER_MONSTER_NUM = 10804; //  活动大厅奖励上线推送
    int TOWER_CHALLENGE = 10803; // 爬塔副本挑战返回
    int TOWER_RESULT = 10805; // 爬塔战斗结束挑战返回
    int TOWER_REWARD = 10807; // 爬塔奖励
    int TOWER_SWEEP = 10809; // 爬塔扫荡
    int TOWER_SWEEP_BUY_TIMES = 10813; //  爬塔扫荡购买次数返回
    // 镇妖塔挂机
    int TOWER_HANGUP_GET_DISPLAY_REWARD = 11472; // 查询要展示的奖励
    int TOWER_HANGUP_RECEIVE_REWARD = 11474; // 请求领取奖励
    int TOWER_HANGUP_BUY_COUNT = 11476; // 请求购买次数

    //  声音
    int OBJ_SOUND_NTF = 11295; //  怪物音效ntf

    //  签到
    int SIGN_IN = 10815; // 签到请求返回
    int SIGN_IN_NTF = 10816; // 签到数据返回
    //  战斗设置
    int BATTLE_SETING = 10821; // 战斗设置返回
    int MAGIC_WEAPON_PLAN_NTF = 10847; // 法宝方案ntf
    int MAGIC_WEAPON_PLAN_CHANGE_NTF = 10848; // 法宝方案改变ntf

    //  切换线路
    int GET_SERVER_NUM = 30254; // 获取线路
    int SWITCH_SERVER = 30256; // 切换线路
    int SERVER_NUM_NTF = 30257; //

    //  神农录
    int USE_DRUG_ITEM = 10610; // 使用神农录道具 返回

    int COMPOSE = 10235; // 合成心法

    //  梦入仙途
    int GOD_AREA_ACTIVITY_MOVE = 10852; //  梦入仙途活动移动
    int GOD_AREA_MOVED_GRID_LIST = 10853; //  梦入仙途活动已经移动的格子id集合
    int GOD_AREA_LEAVE_CHALLENGE = 10855; //  梦入仙途活动离开副本resp
    int GOD_AREA_CHALLENGE_RESULT = 10856; //  梦入仙途活动挑战结果
    int GET_MST_GOD_AREA_INFO_NTF = 10904; //  梦入仙途活动表信息
    int GOD_AREA_PAY_DATA_NTF = 11307; // 梦入仙途战购买礼包信息
    int GOD_AREA_PAY_DATA_UPDATE_NTF = 11308; // 梦入仙途战购买礼包更新信息
    int GOD_AREA_GET_REWARD = 11310;
    int GOD_AREA_BATTLE_ORDER_RECEIVE = 10861;
    int GOD_AREA_BATTLE_ORDER_NTF = 10862;
    //  梦入仙途 签到
    int GOD_AREA_SIGN_IN = 10858;
    int GOD_AREA_SIGN_IN_NTF = 10859;

    //  梦入仙途 抽奖
    int GOD_AREA_LOTTERY_RECEIVED_IDS_NTF = 11305; // 抽奖任务已领取奖励的任务id推送
    int GOD_AREA_LOTTERY_NEW_RECORD_NTF = 11306; // 新的抽到稀有道具抽奖记录推送
    int GOD_AREA_LOTTERY = 11302; // 梦入仙途抽奖返回
    int GOD_AREA_LOTTERY_REWARD = 11304; // 抽奖任务领取奖励返回
    int GOD_AREA_LOTTERY_RECORD = 30391; // 抽奖记录请求返回

    // 诛魔却邪
    int REPEL_EVIL_GET_MY_INFO = 30406; // 诛魔却邪活动获取我的信息resp
    int REPEL_EVIL_CHALLENGE = 30404; // 诛魔却邪活动挑战resp
    int REPEL_EVIL_GET_RANK = 30351; // 诛魔却邪活动获取排行榜resp
    int MONSTER_ENHANCE_NTF = 10868; // 怪物属性增强通知

    //  int REPEL_EVIL_INFO_NTF = enum("CS_REPEL_EVIL_INFO_NTF") // 诛魔却邪活动信息ntf
    int GET_MST_REPEL_EVIL_INFO_NTF = 10905; // 诛魔却邪活动表信息
    int NPC_USE_ITEM_ADD_NTF = 10613; // 伙伴券获得npc

    int SERVER_EFFECT_NTF = 11035; //  效果触发(由服务器通知客户端触发了某些效果)

    //  天气
    int SYS_WEATHER_DATA_NTF = 10493; // 各个地图各个时间段的天气信息
    int PLAYER_WEATHER_DATA_NTF = 10495; // 玩家使用道具生成的天气信息
    int PLAYER_WEATHER_DATA_CHANGE_NTF = 10496; // 玩家使用道具信息更新
    int WEATHER_ITEM_USE = 10811; // 使用天气道具返回
    int GET_WEATHER_CHANGE_RECORD = 30340; // 获取天气改变记录返回


    //  跑马灯
    int SYSTEM_NOTICE_NTF = 10033; // 后台跑马灯推送

    // 奇遇
    int MEET_CHOOSE_BUTTON = 11042; // 选择奇遇按钮
    int MEET_CREATE = 11044; // 创建奇遇
    int PUBLIC_MEET_DATA_NTF = 11045; // 公共奇遇ntf
    int PUBLIC_MEET_DATA_UPDATE_NTF = 11046; // 公共奇遇更改ntf
    int MEET_DATA_NTF = 11047; // 奇遇ntf
    int MEET_DATA_UPDATE_NTF = 11048; // 奇遇更改ntf
    int MEET_RECEIVE_REWARD = 11050; // 领取奇遇奖励
    int MEET_DAILY_COUNT_NTF = 11051; // 奇遇每日的使用次数
    int MEET_ALL_COUNT_NTF = 11052; // 奇遇终身的使用次数
    int NPC_CHAT_COUNT_NTF = 10773; // npc交谈次数
    int PUBLIC_MEET_CHOOSE_BUTTON = 11057; // 选择公共奇遇按钮
    int MEET_CHALLENGE = 11054; // 选择公共奇遇按钮
    int MEET_DUPLICATE_ID_NTF = 11055; // 选择公共奇遇按钮

    //  道具兑换
    int ITEM_EXCHANGE = 10775; //  道具兑换resp

    //  地图收藏点位
    int MAP_COLLECT_ADD = 11062; // 增加点位返回
    int MAP_COLLECT_DELETE = 11065; // 删除点位返回
    int MAP_COLLECT_NTF = 11063; // 点位推送

    int BATTLE_PLAN_SAVE = 11082; //  保存战斗方案返回 通用返回
    int BATTLE_PLAN_UPDATE_NAME = 11084; //  修改方案名称返回 通用返回
    int BATTLE_PLAN_GET_LIST = 11086; //  获取战斗方案列表返回
    int BATTLE_PLAN_UPDATE_PRESET = 11088; //  预设战斗方案返回
    int BATTLE_PLAN_SWITCH = 11121; //  切换当前方案和预设方案

    int RIDE_CHANGE_STATUS = 11091; //  骑乘坐骑
    int RIDE_ADD_EXP = 11093; //  坐骑增加经验
    int RIDE_LEVEL_UP = 11095; //  坐骑升级
    int RIDE_STAR_UP = 11097; //  坐骑升星

    //  坐骑图鉴
    int BOOK_GET_EXP = 11422; // 请求领取坐骑图鉴经验返回

    int SWITCH_TERRAIN_STATE = 11112; //  切换地形resp
    int SWITCH_TERRAIN_STATE_NTF = 11113; //  切换地形广播

    int RIDE_INFO_NTF = 11098; //  坐骑信息ntf
    int RIDE_ADD_NTF = 11099; //  坐骑生成通知
    int RIDE_REMOVE_NTF = 11100; //  坐骑消失通知
    int RIDE_UPDATE_NTF = 11101; //  坐骑变化通知

    // 斩妖录
    int MONSTER_SLAIN_GET_REWARD = 11116; // 领取斩妖录奖励返回

    //  洞府
    int CAVE_UPGRADE = 11182; //  升级洞府
    int CAVE_BUILDING_RECEIVE = 11184; //  领取洞府建筑生产的物资
    int CAVE_PET_WORKING = 11187; //  灵宠派遣
    int CAVE_BUILDING_CHANGE_NTF = 11185; //  洞府建筑生产物资变化通知

    //  洞府合成
    int CAVE_COMPOSE = 11191; // 洞府合成请求

    //  迷雾
    int FOG_UNLOCK_DATA_NTF = 11293; //  迷雾解锁ntf
    int FOG_UNLOCK_DATA_ADD_NTF = 11294; //  迷雾解锁增加ntf

    // 升仙录
    int CHAPTER_FINISH_LIST_NTF = 11150; // 玩家完成的所有章节id列表推送
    int CHAPTER_DATA_NTF = 11141; // 当前章节信息推送
    int CHAPTER_UPDATE_TASK_NTF = 11142; // 当前章节任务信息变化推送
    int CHAPTER_RECEIVE_TASK_REWARD = 11144; // 领取章节任务奖励返回，通用返回
    int CHAPTER_FINISH_REWARD = 11146; // 领取章节任务奖励返回，通用返回
    int CHAPTER_LUCKY_RAFFLE = 11149; // 领取章节任务奖励返回，通用返回

    int CHAPTER_LUCKY_RECEIVED_IDS_NTF = 11147; // 章节机缘抽奖-奖池中已抽取奖励id信息推送

    int PET_ITEM_INTO_PACKAGE_NTF = 11214; // 灵宠物品到包裹
    int PET_TAKE_BACK_ITEM_NTF = 11215; // 灵宠物品离开包裹
    int PET_ITEM_PROPERTY_CHANGE_NTF = 11216; // 灵宠物品属性改变

    int SELF_WEAPON_EQUIP = 11211; // 本命装备穿戴返回
    int SELF_WEAPON_UN_EQUIP = 11213; // 本命装备卸下返回

    //  本服竞技场(仙门大比)
    int LOCAL_BATTLE_ENTER = 30147; //  进入战斗
    int LOCAL_BATTLE_EXIT = 11259; //  退出战斗

    int LOCAL_BATTLE_INFO = 30143; //  获取竞技场主界面返回
    int LOCAL_BATTLE_TASK_ID_LIST_NTF = 11265; //  已领取竞技场任务奖励id列表
    int LOCAL_BATTLE_TASK_REWARD = 11267; //  领取竞技场任务奖励返回
    int LOCAL_BATTLE_GET_RANK_LIST = 30145; //  竞技场排行榜返回
    int LOCAL_BATTLE_GET_LOG_LIST = 11264; //  战报返回
    int LOCAL_BATTLE_MATCH_NTF = 11253; //  匹配通知
    int LOCAL_BATTLE_MATCH = 11252; //  匹配返回
    int LOCAL_BATTLE_CANCEL_MATCH = 11255; //  取消匹配返回
    int LOCAL_BATTLE_RESULT_NTF = 11260; //  本服对方认输返回这个消息
    int LOCAL_BATTLE_INFO_NTF = 11269; //  竞技场主界面Ntf(只有重新登陆才会发)


    int LOCAL_BATTLE_BUY_COUNT = 11262; //  购买论道次数返回
    // 本命法宝-升星
    int SELF_WEAPON_UP_STAR = 11204;

    // 本命法宝-激活
    int SELF_WEAPON_ACTIVATE = 11202;

    //  谁与争锋(活动排行)
    int RANK_ACTIVITY_GET_RANK_LIST = 30377; //  排行活动获取排行榜数据返回
    int RANK_ACTIVITY_RECEIVE_REWARD = 11352; //  排行活动领取阶段奖励请求返回
    int RANK_ACTIVITY_SCORE_CHANGE_NTF = 11353; //  排行活动分数变化通知(仅通知客户端无法得到分数的排行榜)
    int RANK_ACTIVITY_REWARD_INFO_NTF = 11354; //  排行榜阶段奖励领取信息通知
    int RANK_ACTIVITY_INFO_NTF = 11355; //  排行榜活动信息推送
    int RANK_ACTIVITY_REWARD_INFO_CHANGE_NTF = 11356; //  排行活动阶段奖励领取状态变化推送
    int RANK_ACTIVITY_GET_TOP_RANK = 30379; //  排行活动获取所有排行榜的第一名数据返回

    // 新服目标
    int NEW_SERVER_TASK_INFO_NTF = 12141;
    int NEW_SERVER_TASK_UPDATE_NTF = 12142;
    int NEW_SERVER_RECEIVED_ID_NTF = 12147;
    int NEW_SERVER_GOAL_GET_SCORE_REWARD = 12146;
    int NEW_SERVER_GOAL_GET_TASK_REWARD = 12144;

    int MAGIC_FIRE_ACTIVATE = 11332;
    int MAGIC_FIRE_UPGRADE = 11334;

    int MAGIC_FIRE_LOTTERY = 11337; // 异火抽奖池手动刷新请求，null
    int MAGIC_FIRE_LOTTERY_REFRESH = 11339; // 异火抽奖池手动刷新响应，通用返回
    int MAGIC_FIRE_LOTTERY_ITEM_NTF = 11335; // 异火抽奖奖池推送

    // 异火融合
    int MAGIC_FIRE_EQUIP = 11341;
    int MAGIC_FIRE_UN_EQUIP = 11343;
    int MAGIC_FIRE_EQUIP_SKILL = 11345;
    int MAGIC_FIRE_ONE_KEY_EQUIP = 11347;

    int BOX_LOTTERY = 11363; // 地图异火抽奖池抽奖，null
    int BOX_LOTTERY_NTF = 11361; // 地图异火抽奖奖池推送
    int BOX_LOTTERY_GIVE_UP = 11365; // 地图异火抽奖奖池推送

    //  时装
    int FASHION_ACTIVATE = 11322;
    int FASHION_WEAR = 11324;
    int FASHION_LIST_UPDATE_NTF = 11325;
    int FASHION_LIST_NTF = 11327;

    // 称号
    int NEW_SERVER_GOAL_TABLE_NTF = 10908;
    int HERO_TITLE_NTF = 11311;
    int HERO_TITLE_UPDATE_NTF = 11312;
    int HERO_TITLE_ACTIVATE = 11314;
    int HERO_TITLE_WEAR = 11316;

    // 物品合成
    int ITEM_MERGE = 10212;

    // 充值礼包

    int RECHARGE_GIFT_ACT_RECORD_NTF = 11396;
    int RECHARGE_GIFT_ACT_RECEIVE = 11398;
    int GET_RECHARGE_GIFT_ACT_INFO_NTF = 11399;

    // 充值礼包(新)
    int NEW_RECHARGE_GIFT_ACT_RECORD_NTF = 11601;
    int NEW_RECHARGE_GIFT_ACT_RECEIVE = 11603;
    int NEW_GET_RECHARGE_GIFT_ACT_INFO_NTF = 11604;


    // GM
    int GM_COMMAND = 10143;

    // 周常活动
    int GET_MST_WEEKLY_ACTIVITY_INFO = 10907;

    // 材料副本
    int SWEEP_MATERIAL_DUPLICATE = 11452;
    int MATERIAL_DUPLICATE_BUY_TIMES = 11454;
    int MATERIAL_DUPLICATE_INIT_NTF = 11455;
    int MATERIAL_DUPLICATE_UPDATE_NTF = 11456;
    int CHALLENGE_MATERIAL_DUPLICATE = 30399;

    int SWITCH_BATTLE_NPC = 10796;

    //  免费礼遇(企业微信跳转)
    int FREE_GIFT_GET_BINDING_CODE = 11484;
    int GET_MST_FREE_GIFT_REWARD_INFO_NTF = 10911;

    //  限时礼包
    int GET_MST_LIMIT_TIME_GFIT_INFO_NTF = 10912; //  限时礼包活动表信息
    int LIMIT_TIME_GIFT_NTF = 11412; //  限时礼包玩家数据推送
    int LIMIT_TIME_GIFT_BUY = 11414; // 限时礼包使用游戏货币购买响应
    int LIMIT_TIME_GIFT_UPDATE_NTF = 11415; //  限时礼包玩家数据更新推送

    //  问卷调查
    int GET_MST_SURVEY_REWARD_INFO_NTF = 10909;
    int SURVEY_REWARD_FINISH_CODE_NTF = 11485;

    //  聚灵圣种(消耗返利)
    int GET_MST_SPEND_RESERVE_INFO_NTF = 10915; //  聚灵圣种活动表信息 CS_GetMstSpendReserveInfoNtf
    int SPEND_RESERVE_INIT_NTF = 11581; //  聚灵圣种累计消耗信息推送 CS_SpendReserveInitNtf
    int SPEND_RESERVE_UPDATE_NTF = 11582; //  聚灵圣种累计消耗信息变更推送 CS_SpendReserveUpdateNtf
    int UPGRADE_SPEND_RESERVE = 11584; //  升级聚灵圣种奖励请求 返回 通用返回 value为 活动id
    int RECEIVE_SPEND_RESERVE = 11586; //  领取聚灵圣种奖励请求 返回 通用返回 value为 活动id

    //  赛季(天道桎梏)
    int GET_MST_SEASON_INFO_NTF = 11571; //  推送赛季配置信息
    int SEASON_GET_RANK_LIST = 30408; //  获取赛季排行榜返回
    int SERVER_AVERAGE_LEVEL_CHANGE_NTF = 11591; // 服务器玩家平均等级推送

    //  taptap评价
    int GET_MST_COMMENT_REWARD_INFO_NTF = 10910;
    int COMMENT_REWARD_RECEIVE = 11482;

    // 客户端迷雾解锁
    int CLIENT_UNLOCK_FOG = 11491;

    // 预下载奖励领取
    int RECEIVE_RES_PACKAGE_REWARD = 11495;

    // 充值
    int CREATE_ORDER = 10021;

    // 服务器版本推送
    int SERVER_VERSION = 10019;

    // GM获取伤害统计
    int GM_DAMAGE_RECORD = 10145;

    // 功能开启
    int UNLOCK_CONTROL_INFO_NTF = 11521;

    int WORLD_BOSS_RECEIVE_REWARD = 11531;
    int WORLD_BOSS_PLAYER_STATUS_NTF = 11532;
    int WORLD_BOSS_PLAYER_REWARD_NTF = 11533;
    int DUPLICATE_MATCH = 30395;
    int DUPLICATE_CANCEL_MATCH = 30393;

    int SHOP_EXTRA_REWARD_INIT_NTF = 11564;
    int SHOP_EXTRA_REWARD_UPDATE_NTF = 11565;

    // 战令
    int MST_BATTLE_PASS_INFO_NTF = 11570;
    int BATTLE_PASS_INIT_NTF = 11560;
    int BATTLE_PASS_UPDATE_NTF = 11561;
    int BATTLE_PASS_RECEIVE_REWARD = 11563;

    // 脱离卡死
    int MAP_ESCAPE_STUCK = 11542;

    // 商城活动礼包
    int GET_MST_GIFT_PACK_INFO_NTF = 10913;
    int USE_USER_BAG = 11569;
    int GET_MST_GIFT_INFO_NTF = 10914;

    int RECEIVE_RECHARGE_REBATE = 11573;
    int RECHARGE_REBATE_RESULT_NTF = 11574;

    int WEEKLY_BOSS_CHALLENGE = 11593;

    int WEEKLY_BOSS_GET_MONSTER_DATA = 11595;
    int WEEKLY_BOSS_PASS_DUPLICATE_NTF = 11596;
    int WEEKLY_BOSS_GET_MONSTER_DATA_NTF = 11597;


    int SUGGEST_MAJOR_EQUIP = 11512;
    int SUGGEST_MAJOR_INNAT = 11514;

    int TEAM_RECRUIT_JOIN_TEAM = 30234; // 队伍招募

    int IOS_COMMENT_NTF = 11605; // IOS评论

    int RECHARGE_GET_REBATE_RESULT = 11576; // 获取返利信息

    int HEALTH_TIME_NTF = 10694;
}