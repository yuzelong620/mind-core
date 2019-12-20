/**
 * 
 */
package com.mind.core.util;

/**
 * 核心常量
 * @author ninglong 2014年11月29日 下午5:45:33
 */
public interface CoreConstants {
	
	/**redis中需要存储数据的list*/
	public final static String REDIS_DB_LIST_QUEUE = "REDIS_DB_LIST_QUEUE";
	/**redis中需要存储数据的set*/
	public final static String REDIS_DB_SET_QUEUE = "REDIS_DB_SET_QUEUE";
	
	/**
	 * 用来拆分具有<..><..><..>形式的字符串正则表达式
	 */
	public static final String GROUP_SPLITER = "(?<=>)(?=<)";
	
	/**
	 * 用来拆分具有v1|v2|v3形式的字符串表达式
	 */
	public static final String ELEMENT_SPLITER = ",";
	public static final char ELEMENT_SPLITER_CHAR  = ',';
	
	/**
	 * 系统消息--session
	 */
	public static final short SYS_SESSION = 2;
	/**
	 * 系统消息
	 */
	public static final short WORLD_JOB_SYS_INTERNAL = 3;
	/**
	 * 世界战斗消息
	 */
	public static final short WORLD_FIGHT_JOB_SYS_INTERNAL = 4;
	/**
	 * 世界地图玩家开始回程消息
	 */
	public static final short WORLD_START_BACKTOWN_JOB_SYS_INTERNAL = 5;
	/**
	 * 世界地图玩家回程到达消息
	 */
	public static final short WORLD_END_BACKTOWN_JOB_SYS_INTERNAL = 6;
	/**
	 * 世界地图玩家第一次被打
	 */
	public static final short WORLD_FIRST_BLOOD__SYS_INTERNAL = 7;
	/**
	 * 世界地图玩家资源更新
	 */
	public static final short WORLD_UPDATE_RESOURCE__SYS_INTERNAL = 8;
	/**
	 * 世界地图玩家战斗次数更新
	 */
	public static final short WORLD_UPDATE_FIGHTTIMES__SYS_INTERNAL = 9;
	
	/**
	 * 珍宝岛奖励
	 */
	public static final short WORLD_PEARLD_REWARD_SYS_INTERNAL = 10;
	/**
	 * 军事建筑更新
	 */
	public static final short WORLD_MILITARY_UPDATE_SYS_INTERNAL = 11;
	/**
	 * 系统内部转发邮件
	 */
	public static final short MAIL_SYS_INTERNAL = 12;
	/**
	 * 清除世界地图单个玩家信息
	 */
	public static final short WORLD_CLEAR_PLAYER_MAP_SYS_INTERNAL = 13;
	/**
	 * 玩家集结
	 */
	public static final short WORLD_MASS_SYS_INTERNAL = 14;
	/**
	 * 玩家区域竞技场战斗时间
	 */
	public static final short LOCAL_ARENA_FIGHTT_TIME_SYS_INTERNAL = 15;
	/**
	 * 王城战奖励
	 */
	public static final short CENTER_GIFT_REWARD_SYS_INTERNAL = 16;
	/**
	 * 王城战官职奖励清空
	 */
	public static final short CENTER_GIFT_OFFICE_GIFT_REMOVE = 17;
	/**
	 * 系统内部转发充值信息
	 */
	public static final short DELTA_SYS_INTERNAL = 18;
	/**
	 * 充值MD5key
	 */
	public static final String DELTA_KEY = "2016521";
	
	/**
	 * 连接状态
	 * @author ninglong
	 *
	 */
	public enum ConnectState{
		STATE_CONNECTED,STATE_LOGINED,STATE_DISCONNECTED;
	}
}
