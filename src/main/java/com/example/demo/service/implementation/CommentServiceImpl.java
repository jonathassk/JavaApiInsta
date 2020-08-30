package com.example.demo.service.implementation;

import com.example.demo.model.Comment;
import com.example.demo.model.Photo;
import com.example.demo.model.User;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.repositories.PhotoRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.CommentService;
import com.example.demo.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

  private UserRepository userRepository;
  private PhotoRepository photoRepository;
  private CommentRepository commentRepository;

  @Autowired
  public CommentServiceImpl(UserRepository userRepository, PhotoRepository photoRepository, CommentRepository commentRepository) {
    this.userRepository = userRepository;
    this.photoRepository = photoRepository;
    this.commentRepository = commentRepository;
  }

  public CommentServiceImpl() {
  }

  @Override
  public Comment createComment(long photoId, long userId, String textComment) {
    User user = this.userRepository.findById(userId);
    Photo photo = this.photoRepository.findById(photoId);
    Comment comment = new Comment();
    comment.setComment(textComment);
    comment.setPhoto(photo);
    comment.setUserComment(user);
    this.commentRepository.save(comment);
    return comment;
  }

  @Override
  public String deleteComment(long id) {
    Comment comment = this.commentRepository.findCommentById(id);
    if (comment == null) {
      throw new ResourceNotFoundException("commentId", id);
    }
    this.commentRepository.delete(comment);
    return "deleted comment";
  }

  @Override
  public Comment updateComment(long id, String comment) {
    return null;
  }
}
