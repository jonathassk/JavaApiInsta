package com.example.demo.model;

import java.util.List;

public class UserWithPhotos {
  private User user;
  private List<Photo> photo;

  public UserWithPhotos() {
  }

  public UserWithPhotos(User user, List<Photo> photo) {
    this.user = user;
    this.photo = photo;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Photo> getPhoto() {
    return photo;
  }

  public void setPhoto(List<Photo> photo) {
    this.photo = photo;
  }
}
