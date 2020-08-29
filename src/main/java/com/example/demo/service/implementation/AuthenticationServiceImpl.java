package com.example.demo.service.implementation;

import com.example.demo.service.exceptions.UserAlreadyExistAuthenticationException;
import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.User;
import com.example.demo.model.enums.UsersStatus;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.ValidationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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


  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  @Override
  public JwtResponse auth(JwtRequest jwtRequest) {
    System.out.println(jwtRequest.getUsername());
    User user = this.userRepository.findByUsername(jwtRequest.getUsername());
    if (user != null && encoder.matches(jwtRequest.getPassword(), user.getPassword())) {
      return JwtResponse.builder()
              .token(validationUser.authenticate(jwtRequest))
              .build();
    } else {
      return null;
    }

  }

  @Override
  public JwtResponse create(JwtRequest jwtRequest) throws UserAlreadyExistAuthenticationException {
    User user = new User();
    user.setName(jwtRequest.getName());
    user.setPassword(encoder.encode(jwtRequest.getPassword()));
    user.setUsername(jwtRequest.getUsername());
    user.setDescription(jwtRequest.getDescription());
    user.setEmail(jwtRequest.getEmail());
    user.setStatus(UsersStatus.PUBLIC_USER);
    System.out.println(this.userRepository.findByEmail(user.getEmail()));
    if (this.userRepository.findByUsername(user.getUsername()) != null || this.userRepository.findByEmail(user.getEmail()) != null) {
      throw new UserAlreadyExistAuthenticationException("User already exists!");
    } else {
      this.userRepository.save(user);
      return JwtResponse.builder()
              .token(validationUser.authenticate(jwtRequest))
              .build();
    }

  }
}
