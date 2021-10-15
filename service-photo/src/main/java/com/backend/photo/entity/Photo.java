package com.backend.photo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Photo")
@Getter @Setter
public class Photo {
    @Id
    private String id;
    private String photo;
}
