package com.example.demo.controllers;

import com.example.demo.model.UserWithPhotos;
import com.example.demo.service.exceptions.UserAlreadyExistAuthenticationException;
import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.User;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/create")
  public JwtResponse saveAuthenticationToken(@RequestBody JwtRequest auth) throws UserAlreadyExistAuthenticationException {
    return this.authenticationService.create(auth);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/list/{name}")
  public List<User> listByName (@PathVariable("name") String name) {
    return this.userService.listUsersByName(name);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/follow/user={user}&follow={follow}")
  public String FollowUser (@PathVariable("user") long userId, @PathVariable("follow") long followId) {
    return this.userService.followerUser(userId, followId);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping({"/{myId}/user/{id}"})
  public UserWithPhotos getUser (@PathVariable("id") long id, @PathVariable("myId") long myId) {
    return this.userService.readUser(id, myId);
  }

  @ResponseStatus(HttpStatus.OK)
  @PatchMapping("/update")
  public User updateUser (@RequestBody User updatedUser) {
    return this.userService.updateUser(updatedUser);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/delete/{id}")
  public String deleteUser (@PathVariable("id") long id) {
    return this.userService.deleteUser(id);
  }
}
