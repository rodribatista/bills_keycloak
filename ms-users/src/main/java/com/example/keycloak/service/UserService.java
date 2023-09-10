package com.example.keycloak.service;

import com.example.keycloak.model.Bill;
import com.example.keycloak.model.User;
import com.example.keycloak.repository.BillRepository;
import com.example.keycloak.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final BillRepository billRepository;

  public UserService(UserRepository userRepository, BillRepository billRepository) {
    this.userRepository = userRepository;
    this.billRepository = billRepository;
  }

  public User getUserByUsername(String username) {
    User user = userRepository.findByUsername(username);
    user.setBills(getBillsByUserId(user.getId()));
    return user;
  }

  public User getUserByEmail(String email) {
    User user = userRepository.findByEmail(email);
    user.setBills(getBillsByUserId(user.getId()));
    return user;
  }

  private List<Bill> getBillsByUserId(String userId) {
    return billRepository.findBillsByUserId(userId);
  }

}