package com.dianyzethelli.mongodbspringboot.services;

import java.util.Date;
import java.util.List;
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
	// método criado para atrelar com o repositario onde temos um método igual
	public List<Post> findByTitle(String text){		
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // transforma milessegundos em 24 horas.
		return repo.fullSearch(text, minDate, maxDate);
		
	}
}