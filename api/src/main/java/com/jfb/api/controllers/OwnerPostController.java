package com.jfb.api.controllers;

import com.jfb.api.dto.OwnerPostDTO;
import com.jfb.api.services.OwnerPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    private static final Logger LOG = LoggerFactory.getLogger(OwnerPostController.class);

    @PostMapping("/owner")
    public ResponseEntity<Void> createOwnerCar(@RequestBody OwnerPostDTO ownerPostDTO) {
        LOG.info("Creating a new OwnerPost: {}", OwnerPostDTO.class);
        ownerPostService.createOwnerCar(ownerPostDTO);
        return ResponseEntity.ok().build();
    }
}
