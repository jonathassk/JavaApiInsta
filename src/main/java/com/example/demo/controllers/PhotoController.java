package com.example.demo.controllers;

import com.example.demo.model.Photo;
import com.example.demo.model.UserWithPhotos;
import com.example.demo.service.PhotoService;
import com.example.demo.service.implementation.PhotoServiceImpl;
import com.example.demo.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.ByteArrayInputStream;
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
    Photo response = this.photoService.addPhoto(photo, description, id);
    return this.photoService.setURI(response  .getId());
  }


  @GetMapping(value = "/{id}")
  public ResponseEntity<?> showPhoto (@PathVariable("id") long id) {
    Photo photo = this.photoService.getPhoto(id);
    return ResponseEntity.status(200).body(photo);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletePhoto (@PathVariable("id") long id) {
    this.photoService.removePhoto(id);
    return ResponseEntity.status(200).body("photo removed");
  }
}
