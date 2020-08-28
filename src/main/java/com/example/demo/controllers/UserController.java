package com.example.demo.controllers;

import com.example.demo.exceptions.UserAlreadyExistAuthenticationException;
import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.Photo;
import com.example.demo.model.User;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private final AuthenticationService authenticationService;
  private final UserServiceImpl userService;

  @Autowired
  public UserController (AuthenticationService authenticationService, UserServiceImpl userService) {
    this.authenticationService = authenticationService;
    this.userService = userService;
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/auth")
  public JwtResponse createAuthenticationToken(@RequestBody JwtRequest auth) {
    return this.authenticationService.auth(auth);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/create")
  public JwtResponse saveAuthenticationToken(@RequestBody JwtRequest auth) throws UserAlreadyExistAuthenticationException {
    return this.authenticationService.create(auth);
  }

  @ResponseStatus(HttpStatus.OK)
  @PostMapping("/list")
  public List<User> listByName (@RequestBody User body) {
    return this.userService.listUsersByName(body.getName());
  }



  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/follow/user={user}&follow={follow}")
  public String FollowUser (@PathVariable("user") long userId, @PathVariable("follow") long followId) {
    return this.userService.followerUser(userId, followId);
  }
}
