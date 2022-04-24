package com.springboot.mongodb.demo.repository;

import com.springboot.mongodb.demo.model.Institute;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends MongoRepository<Institute, String> {
}
