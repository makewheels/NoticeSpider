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
		mailList.add("finalbird@foxmail.com");
		return mailList;
	}

}
