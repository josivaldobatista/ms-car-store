package com.jfb.car.controllers;

import com.jfb.car.dtos.CarPostDTO;
import com.jfb.car.services.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales/cars")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @GetMapping
    public ResponseEntity<List<CarPostDTO>> getCarSales() {
        return ResponseEntity.ok(carPostService.getCarSales());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id) {
        carPostService.changeCarSale(carPostDTO, Long.valueOf(id));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable("id") String id) {
        carPostService.removeCarSale(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
