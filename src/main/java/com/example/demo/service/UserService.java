package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserWithPhotos;

import java.util.List;
import java.util.Optional;

public interface UserService {
  List<User> listUsersByName (String name);
  User updateUser (User user);
  String deleteUser (long id);
  UserWithPhotos readUser (long id, long myId);
  User changeVisibility (long id);
}
