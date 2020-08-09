package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "client")
  private List<Advertising> advertisings;

  public User(Long id, String name) {
    this.id = id;
    this.name = name;
    advertisings = new ArrayList<>();
  }

  public User() {super();
    advertisings = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }

  public List<Advertising> getAdvertisings() {
    return advertisings;
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
