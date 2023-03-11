package com.stepan.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@EnableWebSecurity // анотация помечает клас как ответственный класс за Security Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    // dataSource бин такойже как и в MyConfig (информация о подключении к базе данных в этом бине)


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/hr_info").hasRole("HR")
                .antMatchers("/manager_info/**").hasRole("MANAGER")  // /** достуб и к дальнейшим страницам
                .and().formLogin().permitAll(); //форма логина и пароля будет запрашиваться у всех

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //SpringConfig теперь знает что инфу об пользователях надо брать из БД
        auth.jdbcAuthentication().dataSource(dataSource);


//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("stepan").password("stepan").roles("EMPLOYEE"))
//                .withUser(userBuilder.username("zaur").password("zaur").roles("HR"))
//                .withUser(userBuilder.username("olga").password("olga").roles("MANAGER", "HR"));
//        // запрет для разных ролей на переход на определённый адресс
    }
}
