package com.example.demo.exceptions;

import javax.security.sasl.AuthenticationException;

public class UserAlreadyExistAuthenticationException extends AuthenticationException {
  public UserAlreadyExistAuthenticationException(final String msg) {
    super(msg);
  }
}
