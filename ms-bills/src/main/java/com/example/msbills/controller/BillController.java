package com.example.msbills.controller;

import com.example.msbills.models.Bill;
import com.example.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

  private final BillService service;

  @GetMapping("/all")
  @PreAuthorize("hasRole('ROLE_user')")
  public ResponseEntity<List<Bill>> getAll() {
    return ResponseEntity.ok().body(service.getAllBills());
  }

  @GetMapping("/userId={id}")
  public ResponseEntity<List<Bill>> getByUserId(@PathVariable String id) {
    return ResponseEntity.ok().body(service.getBillsByUserId(id));
  }

}