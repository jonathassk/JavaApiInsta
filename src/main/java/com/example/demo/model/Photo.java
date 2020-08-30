package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "photo")
public class Photo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String name;
  String fileType;
  String url;
  byte[] data;
  String description;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
  private Instant moment;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User photographer;
  @OneToMany
  private List<Comment> comments;

  public Photo() {}

  public Photo(String name, String fileType, String description, byte[] data, Instant moment) {
    this.id = id;
    this.fileType = fileType;
    this.name = name;
    this.data = data;
    this.url = url;
    this.description = description;
    this.moment = moment;
  }

  public String getDescription() {
    return description;
  }

  public User getUser() {
    return photographer;
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

  public String getName() {
    return name;
  }

  public String getFileType() {
    return fileType;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setPhotographer(User photographer) {
    this.photographer = photographer;
  }

  public void setName(String name) {
    this.name = name;
  }
}
