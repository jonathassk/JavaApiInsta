package com.example.demo.model;

import com.example.demo.model.enums.UsersStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtRequest implements UserDetails {
  private String username;
  private String password;
  private String name;
  private String description;
  private UsersStatus status;
  private String email;
  private Boolean enabled;
  private List<JwtRoles> roles;

  public JwtRequest() {
  }

  public JwtRequest(String username, String password, Boolean enabled, List<JwtRoles> roles, String name, String description, UsersStatus status, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.status = status;
    this.enabled = enabled;
    this.roles = roles;
    this.description = description;
    this.name = name;
  }

  public String getUsername() {
    return this.username;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public String getDescription() {
    return description;
  }

  public String getName() {
    return name;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setStatus(UsersStatus status) {
    this.status = status;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public List<JwtRoles> getRoles() {
    return roles;
  }

  public void setRoles(List<JwtRoles> roles) {
    this.roles = roles;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.roles.stream().map(authority -> new SimpleGrantedAuthority(authority.name())).collect(Collectors.toList());
  }
}
