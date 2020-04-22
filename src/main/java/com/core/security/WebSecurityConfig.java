package com.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 注册UserDetailsService的bean
    @Bean
    UserDetailsService userDetailsServiceImpl() {
        return new UserDetailsServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 添加自定义的userDetailsServiceImpl认证
        auth.userDetailsService(userDetailsServiceImpl()).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()// authorizeRequests() 定义哪些URL需要被保护、哪些不需要被保护
                //.antMatchers("/jquery/**","/bootstrap/**","/css/**","/templates/**").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/load/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable()
                .headers().frameOptions().sameOrigin();
    }
}
