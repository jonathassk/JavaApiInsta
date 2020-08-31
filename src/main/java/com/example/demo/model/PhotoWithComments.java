package com.example.demo.model;

import java.util.List;

public class PhotoWithComments {
  Photo photo;
  List<Comment> comments;

  public PhotoWithComments(){}
  public PhotoWithComments(Photo photo, List<Comment> comments) {
    this.photo = photo;
    this.comments = comments;
  }

  public Photo getPhoto() {
    return photo;
  }

  public void setPhoto(Photo photo) {
    this.photo = photo;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }
}
