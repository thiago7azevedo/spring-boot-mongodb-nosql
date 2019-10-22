package com.dianyzethelli.mongodbspringboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dianyzethelli.mongodbspringboot.domain.Post;
import com.dianyzethelli.mongodbspringboot.resources.util.URL;
import com.dianyzethelli.mongodbspringboot.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity <Post> findById(@PathVariable String id){ // mais robusto utilizar ResponseEntity passando a lista dentro <>
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="")String text){
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);		
		return ResponseEntity.ok().body(list);
	}		
	
}