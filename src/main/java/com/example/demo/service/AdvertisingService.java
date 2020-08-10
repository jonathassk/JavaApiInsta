package com.example.demo.service;

import com.example.demo.model.Advertising;
import com.example.demo.repositories.AdvertisingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdvertisingService {
  private AdvertisingRepository repository;

  @Autowired
  public AdvertisingService (AdvertisingRepository advertisingRepository) {
    this.repository = advertisingRepository;
  }

  public List<Advertising> findAll () {
    return this.repository.findAll();
  }

  public Advertising findById (Long id) {
    Optional<Advertising> advertising = this.repository.findById(id);
    return advertising.get();
  }
}
