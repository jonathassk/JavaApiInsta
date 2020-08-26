package com.example.demo.controllers;

import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.User;
import com.example.demo.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
  private final AuthenticationService authenticationService;

  public UserController (AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/auth")
  public JwtResponse createAuthenticationToken(@RequestBody JwtRequest auth) {
    return authenticationService.auth(auth);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/create")
  public JwtResponse saveAuthenticationToken(@RequestBody JwtRequest auth) {
    return authenticationService.create(auth);
  }
}
