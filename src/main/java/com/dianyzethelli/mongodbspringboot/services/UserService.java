package com.dianyzethelli.mongodbspringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianyzethelli.mongodbspringboot.domain.User;
import com.dianyzethelli.mongodbspringboot.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findALL(){
		return repo.findAll();
	}

}
