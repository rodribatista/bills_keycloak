package com.example.keycloak.repository;

import com.example.keycloak.config.FeignInterceptor;
import com.example.keycloak.model.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "ms-bills", configuration = FeignInterceptor.class)
public interface FeignBillRepository {

  @RequestMapping(method = RequestMethod.GET, value = "/bills/userId={userId}")
  ResponseEntity<List<Bill>> findBillsByUserId(@PathVariable String userId);

}