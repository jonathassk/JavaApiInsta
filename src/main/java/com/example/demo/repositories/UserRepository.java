package com.example.demo.repositories;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
  User findById(long id);
  User findByEmail(String email);
  List<User> findByName(String name);
}
