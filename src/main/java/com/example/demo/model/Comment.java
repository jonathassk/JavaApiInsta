package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotNull
  @Length(min = 3, max = 100, message = "name should be greater than 3 characters")
  private String comment;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User userComment;
  @ManyToOne
  @JoinColumn(name = "photo_id")
  @JsonIgnore
  private Photo photo;

  public Comment() {}
  public Comment(long id, String comment, User userComment) {
    this.id = id;
    this.comment = comment;
    this.userComment = userComment;
  }

  public long getId() {
    return id;
  }

  public String getComment() {
    return comment;
  }

  public Photo getPhoto() {
    return photo;
  }

  public User getUserComment() {
    return userComment;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public void setUserComment(User userComment) {
    this.userComment = userComment;
  }

  public void setPhoto(Photo photo) {
    this.photo = photo;
  }
}
