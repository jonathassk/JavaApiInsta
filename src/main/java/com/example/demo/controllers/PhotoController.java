package com.example.demo.controllers;

import com.example.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/photos")
public class PhotoController {

  private final PhotoService photoService;

  @Autowired
  public PhotoController (PhotoService photoService) {
    this.photoService = photoService;
  }

  @PostMapping("/upload")
  public void addPhoto (@RequestParam("file") MultipartFile photo, @RequestBody String description) {
    this.photoService.addPhoto(photo, description);
  }
}
