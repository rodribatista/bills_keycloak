package com.example.keycloak.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private String id;
  private String userName;
  private String email;
  private String firstName;
  private String lastName;
  private List<Bill> bills;

}