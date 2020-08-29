package com.example.demo.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
  private static final long serialVersionUID = 1L;
  public ResourceNotFoundException (String type, Object id) {
    super("Resource not found: " + type + " " + id);
  }
}
