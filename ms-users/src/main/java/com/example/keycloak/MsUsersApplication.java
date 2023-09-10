package com.example.keycloak;

import com.example.keycloak.repository.FeignBillRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients(
  clients = FeignBillRepository.class)
@SpringBootApplication
public class MsUsersApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsUsersApplication.class, args);
  }

}