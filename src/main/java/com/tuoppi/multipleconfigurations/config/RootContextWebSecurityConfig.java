package com.tuoppi.multipleconfigurations.config;


import com.tuoppi.multipleconfigurations.authentication.MyUserDetailsService;
import com.tuoppi.multipleconfigurations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableWebSecurity
public class RootContextWebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserDetailsService service;
    
    @Bean @Transactional
    /* Should wait for MethodSecurityConfig to make proxy for service, but fails */
    public UserDetailsService userDetailsService(UserService service) {
        return new MyUserDetailsService(service);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(service);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.formLogin().and().authorizeRequests().antMatchers("/**").denyAll();
    }
    
}