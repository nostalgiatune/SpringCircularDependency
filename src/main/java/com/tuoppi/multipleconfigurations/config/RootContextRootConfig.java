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
    // All business components lives in this context
    
    /* Question is, do those imported configurations wait for RootConfig to finish
        component scanning and giving them a context to execute their logic against
        (making AOP proxies etc.), or are they trying to do their work on their
        private (in this case empty) context,  which is later merged with RootConfig?
    */
}