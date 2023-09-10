package com.example.keycloak.service;

import com.example.keycloak.model.User;
import com.example.keycloak.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  public User getUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

}