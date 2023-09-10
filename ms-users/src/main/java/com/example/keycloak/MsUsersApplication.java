package com.example.keycloak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsUsersApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsUsersApplication.class, args);
  }

}