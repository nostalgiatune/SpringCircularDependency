package com.tuoppi.multipleconfigurations.authentication;


import com.tuoppi.multipleconfigurations.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
    
    private final UserService service;

    public MyUserDetailsService(UserService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = service.find(name);
        if (user == null)
            throw new UsernameNotFoundException(name);
        return user;
    }
    
}