package com.common.usermanage.service.impl;

import com.common.usermanage.pojo.SysUser;
import com.common.usermanage.repository.SysUserRepository;
import com.common.usermanage.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public List<SysUser> loadAllSysUser(SysUser querySysUser) {
        return sysUserRepository.loadAllSysUser(querySysUser);
    }

    @Override
    public SysUser loadSysUserById(int id) {
        return sysUserRepository.loadSysUserById(id);
    }

    @Override
    public SysUser loadSysUserByUserName(String userName) {
        return sysUserRepository.loadSysUserByUserName(userName);
    }

    @Override
    public void updateSysUser(SysUser updateSysUser) {
        validateAddOrUpdateSysUser(updateSysUser);
        sysUserRepository.updateSysUser(updateSysUser);
    }

    @Override
    public void deleteSysUserById(int id) {
        sysUserRepository.deleteSysUserById(id);
    }

    @Override
    public void deleteSysUserByUserName(String userName) {
        sysUserRepository.deleteSysUserByUserName(userName);
    }

    @Override
    public void addSysUser(SysUser addSysUser) {
        validateAddOrUpdateSysUser(addSysUser);
        sysUserRepository.addSysUser(addSysUser);
    }

    protected void validateAddOrUpdateSysUser(SysUser sysUser) {
        if (false) {
            //throw new Exception("validate failed for add or update operation");
        }
    }
}
