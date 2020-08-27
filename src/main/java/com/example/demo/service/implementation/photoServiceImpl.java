package com.example.demo.service.implementation;

import com.example.demo.model.Photo;
import com.example.demo.service.PhotoService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@Service
public class photoServiceImpl implements PhotoService  {
  @Override
  public void addPhoto(@RequestBody MultipartFile photo, String description) {

  }
}
