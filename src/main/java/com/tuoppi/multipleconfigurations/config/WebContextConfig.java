package com.tuoppi.multipleconfigurations.config;


import com.tuoppi.multipleconfigurations.controller.UserController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {
    UserController.class
})
public class WebContextConfig extends WebSecurityConfigurerAdapter {
    // TODO
}