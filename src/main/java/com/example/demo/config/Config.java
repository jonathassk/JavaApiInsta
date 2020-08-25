package com.example.demo.config;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Config implements CommandLineRunner {

  private UserRepository userRepository;

  @Autowired
  public Config (UserRepository repository) {
    this.userRepository = repository;
  }

  @Override
  public void run(String... args) {
  }
}
