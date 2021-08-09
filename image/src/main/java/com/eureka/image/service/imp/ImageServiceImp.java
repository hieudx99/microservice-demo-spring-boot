package com.eureka.image.service.imp;

import com.eureka.image.entity.Image;
import com.eureka.image.repository.ImageRepository;
import com.eureka.image.services.ImageService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImp implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image create(Image image) {
        return imageRepository.saveAndFlush(image);
    }

    @Override
    public Image findById(Long id) throws NotFoundException {
        return imageRepository.findById(id).orElseThrow(() -> new NotFoundException("id: " + id));
    }

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image update(Long id, Image image) throws NotFoundException {
        Image currentImage = imageRepository.findById(id).orElseThrow(() -> new NotFoundException("id: " + id));
        currentImage.setTitle(image.getTitle());
        currentImage.setUrl(image.getUrl());
        return imageRepository.saveAndFlush(currentImage);
    }

    @Override
    public Image delete(Long id) throws NotFoundException {
        Image image = imageRepository.findById(id).orElseThrow(() -> new NotFoundException("id: " + id ));
        imageRepository.deleteById(id);
        return image;
    }
}
