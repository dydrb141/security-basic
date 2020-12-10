package com.cos.security1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author YongKyu.Han
 * @since 2020-12-09
 */
@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스트링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter { //얘가 시큐리티 필터

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/user/**").authenticated() //user로 접근하는건 인증이 필요하다
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')") //manager로 요청은 admin과 manager 권한이필요
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')") //admin 접근은 admin 권한이 필요
        .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login");
    }
}
