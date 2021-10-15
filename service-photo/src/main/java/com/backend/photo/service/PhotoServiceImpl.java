package com.backend.photo.service;

import com.backend.photo.entity.Photo;
import com.backend.photo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements IPhotoService{

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public Photo createPhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public Photo getPhoto(String id) {
        return photoRepository.findById(id).orElse(null);
    }

    @Override
    public Photo updatePhoto(Photo photo) {
        Photo photoDB = this.getPhoto(photo.getId());

        if(photoDB==null) return null;

        photoDB.setPhoto(photo.getPhoto());

        return photoRepository.save(photoDB);
    }

    @Override
    public Photo deletePhoto(String id) {
        Photo photoDB = this.getPhoto(id);

        if(photoDB==null) return null;

        photoDB.setPhoto("");

        return photoRepository.save(photoDB);
    }
}
