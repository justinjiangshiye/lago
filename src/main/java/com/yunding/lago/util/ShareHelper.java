package com.yunding.lago.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ShareHelper {
	public static String getShareRedirectUrl(String sns, String url,
			String title, String summary, String pics) {

		if (sns.equals("weixin")) {
			return "weixinshare";
		}

		String snsUrlTemplate = "";
		if (sns.equals("sinaweibo")) {
			snsUrlTemplate = WebConfig
					.getValue(MyConstants.configSinaWeiboShareTemplate);
		} else if (sns.equals("qqspace")) {
			snsUrlTemplate = WebConfig
					.getValue(MyConstants.configQQSpaceShareTemplate);
		} else { // tx weibo by default
			snsUrlTemplate = WebConfig
					.getValue(MyConstants.configTXWeiboShareTemplate);
		}
		String encoding = "UTF-8";
		try {
			return "redirect:"
					+ snsUrlTemplate
							.replace("#{url}", URLEncoder.encode(url, encoding))
							.replace("#{title}",
									URLEncoder.encode(title, encoding))
							.replace("#{summary}",
									URLEncoder.encode(summary, encoding))
							.replace("#{pics}",
									URLEncoder.encode(pics, encoding));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "weixinshare";
		}
	}
}