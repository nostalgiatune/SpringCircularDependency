package com.tuoppi.multipleconfigurations.service;

import com.tuoppi.multipleconfigurations.dao.UserDao;
import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    
    private UserDao dao;

    @Autowired
    public UserService(UserDao dao) {
        this.dao = dao;
    }
    
    @RolesAllowed("ROLE_DUMMY")
    public User find(String name) {
        return dao.find(name);
    }
    
}