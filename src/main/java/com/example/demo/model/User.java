package com.example.demo.model;

import com.example.demo.model.enums.UsersStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotNull
  @Length(min = 3, max = 100, message = "name should be greather than 3 characters")
  private String name;
  @NotNull
  @Length(min = 3, max = 50, message = "username should be greather than 3 characters")
  private String username;
  @NotNull
  private String password;

  private UsersStatus status;
  @Email(message = "Email should be valid")
  private String email;
  private String description;
  @OneToMany(mappedBy = "photographer")
  @JsonIgnore
  private List<Photo> photoList;
  @OneToMany(mappedBy = "userComment")
  private List<Comment> photoCommentList;

  public User () {
    photoList = new ArrayList<>();
  }

  public User(long id, String name, String username, String password, String description, UsersStatus status, String email, List<Comment> commentList) {
    this.description = description;
    this.email = email;
    this.status = status;
    this.id = id;
    this.name = name;
    this.password = password;
    this.username = username;
    this.photoCommentList = commentList;
    photoList = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UsersStatus getStatus() {
    return status;
  }

  public String getEmail() {
    return email;
  }

  public void setStatus(UsersStatus status) {
    this.status = status;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhotoList(List<Photo> photoList) {
    this.photoList = photoList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User person = (User) o;
    return Objects.equals(id, person.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Person{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
