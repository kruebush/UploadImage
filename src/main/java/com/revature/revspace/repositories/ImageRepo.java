package com.revature.revspace.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.revature.revspace.models.Image;

public interface ImageRepo extends JpaRepository<Image, Long> {
	Optional <Image>findByName(String Name);	
	
}
