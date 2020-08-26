package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.security.core.GrantedAuthority;

public enum JwtRoles implements GrantedAuthority {
  ROLE_USER("ROLE_USER"),
  ROLE_ADMIN("ROLE_ADMIN");

  private final String value;

  JwtRoles(String value) {
    this.value = value;
  }

  @Override
  public String getAuthority() {
    return value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  public static JwtRoles fromValue(String text) {
    for (JwtRoles b : JwtRoles.values()) {
      if(String.valueOf(b.value).equalsIgnoreCase(text)) {
        return b;
      }
    }
    return null;
  }
}
