package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

  private UserRepository repository;

  @Autowired
  public UserService (UserRepository repository) {
    this.repository = repository;
  }

  public List<User> findAll () {
    return this.repository.findAll();
  }
}
