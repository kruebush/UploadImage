package com.revature.revspace.controllers;


import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.revature.revspace.models.Image;
import com.revature.revspace.repositories.ImageRepository;
import com.revature.revspace.util.ImageUtility;
import com.revature.revspace.utils.ImageUploadResponse;


@RestController
//@CrossOrigin(origins = "http://localhost:8082") open for specific port
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping (path ="image")
public class ImageController {

  @Autowired
  ImageRepository imageRepository;

  @PostMapping("/upload")
  public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file)
          throws IOException {

      imageRepository.save(Image.builder()
              .name(file.getOriginalFilename())
              .type(file.getContentType())
              .image(ImageUtility.compressImage(file.getBytes())).build());
      return ResponseEntity.status(HttpStatus.OK)
              .body(new ImageUploadResponse("Image uploaded successfully: " +
                      file.getOriginalFilename()));
  }

  @GetMapping("{name}")
  public Image getImageDetails(@PathVariable("name") String name) throws IOException {

      final Optional<Image> dbImage = imageRepository.findByName(name);

      return Image.builder()
              .name(dbImage.get().getName())
              .type(dbImage.get().getType())
              .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
  }

  @GetMapping("/get/{name}")
  public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {

      final Optional<Image> dbImage = imageRepository.findByName(name);

      return ResponseEntity
              .ok()
              .contentType(MediaType.valueOf(dbImage.get().getType()))
              .body(ImageUtility.decompressImage(dbImage.get().getImage()));
  }
}