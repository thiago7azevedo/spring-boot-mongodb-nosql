package com.dianyzethelli.mongodbspringboot.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dianyzethelli.mongodbspringboot.domain.User;
import com.dianyzethelli.mongodbspringboot.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity <List<User>> findAll(){ // mais robusto utilizar ResponseEntity passando a lista dentro <>
		List<User> list = service.findALL();
		return ResponseEntity.ok().body(list); // retorna esse metodo se esta OK e no corpo (body) a lista.
	}

}
