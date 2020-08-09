package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "Advertisings")
public class Advertising implements Serializable {
  private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "id")
  private Long id;

 @Column(name = "moment")
  private Instant moment;

  @ManyToOne
  @JoinColumn(name = "user_ID")
  private User client;

  public Advertising () {}
  public Advertising (Long id, Instant moment, User client) {
    this.id = id;
    this.moment = moment;
    this.client = client;
  }

  public Long getId() {
    return id;
  }

  public Instant getMoment() {
    return moment;
  }

  public User getClient() {
    return client;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public void setClient(User client) {
    this.client = client;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Advertising that = (Advertising) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
