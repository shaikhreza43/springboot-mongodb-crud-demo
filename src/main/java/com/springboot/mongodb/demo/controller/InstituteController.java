package com.springboot.mongodb.demo.controller;

import com.springboot.mongodb.demo.common.CommonApiResponse;
import com.springboot.mongodb.demo.model.Institute;
import com.springboot.mongodb.demo.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/institute")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @PostMapping("/save")
    public ResponseEntity<CommonApiResponse> saveInstitute(@Valid @RequestBody Institute institute){

        CommonApiResponse response = instituteService.saveInstitute(institute);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
