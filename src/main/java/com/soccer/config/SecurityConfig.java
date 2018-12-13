package com.soccer.config;

import com.soccer.model.users.Users;
import com.soccer.repository.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final Environment environment;

    @Autowired
    public SecurityConfig(Environment environment) {
        this.environment = environment;
    }


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DataSource dataSource;

    @Override
    protected  void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        List<Users> usersList = userRepository.findAll();
        for (Users user : usersList) {
            authenticationManagerBuilder.inMemoryAuthentication()
                    .withUser(user.getUsername()).password("{noop}"+user.getPassword()).roles("USER");
        }
    }
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .anyRequest()
                .fullyAuthenticated()
                .and().httpBasic();
        httpSecurity.csrf().disable();
    }

}
