package run;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.jsoup.nodes.Element;

import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.StreamRequestHandler;

import bean.Notice;
import config.Config;
import util.Leancloud;
import util.PushUtil;
import util.Spider;

public class Start implements StreamRequestHandler {

	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		execute(null);
	}

	public void execute(Object object) {
		Element element = Spider.getLatestNoticeElement();
		String href = element.attr("href");
		String title = element.text();
		// 查leancloud是否已经存在这个公告
		boolean isHrefExist = Leancloud.isHrefExist(href);
		// 如果是个新公告
		if (isHrefExist == false) {
			// 保存leancloud
			Notice notice = new Notice();
			notice.setHref(href);
			notice.setTitle(title);
			notice.setWholeUrl(Config.PREFIX + href);
			notice.setNoticeBoardUrl(Config.NOTICE_BOARD_URL);
			notice.setMissionName(Config.MISSION_NAME);
			Leancloud.saveNotice(notice);
			// 推送
			PushUtil.push(notice);
		}
	}

	public static void main(String[] args) {
		new Start().execute(null);
	}

}
