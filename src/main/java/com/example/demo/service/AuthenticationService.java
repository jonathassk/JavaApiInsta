package com.example.demo.service;

import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;

public interface AuthenticationService {
  JwtResponse auth(JwtRequest jwtRequest);

  JwtResponse create(JwtRequest jwtRequest);
}
