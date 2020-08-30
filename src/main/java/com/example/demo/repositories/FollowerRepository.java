package com.example.demo.repositories;

import com.example.demo.model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FollowerRepository extends JpaRepository<Follower, Long> {
  @Query(value = "SELECT * FROM FOLLOWERS WHERE FOLLOWER_ID = :follower_id AND USER_ID = :user_id", nativeQuery = true)
  Follower checkFollowerByIds(long user_id, long follower_id);
  @Query(value = "SELECT COUNT (*) AS FOLLOWERS FROM FOLLOWERS WHERE FOLLOWER_ID = :user_id;", nativeQuery = true)
  Follower checkFollowingsByIds(long user_id);
  @Query(value = "SELECT COUNT (*) AS FOLLOWERS FROM FOLLOWERS WHERE FOLLOWER_ID = :user_id;", nativeQuery = true)
  Follower checkFollowerByIds(long user_id);
}