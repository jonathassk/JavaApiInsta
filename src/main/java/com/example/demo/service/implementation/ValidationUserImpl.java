package com.example.demo.service.implementation;

import com.example.demo.dependecies.implementation.SpringAuthenticationWithJwt;
import com.example.demo.model.JwtRequest;
import com.example.demo.service.ValidationUser;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class ValidationUserImpl implements ValidationUser {
  @Autowired
  private SpringAuthenticationWithJwt jwtTokenUtil;

  @Autowired
  private UserDetailsServiceWithJwt userDetailsService;

  @Override
  public String authenticate(JwtRequest auth) {
    UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getUsername());

    if(userDetails.getUsername().equalsIgnoreCase(auth.getUsername())
            && userDetails.getPassword().equalsIgnoreCase(auth.getPassword())) {
      return jwtTokenUtil.generateToken(auth);
    } else {
      return "USER DON'T EXISTS";
    }
  }
}
