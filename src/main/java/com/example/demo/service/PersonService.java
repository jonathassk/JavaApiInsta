package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
  private final PersonDao personDao;

  @Autowired
  public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
    this.personDao = personDao;
  }

  public int addPerson(User person) {
    return personDao.insertPerson(person);
  }

  public List<User> getAllPerson () {
    return personDao.selectAllPeople();
  }

  public Optional<User> getPersonById (UUID id) {
    return personDao.selectPersonById(id);
  }
}
