package com.example.demo.controllers;

import com.example.demo.model.Photo;
import com.example.demo.service.PhotoService;
import com.example.demo.service.implementation.PhotoServiceImpl;
import com.example.demo.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/photos")
public class PhotoController {

  private final PhotoServiceImpl photoService;
  private final UserServiceImpl userService;

  @Autowired
  public PhotoController (PhotoServiceImpl photoService, UserServiceImpl userService) {
    this.photoService = photoService;
    this.userService = userService;
  }

  @GetMapping
  public List<Photo> ListPhotos () {
    return this.photoService.listPhotoHome();
  }

  @PostMapping("/upload") //id = id do user
  public String addPhoto (@RequestParam("file") MultipartFile photo, String description, @RequestParam("id") long id) {
    Photo photoResponse = this.photoService.addPhoto(photo, description, id);
    String fileDownloadUri = this.photoService.setURI(id);

    return fileDownloadUri;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/user={id}")
  public List<Photo> listPhotos (@PathVariable("id") long id) {
    return this.userService.photoList(id);
  }
}
