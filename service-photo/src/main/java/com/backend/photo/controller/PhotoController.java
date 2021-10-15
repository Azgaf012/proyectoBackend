package com.backend.photo.controller;

import com.backend.photo.entity.Photo;
import com.backend.photo.service.PhotoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/photo")
public class PhotoController {

    @Autowired
    private PhotoServiceImpl photoService;

    @GetMapping(value="{id}")
    public ResponseEntity<Photo> getCustomer(@PathVariable("id") String id){

        Photo photo = photoService.getPhoto(id);

        if(photo==null) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(photo);
    }

    @PostMapping
    public ResponseEntity<Photo> createCustomer(@RequestBody Photo photo){
        Photo photoDB = photoService.createPhoto(photo);
        return ResponseEntity.status(HttpStatus.CREATED).body(photoDB);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Photo> updateCustomer(@PathVariable("id") String id,@RequestBody Photo photo){
        photo.setId(id);
        Photo photoUpdate = photoService.updatePhoto(photo);

        if(photoUpdate == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(photoUpdate);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Photo> updateCustomer(@PathVariable("id") String id){

        Photo photoDelete = photoService.deletePhoto(id);

        if(photoDelete == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(photoDelete);
    }


}
