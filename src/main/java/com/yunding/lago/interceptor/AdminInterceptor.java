/**
 *
 * @author Justin
 * @date 2014-08-31
 */
package com.yunding.lago.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yunding.lago.util.MyConstants;

@Repository
public class AdminInterceptor implements HandlerInterceptor {

	protected static final Logger logger = LoggerFactory
			.getLogger(AdminInterceptor.class);

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
				logger.info("Exclude url:{}", uri);
				beFilter = false;
				break;
			}
		}
		if (beFilter) {
			Object obj = request.getSession().getAttribute(
					MyConstants.AdminLoginedKey);
			if (null == obj) {
				// 添加日志
				String ip = request.getRemoteAddr();
				logger.info("no access:" + uri + " ip:" + ip);
				response.sendRedirect(request.getContextPath() + "/admin/login");
				return false;
			} else {
				// 添加日志
				String url = uri.substring(uri.indexOf("admin"));
				String ip = request.getRemoteAddr();
				String usertype = request.getSession()
						.getAttribute(MyConstants.userTypeSessionKey)
						.toString();
				String userid = request.getSession()
						.getAttribute(MyConstants.userLoginIdSessionKey)
						.toString();
				logger.info("admin access:" + url + " ip:" + ip + " usertype:"
						+ usertype + " userid:" + userid);
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
