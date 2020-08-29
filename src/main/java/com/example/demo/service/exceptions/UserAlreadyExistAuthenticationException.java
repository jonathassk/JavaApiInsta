package com.example.demo.service.exceptions;

import javax.security.sasl.AuthenticationException;

public class UserAlreadyExistAuthenticationException extends AuthenticationException {
  public UserAlreadyExistAuthenticationException(final String msg) {
    super(msg);
  }
}
