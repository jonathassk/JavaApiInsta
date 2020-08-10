package com.example.demo.api;

import com.example.demo.model.Advertising;
import com.example.demo.model.User;
import com.example.demo.service.AdvertisingService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/advertisings")
public class AdvertisingController {
  private AdvertisingService service;

  @Autowired
  public AdvertisingController (AdvertisingService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<Advertising>> findAll () {
    List<Advertising> ads = this.service.findAll();
    return ResponseEntity.ok().body(ads);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Advertising> findById (@PathVariable Long id) {
    Advertising ads = this.service.findById(id);
    return ResponseEntity.ok().body(ads);
  }
}
