package com.example.demo.dependecies;

import com.example.demo.model.JwtRequest;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Date;

public interface SpringAuthentication {
  Claims getAllClaimsFromToken(String token);

  String getUsernameFromToken(String token);

  Date getExpirationDateFromToken(String token);

  String generateToken(JwtRequest user);

  Boolean validateToken(String token);

  Boolean validateToken(String token, UserDetails userDetails);
}
