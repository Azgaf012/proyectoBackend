package com.backend.photo.service;

import com.backend.photo.entity.Photo;

public interface IPhotoService {
    Photo createPhoto(Photo photo);
    Photo getPhoto(String id);
    Photo updatePhoto(Photo photo);
    Photo deletePhoto(String id);
}
