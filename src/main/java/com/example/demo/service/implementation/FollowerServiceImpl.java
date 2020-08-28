package com.example.demo.service.implementation;

import com.example.demo.model.Follower;
import com.example.demo.model.User;
import com.example.demo.repositories.FollowerRepository;
import com.example.demo.service.FollowerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowerServiceImpl implements FollowerService {

  private FollowerRepository followerRepository;

  public FollowerServiceImpl (FollowerRepository followerRepository) {
    this.followerRepository = followerRepository;
  }

  @Override
  public Follower checkIfFollow(long userId, long followerId) {
    return this.followerRepository.checkFollowerByIds(userId, followerId);
  }

  @Override
  public List<User> findFollowers(long userId) {
    return null;
  }

  @Override
  public List<User> findFollowings(long UserId) {
    return null;
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
