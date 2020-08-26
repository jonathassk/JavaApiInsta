package com.example.demo.controllers;

import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.User;
import com.example.demo.service.ValidationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

  @Autowired
  private ValidationUser validationUser;

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/api/v1/users")
  public JwtResponse createAuthenticationToken(@RequestBody JwtRequest auth) {
    return JwtResponse.builder()
            .token(validationUser.authenticate(auth))
            .build();
  }

  /*private UserService service;

  @Autowired
  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> list = this.service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById (@PathVariable Long id) {
    User user = this.service.findById(id);
    return ResponseEntity.ok().body(user);
  }

  @PostMapping
  public ResponseEntity<User> insert (@RequestBody User obj) {
    obj = this.service.insertUser(obj);
    return ResponseEntity.ok().body(obj);
  }*/
}
