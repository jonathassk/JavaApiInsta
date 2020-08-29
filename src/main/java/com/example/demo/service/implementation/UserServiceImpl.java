package com.example.demo.service.implementation;

import com.example.demo.model.Photo;
import com.example.demo.model.User;
import com.example.demo.repositories.PhotoRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private PhotoRepository photoRepository;
  private FollowerServiceImpl followerService;
  private Object BCryptPasswordEncoder;

  public UserServiceImpl () {}
  @Autowired
  public UserServiceImpl (UserRepository userRepository, PhotoRepository photoRepository, FollowerServiceImpl followerService) {
    this.userRepository = userRepository;
    this.photoRepository = photoRepository;
    this.followerService = followerService;
  }

  @Override
  public List<User> listUsersByName(String name) {
    return this.userRepository.findByName(name);
  }

  @Override
  public User updateUser(User updatedUser) {
    User user = this.userRepository.findByUsername(updatedUser.getUsername());
    if (user == null) {
      throw new ObjectNotFoundException("Not found: User with username: ",updatedUser.getUsername());
    } else if (this.userRepository.findByUsername(updatedUser.getUsername()) != null || this.userRepository.findByEmail(updatedUser.getEmail()) != null) {
      throw new IllegalArgumentException("exists an user with this username or email");
    } else {
      if (updatedUser.getPassword() != null) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(updatedUser.getPassword()));
      }
      if (updatedUser.getEmail() != null) {
        user.setEmail(updatedUser.getEmail());
      }
      if (updatedUser.getName() != null) {
        user.setName(updatedUser.getName());
      }
      if (updatedUser.getUsername() != null) {
        user.setUsername(updatedUser.getUsername());
      }
    }
    return this.userRepository.save(user);
  }

  @Override
  public String deleteUser(long id) {
    User user = this.userRepository.findById(id);
    if (user != null) {
      this.userRepository.delete(user);
      return "deleted user.";
    } else {
      throw new ObjectNotFoundException("Not found: User with id: ", Long.toString(user.getId()));
    }
  }


  public List<Photo> photoList(long id) { return this.photoRepository.findByUserId(id); }

  public String followerUser (long userId, long followId) {
    return this.followerService.followUser(userId, followId);
  }

}
