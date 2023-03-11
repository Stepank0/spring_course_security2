package com.stepan.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity // анотация помечает клас как ответственный класс за Security Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("stepan").password("stepan").roles("EMPLOYEE"))
                .withUser(userBuilder.username("zaur").password("zaur").roles("HR"))
                .withUser(userBuilder.username("olga").password("olga").roles("MAMAGER", "HR"));
    }
}
