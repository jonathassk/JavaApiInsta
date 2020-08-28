package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface FollowerService {
  boolean checkIfFollow (long userId, long followerId);
  List<User> findFollowers (long userId);
  List<User> findFollowings (long UserId);
}
