package com.pms.loginmanage.service.impl;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.core.mail.service.EmailService;
import com.pms.loginmanage.repository.LoginRepository;
import com.pms.loginmanage.service.LoginService;
import com.common.usermanage.pojo.SysUser;

@Service
public class LoginServiceImpl implements LoginService {

	private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private EmailService emailService;

	@Override
	public void registerUser(SysUser registerUser) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		registerUser.setPassword(bCryptPasswordEncoder.encode(registerUser.getPassword()));
		registerUser.setTimestamp(new Date());
		loginRepository.registerUser(registerUser);
		logger.info("user: " + registerUser.getUserName() + " register success！");
		// after register success will send email to user
		if (registerUser != null && registerUser.getEmail() != null) {
			String[] to = { registerUser.getEmail() };
			emailService.sendSimpleEmail(to, "welcome to join ",
					"You have successfully registered for Project Management System. \n URL:http://10.64.153.136:8080/load/login");
			logger.info("send user : " + registerUser.getUserName() + " email success！");
		}
	}

	@Override
	public SysUser loginSys(SysUser loginUser) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		SysUser user = loginRepository.findUserByUsername(loginUser.getUserName());
		// user name is not right
		if (user == null) {
			logger.info("user: " + loginUser.getUserName() + " user name is not right！");
		} else if (!bCryptPasswordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
			// password is not right
			user = null;
			logger.info("user: " + loginUser.getUserName() + " password is not right！");
		}
		return user;
	}

	@Override
	public SysUser findUserByUsername(String username) {
		return loginRepository.findUserByUsername(username);
	}

}
