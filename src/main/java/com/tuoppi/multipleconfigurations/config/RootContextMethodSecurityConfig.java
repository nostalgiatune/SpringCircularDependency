package com.tuoppi.multipleconfigurations.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@DependsOn("websecurity")
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class RootContextMethodSecurityConfig extends GlobalMethodSecurityConfiguration {
    
}