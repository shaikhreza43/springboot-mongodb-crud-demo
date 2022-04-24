package com.springboot.mongodb.demo.service;

import com.springboot.mongodb.demo.common.CommonApiResponse;
import com.springboot.mongodb.demo.model.Student;
import org.bson.types.ObjectId;

public interface StudentService {

    CommonApiResponse saveStudent(Student student);

    CommonApiResponse updateStudent(Student student, String id);

    CommonApiResponse findStudent(String id);

    CommonApiResponse deleteStudent(String id);

    CommonApiResponse findAllStudent();
}
