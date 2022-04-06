package com.revature.revspace.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.revspace.models.Image;

@Service
public interface ImageService {
	public Optional <Image>getImageName(String Name);
	
	
}
