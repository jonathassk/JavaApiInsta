package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

  private static List<User> DB = new ArrayList<>();

  @Override
  public int insertPerson (UUID id, User person) {
    DB.add(new User(id, person.getName()));
    return 1;
  }

  @Override
  public List<User> selectAllPeople() {
    return DB;
  }

  @Override
  public int deletePersonById(UUID id) {
    Optional<User> person = selectPersonById(id);
    if (person.isEmpty()) {
      return 0;
    }
    DB.remove(person.get());
    return 1;
  }

  @Override
  public int updatePersonById(UUID id, User person) {
    return selectPersonById(id).map(p -> {
      int indexOfPersonToDelete = DB.indexOf(person);
      if (indexOfPersonToDelete >= 0) {
        DB.set(indexOfPersonToDelete, person);
        return 1;
      }
      return 0;
    }).orElse(0);
  }


  @Override
  public Optional<User> selectPersonById(UUID id) {
    return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
  }


}
