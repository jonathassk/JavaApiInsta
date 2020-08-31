package com.example.demo.controllers;

import com.example.demo.model.Follower;
import com.example.demo.model.User;
import com.example.demo.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class FollowerController {
  private FollowerService followerService;

  public FollowerController () {}
 @Autowired
  public FollowerController (FollowerService followerService) {
    this.followerService = followerService;
  }


  @GetMapping("/{id}/following")
  @ResponseStatus(HttpStatus.OK)
  public List<User> findFollowers (@PathVariable("id") long id) {
    return this.followerService.findFollowers(id);
  }
}
