package util;

import java.util.List;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;

import bean.Notice;
import config.Config;

public class Leancloud {

	static {
		AVOSCloud.initialize("agmVem6N26blxhy5RXjMrtcT-gzGzoHsz", "DMcVET7CCdiMCLaSwatxQiu1",
				"zBWvOJKRktkdjXPhxCHxc8Sz");
	}

	/**
	 * 查询指定href是否存在
	 * 
	 * @param href
	 */
	public static boolean isHrefExist(String href) {
		AVQuery<AVObject> query = new AVQuery<>(Config.LEANCLOUD_CLASS_NAME);
		query.whereEqualTo("href", href);
		List<AVObject> list = null;
		try {
			list = query.find();
		} catch (AVException e) {
			e.printStackTrace();
		}
		if (list != null && list.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 保存新公告
	 * 
	 * @param notice
	 */
	public static void saveNotice(Notice notice) {
		AVObject avObject = new AVObject(Config.LEANCLOUD_CLASS_NAME);
		avObject.put("href", notice.getHref());
		avObject.put("title", notice.getTitle());
		avObject.put("wholeUrl", notice.getWholeUrl());
		avObject.put("noticeBoardUrl", notice.getNoticeBoardUrl());
		avObject.put("missionName", notice.getMissionName());
		try {
			avObject.save();
		} catch (AVException e) {
			e.printStackTrace();
		}
	}

}
