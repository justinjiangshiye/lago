package com.yunding.lago.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import com.qq.connect.utils.http.BASE64Encoder;
import com.yunding.lago.bean.BannerLink;
import com.yunding.lago.bean.User;
import com.yunding.lago.service.UserService;
import com.yunding.lago.util.MyConstants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController extends BaseController {
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/user/qqlogin", method = RequestMethod.GET)
	public void qqlogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html;charset=utf-8");
		try {
			response.sendRedirect(new Oauth().getAuthorizeURL(request));
		} catch (QQConnectException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/user/afterqqlogin", method = RequestMethod.GET)
	public String afterqqlogin(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			AccessToken accessTokenObj = (new Oauth())
					.getAccessTokenByRequest(request);

			String accessToken = null;
			String openID = null;
			long tokenExpireIn = 0L;

			if (accessTokenObj.getAccessToken().equals("")) { // 我们的网站被CSRF攻击了或者用户取消了授权做一些数据统计工作
				logger.info("没有获取到响应参数");
			} else {
				// Clean session for new login user
				request.getSession().invalidate();
				
				accessToken = accessTokenObj.getAccessToken();
				tokenExpireIn = accessTokenObj.getExpireIn();

				request.getSession().setAttribute(
						MyConstants.accessTokenSessionKey, accessToken);
				request.getSession().setAttribute(
						MyConstants.accessTokenExpiredInSessionKey,
						String.valueOf(tokenExpireIn));

				// 利用获取到的accessToken 去获取当前用的openid
				OpenID openIDObj = new OpenID(accessToken);
				openID = openIDObj.getUserOpenID();

				logger.info("欢迎你，代号为 " + openID + " 的用户!");
				request.getSession().setAttribute(
						MyConstants.userLoginIdSessionKey, openID);

				User user = this.userService.queryUserByLoginId(openID);

				// 利用获取到的accessToken,openid 去获取用户在Qzone的昵称等信息
				UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
				UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();

				if (userInfoBean.getRet() == 0) {
					logger.info(userInfoBean.getNickname() + "<br/>");
					logger.info(userInfoBean.getGender() + "<br/>");
					logger.info("黄钻等级： " + userInfoBean.getLevel() + "<br/>");
					logger.info("会员 : " + userInfoBean.isVip() + "<br/>");
					logger.info("黄钻会员： " + userInfoBean.isYellowYearVip()
							+ "<br/>");
					logger.info("<image src="
							+ userInfoBean.getAvatar().getAvatarURL30()
							+ "/><br/>");
					logger.info("<image src="
							+ userInfoBean.getAvatar().getAvatarURL50()
							+ "/><br/>");
					logger.info("<image src="
							+ userInfoBean.getAvatar().getAvatarURL100()
							+ "/><br/>");

					if (user == null) {
						user = new User();
						user.setType(MyConstants.qqUser);
						user.setLoginid(openID);
						user.setNickname(userInfoBean.getNickname());
						user.setProfilephotourl(userInfoBean.getAvatar()
								.getAvatarURL30());
						user.setLastvisiton(new Date());
						user.setCreatedon(new Date());
						user.setRegisteron(user.getCreatedon());
						user.setRecordstatus(0);
						this.userService.addUser(user);
					} else {
						user.setNickname(userInfoBean.getNickname());
						user.setProfilephotourl(userInfoBean.getAvatar()
								.getAvatarURL30());
						user.setLastvisiton(new Date());
						this.userService.updateUser(user);
					}
				} else {
					logger.info("很抱歉，我们没能正确获取到您的信息，原因是： "
							+ userInfoBean.getMsg());
				}
				/*
				 * // 验证当前用户是否为认证空间的粉丝 PageFans pageFansObj = new
				 * PageFans(accessToken, openID); PageFansBean pageFansBean =
				 * pageFansObj.checkPageFans("97700000"); if
				 * (pageFansBean.getRet() == 0) { logger.info("<p>验证您" +
				 * (pageFansBean.isFans() ? "是" : "不是") +
				 * "QQ空间97700000官方认证空间的粉丝</p>"); } else {
				 * logger.info("很抱歉，我们没能正确获取到您的信息，原因是： " +
				 * pageFansBean.getMsg()); }
				 * 
				 * // 利用获取到的accessToken,openid 去获取用户在微博的昵称等信息
				 * com.qq.connect.api.weibo.UserInfo weiboUserInfo = new
				 * com.qq.connect.api.weibo.UserInfo(accessToken, openID);
				 * com.qq.connect.javabeans.weibo.UserInfoBean weiboUserInfoBean
				 * = weiboUserInfo.getUserInfo(); if (weiboUserInfoBean.getRet()
				 * == 0) { //获取用户的微博头像----------------------start
				 * logger.info("<image src=" +
				 * weiboUserInfoBean.getAvatar().getAvatarURL30() + "/><br/>");
				 * logger.info("<image src=" +
				 * weiboUserInfoBean.getAvatar().getAvatarURL50() + "/><br/>");
				 * logger.info("<image src=" +
				 * weiboUserInfoBean.getAvatar().getAvatarURL100() + "/><br/>");
				 * //获取用户的微博头像 ---------------------end
				 * 
				 * //获取用户的生日信息 --------------------start
				 * logger.info("<p>尊敬的用户，你的生日是： " +
				 * weiboUserInfoBean.getBirthday().getYear() + "年" +
				 * weiboUserInfoBean.getBirthday().getMonth() + "月" +
				 * weiboUserInfoBean.getBirthday().getDay() + "日"); //获取用户的生日信息
				 * --------------------end
				 * 
				 * StringBuffer sb = new StringBuffer(); sb.append("<p>所在地:" +
				 * weiboUserInfoBean.getCountryCode() + "-" +
				 * weiboUserInfoBean.getProvinceCode() + "-" +
				 * weiboUserInfoBean.getCityCode() +
				 * weiboUserInfoBean.getLocation());
				 * 
				 * //获取用户的公司信息---------------------------start
				 * ArrayList<Company> companies =
				 * weiboUserInfoBean.getCompanies(); if (companies.size() > 0) {
				 * //有公司信息 for (int i=0, j=companies.size(); i<j; i++) {
				 * sb.append("<p>曾服役过的公司：公司ID-" + companies.get(i).getID() +
				 * " 名称-" + companies.get(i).getCompanyName() + " 部门名称-" +
				 * companies.get(i).getDepartmentName() + " 开始工作年-" +
				 * companies.get(i).getBeginYear() + " 结束工作年-" +
				 * companies.get(i).getEndYear()); } } else { //没有公司信息 }
				 * //获取用户的公司信息---------------------------end
				 * 
				 * logger.info(sb.toString());
				 * 
				 * } else { logger.info("很抱歉，我们没能正确获取到您的信息，原因是： " +
				 * weiboUserInfoBean.getMsg()); } logger.info(
				 * "<p> end -----------------------------------利用获取到的accessToken,openid 去获取用户在微博的昵称等信息 ---------------------------- end </p>"
				 * ); }
				 */
			}
		} catch (QQConnectException e) {
		}
		return "redirect:/";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 */
	@RequestMapping(value = "/user/weibologin", method = RequestMethod.GET)
	public void weibologin(HttpServletRequest request,
			HttpServletResponse response) throws IOException, WeiboException {
		response.setContentType("text/html;charset=utf-8");
		try {
			response.sendRedirect(new weibo4j.Oauth().authorize("code", "",
					"all"));
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws JSONException
	 * 
	 */
	@RequestMapping(value = "/user/afterweibologin", method = RequestMethod.GET)
	public String afterweibologin(HttpServletRequest request,
			HttpServletResponse response) throws WeiboException, JSONException {
		try {
			logger.info("weibo authorization code is {}",
					request.getParameter("code"));
			weibo4j.Oauth oauth = new weibo4j.Oauth();
			weibo4j.http.AccessToken accessTokenObj = oauth
					.getAccessTokenByCode(request.getParameter("code"));
			String accessToken = accessTokenObj.getAccessToken();
			logger.info("weibo access token is {}", accessToken);

			weibo4j.Account account = new weibo4j.Account(accessToken);
			weibo4j.org.json.JSONObject uidJson = account.getUid();
			String uid = uidJson.getString("uid");
			logger.info("weibo user id is {}", uid);

			weibo4j.Users users = new weibo4j.Users(accessToken);
			weibo4j.model.User weiboUser = users.showUserById(uid);

			// Clean session for new login user
			request.getSession().invalidate();
			
			request.getSession().setAttribute(
					MyConstants.userLoginIdSessionKey, uid);

			User user = this.userService.queryUserByLoginId(uid);
			if (weiboUser != null) {
				if (user == null) {
					user = new User();
					user.setType(MyConstants.weiboUser);
					user.setLoginid(uid);
					user.setNickname(weiboUser.getScreenName());
					user.setProfilephotourl(weiboUser.getProfileImageUrl());
					user.setLastvisiton(new Date());
					user.setCreatedon(new Date());
					user.setRegisteron(user.getCreatedon());
					user.setRecordstatus(0);
					this.userService.addUser(user);
				} else {
					user.setNickname(weiboUser.getScreenName());
					user.setProfilephotourl(weiboUser.getProfileImageUrl());
					user.setLastvisiton(new Date());
					this.userService.updateUser(user);
				}
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public String userLogout(Locale locale, Model model) {
		logger.info("Access: /user/logout");

		this.getHttpSession().invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
	public String adminLogout(Locale locale, Model model) {
		logger.info("Access: /admin/logout");

		this.getHttpSession().invalidate();
		return "redirect:/admin/";
	}

	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public String adminUserList(Locale locale, Model model) {
		adminInitialize(model, MyConstants.adminMenuItemUsersId);

		model.addAttribute("userList", this.userService.queryAllUser());

		return "admin/users";
	}
	
	@RequestMapping(value = "/admin/userAdd", method = RequestMethod.GET)
	public String adminUserAdd(Locale locale, Model model) {
		adminInitialize(model, MyConstants.adminMenuItemUsersId);

		return "admin/userAdd";
	}
	
	@RequestMapping(value = "/admin/userSave", method = RequestMethod.POST)
	public String adminUserSave(Locale locale, Model model, User user) {
		adminInitialize(model, MyConstants.adminMenuItemUsersId);

		logger.info("user Id is {}", user.getId());
		logger.info("user Loginid is {}.", user.getLoginid());
		logger.info("user Nickname is {}.", user.getNickname());
		logger.info("user Profilephotourl is {}.", user.getProfilephotourl());

		Date now = new Date();
		user.setRecordstatus(0);

		if (user.getId() == null) {
			user.setRegisteron(now);
			user.setLastvisiton(now);
			user.setCreatedon(now);
			user.setPassword(BASE64Encoder.encode(user.getPassword().getBytes()));
			user.setType(MyConstants.systemUser);
			this.userService.addUser(user);
		} else {
			User userDB = this.userService.queryUserByLoginId(user.getLoginid());
			userDB.setLoginid(user.getLoginid());
			userDB.setNickname(user.getNickname());
			userDB.setProfilephotourl(user.getProfilephotourl());
			this.userService.updateUser(userDB);
		}
		
		return "redirect:/admin/users";
	}

	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String adminUserLogin(Locale locale, Model model) {
		logger.info("Access: /admin/login");
		return "admin/login";
	}

	@RequestMapping(value = "/admin/doLogin", method = RequestMethod.POST)
	public String adminUserDoLogin(Locale locale, Model model, User user) {
		logger.info("Access: /admin/login POST");

		User dbUser = this.userService.queryUserByLoginId(user.getLoginid());

		if (dbUser != null && dbUser.getType() == MyConstants.systemUser) {
			if (BASE64Encoder.encode(user.getPassword().getBytes()).equals(
					dbUser.getPassword())) {
				this.getHttpSession().setAttribute(MyConstants.AdminLoginedKey,
						true);
				this.getHttpSession().setAttribute(
						MyConstants.userTypeSessionKey, dbUser.getType());
				this.getHttpSession().setAttribute(
						MyConstants.userLoginIdSessionKey, dbUser.getLoginid());
				return "redirect:/admin/";
			}
		}

		model.addAttribute("loginStatus", false);
		model.addAttribute("msg", "登录失败，请重试！");

		return "admin/login";
	}
}
