package com.example.demo.service.implementation;

import com.example.demo.dependecies.implementation.SpringAuthenticationWithJwt;
import com.example.demo.model.JwtRequest;
import com.example.demo.service.ValidationUser;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ValidationUserImpl implements ValidationUser {

  private SpringAuthenticationWithJwt jwtTokenUtil;

  @Autowired
  public ValidationUserImpl(SpringAuthenticationWithJwt jwtTokenUtil) {
    this.jwtTokenUtil = jwtTokenUtil;
  }

  @Override
  public String authenticate(JwtRequest user) {
    return jwtTokenUtil.generateToken(user);
  }
}
