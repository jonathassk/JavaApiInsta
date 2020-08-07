package com.example.demo.config;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Config implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    User user1 = new User(null, "jonathas");
    User user2 = new User(null, "jonathas sales");

    userRepository.saveAll(Arrays.asList(user1, user2));
  }
}
