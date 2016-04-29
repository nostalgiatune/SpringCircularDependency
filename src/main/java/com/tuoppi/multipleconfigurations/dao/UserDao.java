package com.tuoppi.multipleconfigurations.dao;

import org.springframework.security.core.userdetails.User;

public interface UserDao {
    User find(String name);
}