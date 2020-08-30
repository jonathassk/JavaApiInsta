package com.example.demo.service;

import com.example.demo.model.Comment;

public interface CommentService {
  Comment createComment (long photoId, long userId, String description);
}
