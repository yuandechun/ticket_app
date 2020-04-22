package com.pms.loginmanage.service;

import com.common.usermanage.pojo.SysUser;

public interface LoginService {
	
	/****
	 * register application user
	 * @param registerUser
	 */
	public void registerUser(SysUser registerUser);
	
	
	/***
	 * login application
	 * @param loginUser
	 * @return
	 */
	public SysUser loginSys(SysUser loginUser);
	
	
	/****
	 * find user by username
	 * @param username
	 * @return
	 */
	public SysUser findUserByUsername(String username);
	
}
