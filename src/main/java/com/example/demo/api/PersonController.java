package com.example.demo.api;

import com.example.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/users")
@RestController
public class PersonController {

  @GetMapping
  public ResponseEntity<User> findAll() {
    User u = new User(1L, "jonathas");
    return ResponseEntity.ok().body(u);
  }
}
