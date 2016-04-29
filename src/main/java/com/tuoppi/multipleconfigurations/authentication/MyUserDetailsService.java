package com.tuoppi.multipleconfigurations.authentication;


import com.tuoppi.multipleconfigurations.dao.UserDao;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
    
    private final UserDao dao;
    
    public MyUserDetailsService(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = dao.find(name);
        if (user == null)
            throw new UsernameNotFoundException(name);
        return user;
    }
    
}