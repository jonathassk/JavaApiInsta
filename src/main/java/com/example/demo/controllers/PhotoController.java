package com.example.demo.controllers;

import com.example.demo.model.Photo;
import com.example.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/photos")
public class PhotoController {

  private final PhotoService photoService;

  @Autowired
  public PhotoController(PhotoService photoService) {
    this.photoService = photoService;
  }

  @GetMapping
  public List<Photo> ListPhotos () {
    return this.photoService.listPhotoHome();
  }

  @PostMapping("/upload")
  public void addPhoto (@RequestParam("file") MultipartFile photo, String description, @RequestParam("id") long id) {
    this.photoService.addPhoto(photo, description, id);
  }
}
