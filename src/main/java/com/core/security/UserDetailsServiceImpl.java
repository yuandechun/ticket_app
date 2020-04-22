package com.core.security;

import com.common.usermanage.pojo.SysUser;
import com.pms.loginmanage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    public LoginService loginService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser user = loginService.findUserByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("not find user " + userName + " info!");
        }
        return new UserDetailsImpl(user);
    }

}
