/*package com.example.demo.service.implementation;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  private UserRepository repository;
  private BCryptPasswordEncoder passwordEncrypter;



  @Autowired
  public UserService (UserRepository repository, BCryptPasswordEncoder passwordEncrypter) {
    this.repository = repository;
    this.passwordEncrypter = passwordEncrypter;
  }

  public List<User> findAll () {
    return this.repository.findAll();
  }

  public User findById (Long id) {
    Optional<User> user = this.repository.findById(id);
    return user.get();
  }

  public User insertUser (User user) {
    String pwd = user.getPassword();
    String encryptedPwd = passwordEncrypter.encode(pwd);
    user.setPassword(encryptedPwd);
    return this.repository.save(user);
  }
}
*/