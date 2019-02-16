package config;

/**
 * 爬虫配置
 * 
 * @author Administrator
 *
 */
public class Config {
	public static String MISSION_NAME = "东北大学->招生信息->硕士招生";
	public static String NOTICE_BOARD_URL = "http://www.graduate.neu.edu.cn/dongda/zsxx/index.jhtml";
	public static String XPATH = "//*[@id=\"messageList_1\"]/div[2]/div[1]/div[2]/ul/li[1]/a";
	public static String PREFIX = "http://www.graduate.neu.edu.cn";

	public static String LEANCLOUD_CLASS_NAME = "DongBei";

}
