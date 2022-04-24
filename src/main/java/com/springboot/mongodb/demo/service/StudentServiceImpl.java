package com.springboot.mongodb.demo.service;

import com.springboot.mongodb.demo.common.CommonApiResponse;
import com.springboot.mongodb.demo.model.Student;
import com.springboot.mongodb.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public CommonApiResponse saveStudent(Student student) {

        CommonApiResponse response = null;

        try {
            if (student == null) {
                throw new NullPointerException("Invalid Stduent Data");
            }

            Student s = studentRepository.save(student);

            response = CommonApiResponse.builder().message("Student Details Saved Successfully").statusCode(HttpStatus.CREATED.value()).data(s).build();

        } catch (Exception ex) {
            response = CommonApiResponse.builder().message(ex.getLocalizedMessage()).statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).data(null).build();
        }
        return response;
    }

    @Override
    public CommonApiResponse updateStudent(Student student, String id) {

        CommonApiResponse response = null;

        try {
            if (student == null) {
                throw new NullPointerException("Invalid Student Data");
            }

            if (id == null) {
                throw new NullPointerException("Invalid Student Id");
            }

            Student existingStudent = studentRepository.findByStudentId(id);
            if (existingStudent != null) {
                existingStudent.setStudentAge(student.getStudentAge());
                existingStudent.setStudentEmail(student.getStudentEmail());
                existingStudent.setStudentAddress(student.getStudentAddress());
                existingStudent.setStudentName(student.getStudentName());
                existingStudent.setStudentMobileNumber(student.getStudentMobileNumber());

                Student s = studentRepository.save(existingStudent);
                response = CommonApiResponse.builder().message("Student Details Updated Successfully").statusCode(HttpStatus.OK.value()).data(s).build();
            } else {
                throw new NullPointerException("No Student Found with this ID");
            }

        } catch (Exception ex) {
            response = CommonApiResponse.builder().message(ex.getLocalizedMessage()).statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).data(null).build();
        }
        return response;
    }

    @Override
    public CommonApiResponse findStudent(String id) {

        CommonApiResponse response = null;

        try {

            if (id == null) {
                throw new NullPointerException("Invalid Student Id");
            }

            Student existingStudent = studentRepository.findByStudentId(id);
            if (existingStudent != null) {

                response = CommonApiResponse.builder().message("Student Details Fetched Successfully").statusCode(HttpStatus.OK.value()).data(existingStudent).build();
            } else {
                throw new NullPointerException("No Student Found with this ID");
            }

        } catch (Exception ex) {
            response = CommonApiResponse.builder().message(ex.getLocalizedMessage()).statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).data(null).build();
        }
        return response;
    }

    @Override
    public CommonApiResponse deleteStudent(String id) {

        CommonApiResponse response = null;

        try {

            if (id == null) {
                throw new NullPointerException("Invalid Student Id");
            }

            Student existingStudent = studentRepository.findByStudentId(id);
            if (existingStudent != null) {
                studentRepository.delete(existingStudent);
                response = CommonApiResponse.builder().message("Student Details Deleted Successfully").statusCode(HttpStatus.OK.value()).data(id).build();
            } else {
                throw new NullPointerException("No Student Found with this ID");
            }

        } catch (Exception ex) {
            response = CommonApiResponse.builder().message(ex.getLocalizedMessage()).statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).data(null).build();
        }
        return response;
    }

    @Override
    public CommonApiResponse findAllStudent() {

        CommonApiResponse response = null;

        try {

            List<Student> listOfStudents = studentRepository.findAll();
            if (listOfStudents.size() > 0) {
                response = CommonApiResponse.builder().message("list Of All Students").statusCode(HttpStatus.OK.value()).data(listOfStudents).build();
            } else {
                response = CommonApiResponse.builder().message("list Of All Students").statusCode(HttpStatus.OK.value()).data(new ArrayList<>()).build();
            }

        } catch (Exception ex) {
            response = CommonApiResponse.builder().message(ex.getLocalizedMessage()).statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).data(null).build();
        }
        return response;
    }
}
