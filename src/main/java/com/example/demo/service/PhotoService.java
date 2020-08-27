package com.example.demo.service;

import com.example.demo.model.Photo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoService {
  void addPhoto(MultipartFile file, String description, long id);
  List<Photo> listPhotoHome ();

  List<Photo> listByUserId (long id);
}
