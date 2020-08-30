package com.example.demo.service;

import com.example.demo.model.Follower;
import com.example.demo.model.User;

import java.util.List;

public interface FollowerService {
  Follower checkIfFollow (long userId, long followerId);
  List<User> findFollowers (long userId);
  List<User> findFollowings (String username);
}
