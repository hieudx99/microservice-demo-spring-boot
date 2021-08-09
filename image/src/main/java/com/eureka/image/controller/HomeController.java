package com.eureka.image.controller;


import com.eureka.image.entity.Image;
import com.eureka.image.repository.ImageRepository;
import com.eureka.image.services.ImageService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private Environment env;

    @Autowired
    private ImageService imageService;

    @PostMapping("/")
    public Image create(@RequestBody Image image) {
        return  imageService.create(image);
    }

    @GetMapping("/")
    public List<Image> findAll() {
         return imageService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Image findById(@PathVariable Long id) throws NotFoundException {
        return imageService.findById(id);
    }

    @PutMapping("/{id}")
    public Image update(@PathVariable Long id, @RequestBody Image image) throws NotFoundException {
        return imageService.update(id, image);
    }

    @DeleteMapping(value = "/{id}")
    public Image delete(@PathVariable Long id) throws NotFoundException {
        return imageService.delete(id);
    }
}
