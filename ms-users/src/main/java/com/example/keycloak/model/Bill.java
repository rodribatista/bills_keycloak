package com.example.keycloak.model;

import lombok.*;

@Getter
@Setter
public class Bill {

  private String idBill;
  private String customerBill;
  private String productBill;
  private Double totalPrice;

}