package com.example.demo.repositories;

import com.example.demo.model.Photo;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
  @Query(value = "SELECT * FROM PHOTO where user_id = :userId", nativeQuery = true)
  List<Photo> findByUserId (long userId);
}
