package com.pms.loginmanage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.core.controller.BaseController;
import com.pms.loginmanage.service.LoginService;
import com.common.usermanage.pojo.SysUser;

@Controller
@RequestMapping("/sys")
public class LoginController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	/****
	 * login system application
	 * 
	 * @param request
	 * @param response
	 * @param
	 * @return
	 */
	@PostMapping("/login")
	public String loginSys(HttpServletRequest request, HttpServletResponse response, SysUser loginUser) {
		String loginResult = "login";
		HttpSession session = request.getSession();
		try {
			SysUser user = loginService.loginSys(loginUser);
			if (user != null) {
				session.setAttribute("user_name", user.getUserName());
				loginResult = "menu";
				logger.info("login application success!");
			} else {
				loginResult = "login";
				logger.info("user name and password is not right!");
			}
		} catch (Exception e) {
			loginResult = "login";
			logger.info("login application fail!");
		}
		return loginResult;
	}

	/***
	 * register system application
	 * 
	 * @param request
	 * @param response
	 * @param
	 * @return
	 */
	@PostMapping("/register")
	public String registerSys(HttpServletRequest request, HttpServletResponse response, SysUser registerUser) {
		String registerResult = "login";
		try {
			loginService.registerUser(registerUser);
			logger.info("register application success!");
		} catch (Exception e) {
			registerResult = "register";
			logger.info("register application fail!");
			e.printStackTrace();
		}
		return registerResult;
	}

	/****
	 * logout application
	 * 
	 * @param request
	 * @param response
	 * @param registerUser
	 * @return
	 */
	@PostMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, SysUser registerUser) {
		String logoutResult = "login";
		logger.info("logout application success!");
		return logoutResult;
	}

}
