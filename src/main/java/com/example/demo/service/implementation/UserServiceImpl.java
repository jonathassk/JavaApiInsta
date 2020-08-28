package com.example.demo.service.implementation;

import com.example.demo.model.Photo;
import com.example.demo.model.User;
import com.example.demo.repositories.PhotoRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.FollowerService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private PhotoRepository photoRepository;
  private FollowerServiceImpl followerService;

  public UserServiceImpl () {}
  @Autowired
  public UserServiceImpl (UserRepository userRepository, PhotoRepository photoRepository, FollowerServiceImpl followerService) {
    this.userRepository = userRepository;
    this.photoRepository = photoRepository;
    this.followerService = followerService;
  }

  @Override
  public List<User> listUsers() {
    return this.userRepository.findAll();
  }

  @Override
  public List<User> listUsersByName(String name) {
    return this.userRepository.findByName(name);
  }

  public List<Photo> photoList(long id) { return this.photoRepository.findByUserId(id); }

  public String followerUser (long userId, long followId) {
    return this.followerService.followUser(userId, followId);
  }

}
