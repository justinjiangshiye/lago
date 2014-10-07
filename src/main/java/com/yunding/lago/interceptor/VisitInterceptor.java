/**
 *
 * @author Justin
 * @date 2014-08-31
 * @description Not used, because can't distinguish net spider visit.
 */
package com.yunding.lago.interceptor;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yunding.lago.bean.VisitLog;
import com.yunding.lago.service.VisitLogService;
import com.yunding.lago.util.HttpHelper;
import com.yunding.lago.util.MyConstants;

@Repository
public class VisitInterceptor implements HandlerInterceptor {

	protected static final Logger logger = LoggerFactory
			.getLogger(AdminInterceptor.class);

	private VisitLogService visitLogService = null;

	@Autowired
	public void setVisitLogService(VisitLogService visitLogService) {
		this.visitLogService = visitLogService;
	}

	private List<String> excludedUrls;

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String uri = request.getRequestURI();

		boolean beFilter = true;
		for (String s : excludedUrls) {
			if (uri.indexOf(s) != -1) {
				beFilter = false;
				break;
			}
		}
		if (beFilter) {
			try {
				VisitLog visitLog = new VisitLog();
				visitLog.setUrl(uri);
				visitLog.setSessionid(request.getSession().getId());
				if (request.getSession().getAttribute(
						MyConstants.userLoginIdSessionKey) != null) {
					visitLog.setUserloginid(request.getSession()
							.getAttribute(MyConstants.userLoginIdSessionKey)
							.toString());
				}
				visitLog.setIp(HttpHelper.extractRemoteIP(request));
				visitLog.setCreatedon(new Date());
				visitLog.setRecordstatus(0);
				this.visitLogService.addVisitLog(visitLog);
			} catch (Exception ex) {
				logger.error(ex.getMessage());
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
