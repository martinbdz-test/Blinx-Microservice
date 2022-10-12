package com.blinx.userservice.repo;

import com.blinx.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}