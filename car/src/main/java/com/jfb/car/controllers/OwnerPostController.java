package com.jfb.car.controllers;

import com.jfb.car.dtos.OwnerPostDTO;
import com.jfb.car.services.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class OwnerPostController {

    @Autowired
    public OwnerPostService ownerPostServer;

    @PostMapping
    public ResponseEntity<Void> createOwner(@RequestBody OwnerPostDTO ownerPostDTO) {
        ownerPostServer.createOwner(ownerPostDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
