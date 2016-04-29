package com.tuoppi.multipleconfigurations.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebContextConfig extends WebSecurityConfigurerAdapter {
    // TODO
}