package com.example.demo.controllers;

import com.example.demo.model.Follower;
import com.example.demo.model.User;
import com.example.demo.service.FollowerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class FollowerController {
  private FollowerService followerService;

  public FollowerController () {}

  public FollowerController (FollowerService followerService) {
    this.followerService = followerService;
  }


  @GetMapping("/{username}/following")
  @ResponseStatus(HttpStatus.OK)
  public List<User> findFollowings (@PathVariable("username") String username) {
    return null;
  }
}
