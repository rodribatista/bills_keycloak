package com.example.keycloak.repository;

import com.example.keycloak.model.Bill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillRepository {

  private final FeignBillRepository feignBillRepository;

  public BillRepository(FeignBillRepository feignBillRepository) {
    this.feignBillRepository = feignBillRepository;
  }

  public List<Bill> findBillsByUserId(String userId) {
    return feignBillRepository.findBillsByUserId(userId).getBody();
  }

}