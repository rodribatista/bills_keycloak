package com.example.msbills.repositories;

import com.example.msbills.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, String> {

  List<Bill> getBillsByCustomerBill(String customerBill);

}