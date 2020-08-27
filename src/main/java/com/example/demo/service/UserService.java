package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
  List<User> listUsers ();
  List<User> listUsersByName (String name);

}
