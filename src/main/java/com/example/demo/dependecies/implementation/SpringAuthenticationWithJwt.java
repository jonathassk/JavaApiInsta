package com.example.demo.dependecies.implementation;

import com.example.demo.dependecies.SpringAuthentication;
import com.example.demo.model.JwtRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class SpringAuthenticationWithJwt implements SpringAuthentication {
  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiration}")
  private String expiration;

  @Override
  public Claims getAllClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(Base64.getEncoder().encodeToString(secret.getBytes())).parseClaimsJws(token).getBody();
  }

  @Override
  public String getUsernameFromToken(String token) {
    return getAllClaimsFromToken(token).getSubject();
  }

  @Override
  public Date getExpirationDateFromToken(String token) {
    return getAllClaimsFromToken(token).getExpiration();
  }

  private Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(new Date());
  }

  @Override
  public String generateToken(JwtRequest user) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("role", user.getRoles());
    return String.format("Bearer %s", doGenerateToken(claims, user.getUsername()));
  }

  private String doGenerateToken(Map<String, Object> claims, String username) {
    Long expirationTimeLong = Long.parseLong(expiration);

    final Date createdDate = new Date();
    final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong * 1000);
    try {
      return Jwts.builder()
              .setClaims(claims)
              .setSubject(username)
              .setIssuedAt(createdDate)
              .setExpiration(expirationDate)
              .signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encodeToString(secret.getBytes()))
              .compact();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return null;
  }

  @Override
  public Boolean validateToken(String token) {
    return !isTokenExpired(token);
  }

  @Override
  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = getUsernameFromToken(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

}
