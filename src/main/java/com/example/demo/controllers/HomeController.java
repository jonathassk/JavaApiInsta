package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @GetMapping("/home")
  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize("hasRole('USER')")
  public String home() {
    return ("<h1>home</h1>");
  }
}
