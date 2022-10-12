package com.blinx.userservice.service;

import com.blinx.userservice.domain.Role;
import com.blinx.userservice.domain.User;

import java.util.List;

public interface  UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
