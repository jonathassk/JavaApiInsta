package com.example.demo.config;

import com.example.demo.model.Advertising;
import com.example.demo.model.User;
import com.example.demo.repositories.AdvertisingRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Config implements CommandLineRunner {

  private UserRepository userRepository;
  private AdvertisingRepository advertisingRepository;

  @Autowired
  public Config (UserRepository repository, AdvertisingRepository advertisingRepository) {
    this.userRepository = repository;
    this.advertisingRepository = advertisingRepository;
  }

  @Override
  public void run(String... args) {
    User user1 = new User(null, "jonathas");
    User user2 = new User(null, "jonathas sales");
    User user3 = new User(null, "jonathas sales fonseca");
    Advertising adv1 = new Advertising(null, Instant.parse("2020-06-03T20:02:19Z"), user1);
    this.userRepository.saveAll(Arrays.asList(user1, user2, user3 ));
    this.advertisingRepository.saveAll(Arrays.asList(adv1));
  }
}
