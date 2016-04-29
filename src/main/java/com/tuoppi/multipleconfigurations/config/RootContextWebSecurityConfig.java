package com.tuoppi.multipleconfigurations.config;


import com.tuoppi.multipleconfigurations.authentication.MyUserDetailsService;
import com.tuoppi.multipleconfigurations.dao.UserDao;
import com.tuoppi.multipleconfigurations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

@Configuration("websecurity")
@EnableWebSecurity
public class RootContextWebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserDao dao;
    
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    
    @Bean @Transactional
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService(dao);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.userDetailsService(userDetailsService());
        System.out.println("aob ok");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.formLogin().and().authorizeRequests().antMatchers("/**").denyAll();
    }
    
}