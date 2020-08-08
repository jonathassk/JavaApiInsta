package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public User findById (Long id) {
    Optional<User> user = this.repository.findById(id);
    return user.get();
  }
}
