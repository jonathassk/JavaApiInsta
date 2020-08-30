package com.example.demo.controllers;

import com.example.demo.model.Comment;
import com.example.demo.service.implementation.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
  private CommentServiceImpl commentService;

  public CommentController() {}
  @Autowired
  public CommentController(CommentServiceImpl commentService) {
    this.commentService = commentService;
  }

  @PostMapping("/photo={photoid}&user={userid}")
  @ResponseStatus(HttpStatus.OK)
  public Comment postMapping (@PathVariable("photoid") long photoId, @PathVariable("userid") long userId,@RequestBody Comment comment) {
    String commentText = comment.getComment();
    Comment response = this.commentService.createComment(photoId, userId, commentText);
    return response;
  }
}
