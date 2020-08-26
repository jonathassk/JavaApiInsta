package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "photo")
public class Photo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String url;
  String description;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
  private Instant moment;
  @ManyToOne
  @JoinColumn(name = "user_ID")
  private User user;

  public Photo () {}

  public Photo (Long id, String url, String description, Instant moment) {
    this.id = id;
    this.url = url;
    this.description = description;
    this.moment = moment;
  }

  public String getDescription() {
    return description;
  }

  public User getUser() {
    return user;
  }

  public Instant getMoment() {
    return moment;
  }

  public Long getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
