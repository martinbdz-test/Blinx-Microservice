package com.blinx.userservice.service;

import com.blinx.userservice.domain.User;
import com.blinx.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional @RequiredArgsConstructor
@Slf4j

public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else{
            log.error("User found in the database {}", username);
        }

        
        return new  org.springframework.security.core.userdetails.User
                (user.getUsername(), user.getPassword(), null);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new user {} to the database", user.getName());
        return userRepo.save(user);
    }


    @Override
    public User getUser(String userName) {
        return userRepo.findByUsername(userName);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
