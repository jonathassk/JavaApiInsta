package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
  List<User> listUsers ();
  Set<User> listUsersByName (String name);

}
