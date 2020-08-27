package com.example.demo.service.implementation;

import com.example.demo.model.Photo;
import com.example.demo.repositories.PhotoRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

  private PhotoRepository photoRepository;
  private UserRepository userRepository;

  public PhotoServiceImpl () {}
  @Autowired
  public PhotoServiceImpl (PhotoRepository photoRepository, UserRepository userRepository) {
    this.photoRepository = photoRepository;
    this.userRepository = userRepository;
  }

  @Override
  public void addPhoto(MultipartFile photo, String description, long id) {
    Photo post = new Photo();
    post.setDescription(description);
    post.setMoment(Instant.now());
    post.setUrl("url");
    post.setPhotographer(this.userRepository.findById(id));
    this.photoRepository.save(post);
  }

  @Override
  public List<Photo> listPhotoHome() {
    return this.photoRepository.findAll();
  }

  @Override
  public List<Photo> listByUserId(long id) {
    return this.photoRepository.findByUserId(id);
  }


}
