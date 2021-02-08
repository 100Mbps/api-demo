package com.dgyt.demo.service;

import com.dgyt.demo.entity.User;

import java.util.Set;

public interface UserService {
   Set<String> getUserRolesSet(String name);

    Set<String> getUserPermissionsSet(String username);

    User findByUserName(String userName);
}
