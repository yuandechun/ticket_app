package com.common.usermanage.service;

import java.util.List;

import com.common.usermanage.pojo.SysUser;

public interface SysUserService {

    /***
     *
     * @param querySysUser
     * @return
     */

    public List<SysUser> loadAllSysUser(SysUser querySysUser);

    /***
     * load sys user by user id
     */
    public SysUser loadSysUserById(int id);

    /***
     * load sys user by user name
     */
    public SysUser loadSysUserByUserName(String userName);

    /***
     * update sys user info
     */
    public void updateSysUser(SysUser updateSysUser);


    /***
     * delete sys user by id
     */
    public void deleteSysUserById(int id);

    /***
     * delete sys user by user name
     */
    public void deleteSysUserByUserName(String userName);


    /****
     *
     * add  sys user info
     *
     */
    public void addSysUser(SysUser addSysUser);

}
