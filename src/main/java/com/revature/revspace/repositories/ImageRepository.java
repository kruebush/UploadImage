package com.revature.revspace.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.revature.revspace.models.Image;
import com.revature.revspace.models.Post;
import com.revature.revspace.models.User;

public interface ImageRepository extends JpaRepository<Image, Long> {
	Optional<Image> findByName(String name);
}
