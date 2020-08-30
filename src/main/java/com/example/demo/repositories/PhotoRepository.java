package com.example.demo.repositories;

import com.example.demo.model.Photo;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
  @Query(value = "SELECT * FROM PHOTO where user_id = :userId", nativeQuery = true)
  List<Photo> findByUserId (long userId);
  Photo findById(long id);
}
