package com.blinx.userservice;

import com.blinx.userservice.domain.Role;
import com.blinx.userservice.domain.User;
import com.blinx.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run (UserService userService){
		return args -> {
			userService.saveUser(new User(null, "Olajide Bashorun", "Olajide","1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Kofoworola Bashorun", "Kofoworola","1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Ololade Bashorun", "Ololade","1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Kehinde Bashorun", "Kehinde","1234", new ArrayList<>()));

			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.addRoleToUser("Olajide", "ROLE_MANAGER");
			userService.addRoleToUser("Kofoworola", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Ololade", "ROLE_ADMIN");
			userService.addRoleToUser("Kehinde", "ROLE_USER");
		};
	}

}
