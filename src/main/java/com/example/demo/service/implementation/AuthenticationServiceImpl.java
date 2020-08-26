package com.example.demo.service.implementation;

import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.ValidationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
  private final ValidationUser validationUser;
  private final UserRepository userRepository;

  @Autowired
  public AuthenticationServiceImpl (UserRepository userRepository, ValidationUser validationUser) {
    this.userRepository = userRepository;
    this.validationUser = validationUser;
  }

  @Override
  public JwtResponse auth(JwtRequest jwtRequest) {
    User user = this.userRepository.findByUsernameAndAndPassword(jwtRequest.getUsername(), jwtRequest.getPassword());
    if (user == null) {
      return JwtResponse.builder()
              .token("User doesn't exist.")
              .build();
    }
    return JwtResponse.builder()
            .token(validationUser.authenticate(jwtRequest))
            .build();
  }

  @Override
  public JwtResponse create(JwtRequest jwtRequest) {
    User user = new User();
    user.setName(jwtRequest.getName());
    user.setPassword(jwtRequest.getPassword());
    user.setUsername(jwtRequest.getUsername());
    user.setDescription(jwtRequest.getDescription());
    this.userRepository.save(user);
    return JwtResponse.builder()
            .token(validationUser.authenticate(jwtRequest))
            .build();
  }
}
