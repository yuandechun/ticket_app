package com.pms.loginmanage.repository;

import org.apache.ibatis.annotations.Mapper;

import com.common.usermanage.pojo.SysUser;

@Mapper
public interface LoginRepository {
	
	/****
	 * register system application user
	 * @param registerUser
	 */
	public void registerUser(SysUser registerUser);
	
	
	/****
	 * find user by user name
	 * @param username
	 * @return
	 */
	public SysUser findUserByUsername(String username);
	
	
	/****
	 * get user by user name
	 * @param loginUser
	 * @return
	 */
	public SysUser loginSys(SysUser loginUser);
	
}
