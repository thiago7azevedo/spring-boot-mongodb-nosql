package com.dianyzethelli.mongodbspringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dianyzethelli.mongodbspringboot.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { // herda da classe mongo, ou extends

}
