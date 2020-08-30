package com.example.demo.service.implementation;

import com.example.demo.model.Photo;
import com.example.demo.model.User;
import com.example.demo.repositories.PhotoRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.PhotoService;
import com.example.demo.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

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
  public Photo addPhoto(MultipartFile photo, String description, long id) {
    String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
    Photo post = new Photo(fileName, photo.getContentType(), description ,fileName.getBytes(), Instant.now());
    User user = this.userRepository.findById(id);
    if (user == null) {
      throw new ResourceNotFoundException("userId", id);
    }
    post.setPhotographer(user);
    this.photoRepository.save(post);
    return post;
  }

  @Override
  public List<Photo> listPhotoHome() {
    return this.photoRepository.findAll();
  }


  @Override
  public String setURI(long id) {
    Photo photo = this.photoRepository.findById(id);
    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/download-file/")
            .path(Long.toString(photo.getId()))
            .toUriString();
    return fileDownloadUri;
  }

  @Override
  public List<Photo> listByUserId(long id) {
    return this.photoRepository.findByUserId(id);
  }

}
