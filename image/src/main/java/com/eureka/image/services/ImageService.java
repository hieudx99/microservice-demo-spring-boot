package com.eureka.image.services;

import com.eureka.image.entity.Image;
import javassist.NotFoundException;

import java.util.List;

public interface ImageService {
    Image create(Image image);

    Image findById(Long id) throws NotFoundException;

    List<Image> findAll();

    Image update (Long id, Image image) throws NotFoundException;

    Image delete (Long id)throws NotFoundException;

}
