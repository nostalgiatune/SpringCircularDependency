package com.tuoppi.multipleconfigurations.config;

import com.tuoppi.multipleconfigurations.dao.UserDao;
import com.tuoppi.multipleconfigurations.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    RootContextPersistenceConfig.class,
    RootContextWebSecurityConfig.class,
    RootContextMethodSecurityConfig.class
})
@ComponentScan(basePackageClasses = {
    UserService.class,
    UserDao.class
})
public class RootContextRootConfig {
}