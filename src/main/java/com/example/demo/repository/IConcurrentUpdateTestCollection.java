package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IConcurrentUpdateTestCollection extends MongoRepository<ConcurrentUpdateTestCollection,String> {

	List<ConcurrentUpdateTestCollection> findByName(String domain);
}
