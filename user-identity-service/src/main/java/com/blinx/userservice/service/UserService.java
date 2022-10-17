package com.blinx.userservice.service;

import com.blinx.userservice.domain.User;

import java.util.List;

public interface  UserService {

    User saveUser(User user);
    User getUser(String userName);
    List<User> getUsers();
}
