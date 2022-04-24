package com.springboot.mongodb.demo.repository;

import com.springboot.mongodb.demo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    Student findByStudentId(String id);
}
