package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
  int insertPerson(UUID id, User person);

  default int insertPerson (User person) {
    UUID id = UUID.randomUUID();
    return insertPerson(id, person);
  }

  List<User> selectAllPeople ();

  int deletePersonById (UUID id);

  int updatePersonById (UUID id, User person);

  Optional<User> selectPersonById (UUID id);
}
