package com.example.demo.model.enums;

public enum UsersStatus {
  PUBLIC_USER(1),
  PRIVATE_USER(2);

  private int code;

  private UsersStatus (int code) {
    this.code = code;
  }

  public int getCode () {
    return code;
  }

  public static UsersStatus valueOf(int code) {
    for (UsersStatus value : UsersStatus.values()) {
      if (value.getCode() == code) {
        return value;
      }
    }
    throw new IllegalArgumentException("invalid UserStatus code!");
  }
}
