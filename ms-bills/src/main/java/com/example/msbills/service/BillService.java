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

  public List<Bill> getAllBill() {
    return repository.findAll();
  }

}