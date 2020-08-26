package com.example.demo.service;

import com.example.demo.model.JwtRequest;

public interface ValidationUser {
  String authenticate(JwtRequest auth);
}
