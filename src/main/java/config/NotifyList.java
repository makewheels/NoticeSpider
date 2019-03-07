package config;

import java.util.ArrayList;
import java.util.List;

/**
 * 通知列表
 * 
 * @author Administrator
 *
 */
public class NotifyList {

	public static List<String> getMailList() {
		List<String> mailList = new ArrayList<>();
		mailList.add("angrybirdcrash@163.com");
		mailList.add("daqingdayou@163.com");
		mailList.add("tongbuwangpan@163.com");
		mailList.add("finalbird@foxmail.com");
		mailList.add("174582555@qq.com");
		return mailList;
	}

}
