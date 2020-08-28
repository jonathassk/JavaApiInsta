package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Followers")
public class Follower {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long userId;
  private long followerId;

  public Follower () {}
  public Follower (long id, long userId, long followerId) {
    this.id = id;
    this.userId = userId;
    this.followerId = followerId;
  }

  public long getFollowerId() {
    return followerId;
  }

  public long getUserId() {
    return userId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setFollowerId(long followerId) {
    this.followerId = followerId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Follower follower = (Follower) o;
    return userId == follower.userId &&
            followerId == follower.followerId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, followerId);
  }
}
