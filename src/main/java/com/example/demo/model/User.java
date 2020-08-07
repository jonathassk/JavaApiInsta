package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
  @Id
  private UUID id;
  private String name;

  public User(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public User() {}

  public String getName() {
    return name;
  }

  public UUID getId() {
    return id;
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
