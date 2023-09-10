package com.example.keycloak.repository;

import com.example.keycloak.model.User;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

  private final Keycloak keycloak;

  @Value("${ms-users.keycloak.realm}")
  private String realm;

  public UserRepository(Keycloak keycloak) {
    this.keycloak = keycloak;
  }

  public User findByUsername(String username) {
    List<UserRepresentation> userRepresentation = keycloak
      .realm(realm)
      .users()
      .searchByUsername(username, true);
    return userRepresentation.stream()
      .map(this::toUser)
      .findFirst()
      .orElseThrow(NotFoundException::new);
  }

  public User findByEmail(String email) {
    List<UserRepresentation> userRepresentation = keycloak
      .realm(realm)
      .users()
      .searchByEmail(email, true);
    return userRepresentation.stream()
      .map(this::toUser)
      .findFirst()
      .orElseThrow(NotFoundException::new);
  }

  private User toUser(UserRepresentation userRepresentation) {
    return User.builder()
      .id(userRepresentation.getId())
      .userName(userRepresentation.getUsername())
      .email(userRepresentation.getEmail())
      .firstName(userRepresentation.getFirstName())
      .lastName(userRepresentation.getLastName())
      .build();
  }

}