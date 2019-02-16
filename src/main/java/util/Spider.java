package util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.seimicrawler.xpath.JXDocument;

import config.Config;

/**
 * 爬虫
 * 
 * @author Administrator
 *
 */
public class Spider {

	/**
	 * 返回最新公告元素
	 * 
	 * @return
	 */
	public static Element getLatestNoticeElement() {
		String html = WebUtil.sendGet(Config.NOTICE_BOARD_URL);
		Document document = Jsoup.parse(html);
		JXDocument jxDocument = new JXDocument(document.getAllElements());
		return jxDocument.selNOne(Config.XPATH).asElement();
	}

}
