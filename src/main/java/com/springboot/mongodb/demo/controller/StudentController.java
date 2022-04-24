package com.springboot.mongodb.demo.controller;

import com.springboot.mongodb.demo.common.CommonApiResponse;
import com.springboot.mongodb.demo.model.Student;
import com.springboot.mongodb.demo.service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<CommonApiResponse> saveStudent(@Valid @RequestBody Student student){

        CommonApiResponse response = studentService.saveStudent(student);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/update/{studentId}")
    public ResponseEntity<CommonApiResponse> updateStudent(@Valid @RequestBody Student student,@PathVariable(name = "studentId") String id){

        CommonApiResponse response = studentService.updateStudent(student,id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/find/{studentId}")
    public ResponseEntity<CommonApiResponse> findStudent(@PathVariable(name = "studentId") String id){

        CommonApiResponse response = studentService.findStudent(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<CommonApiResponse> deleteStudent(@PathVariable(name = "studentId") String id){

        CommonApiResponse response = studentService.deleteStudent(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/findAll")
    public ResponseEntity<CommonApiResponse> findAllStudent(){

        CommonApiResponse response = studentService.findAllStudent();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
