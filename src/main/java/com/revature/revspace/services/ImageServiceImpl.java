package com.revature.revspace.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.revspace.models.Image;

import com.revature.revspace.repositories.ImageRepository;

public class ImageServiceImpl implements ImageService {

		@Autowired
		ImageRepository imageRepo;
		
		@Autowired
		UserService userService;

	public Optional<Image> getImageName(String Name) {
		return getImageName(Name);
	}

}
