package com.example.msbills.service;

import com.example.msbills.repositories.BillRepository;
import com.example.msbills.models.Bill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

  private final BillRepository repository;

  public List<Bill> getAllBills() {
    return repository.findAll();
  }

  public List<Bill> getBillsByUserId(String id) {
    return repository.getBillsByCustomerBill(id);
  }

  public String createNewBill(Bill bill) {
    Bill createdBill = repository.save(bill);
    return createdBill.getIdBill();
  }

}