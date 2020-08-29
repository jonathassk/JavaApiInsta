package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
  List<User> listUsersByName (String name);
  User updateUser (User user);
  String deleteUser (long id);
}
