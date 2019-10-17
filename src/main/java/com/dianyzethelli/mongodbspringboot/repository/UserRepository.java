package com.dianyzethelli.mongodbspringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dianyzethelli.mongodbspringboot.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> { // herda da classe mongo, ou extends

}
