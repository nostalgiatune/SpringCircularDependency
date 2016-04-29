package com.tuoppi.multipleconfigurations.dao;


import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public User find(String name) {
        return new User("DUMMY", "DUMMY", Arrays.asList(new SimpleGrantedAuthority("ROLE_DUMMY")));
    }
}