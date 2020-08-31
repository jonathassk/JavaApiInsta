package com.example.demo.service.implementation;

import com.example.demo.model.Follower;
import com.example.demo.model.User;
import com.example.demo.repositories.FollowerRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.FollowerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FollowerServiceImpl implements FollowerService {

  private FollowerRepository followerRepository;
  private UserRepository userRepository;

  public FollowerServiceImpl (FollowerRepository followerRepository, UserRepository userRepository) {
    this.followerRepository = followerRepository;
    this.userRepository = userRepository;
  }

  @Override
  public Follower checkIfFollow(long userId, long followerId) {
    return this.followerRepository.checkFollowerByIds(userId, followerId);
  }

  @Override
  public List<User> findFollowers(long userId) {
    List<Follower> result = this.followerRepository.checkFollowers(userId);
    List<User> users = new ArrayList<>();
    for (Follower follower: result) {
      users.add(this.userRepository.findById(follower.getUserId()));
    }
    return users;
  }

  public String followUser (long id, long followId) {
    if (id == followId) {
      return "id equals follower id";
    }
    Follower isFollowing = this.checkIfFollow(id, followId);
    if (isFollowing != null) {
      this.followerRepository.delete(isFollowing);
      return "stop following";
    } else {
      Follower follower = new Follower();
      follower.setFollowerId(followId);
      follower.setUserId(id);
      this.followerRepository.save(follower);
      return "following";
    }
  }
}
