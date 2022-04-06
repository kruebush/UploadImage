package com.revature.revspace.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.revspace.models.Image;
import com.revature.revspace.repositories.ImageRepo;

public class ImageServiceImpl implements ImageService {

		@Autowired
		ImageRepo imageRepo;

	public Optional<Image> getImageName(String Name) {
		// TODO Auto-generated method stub
		return getImageName(Name);
	}

}
