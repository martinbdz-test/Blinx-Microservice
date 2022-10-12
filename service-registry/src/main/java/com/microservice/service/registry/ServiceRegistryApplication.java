package com.microservice.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

	@PostConstruct
	public void init(){

		TimeZone.setDefault(TimeZone.getTimeZone("Africa/Lagos"));   // Set WAT timezone
		System.out.println("Spring boot application running in UTC timezone :"+new Date());   // show timezone on startup

	}
	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}
