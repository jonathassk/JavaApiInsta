package com.example.demo.repositories;

import com.example.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
  Comment findCommentById(long id);
  List<Comment> findCommentsByPhotoId(long id);
}
