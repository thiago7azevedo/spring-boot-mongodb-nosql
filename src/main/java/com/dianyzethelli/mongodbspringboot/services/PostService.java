package com.dianyzethelli.mongodbspringboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianyzethelli.mongodbspringboot.domain.Post;
import com.dianyzethelli.mongodbspringboot.repository.PostRepository;
import com.dianyzethelli.mongodbspringboot.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!!!"));
		}
	
}