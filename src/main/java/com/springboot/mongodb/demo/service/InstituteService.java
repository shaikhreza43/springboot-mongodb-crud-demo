package com.springboot.mongodb.demo.service;

import com.springboot.mongodb.demo.common.CommonApiResponse;
import com.springboot.mongodb.demo.model.Institute;

public interface InstituteService {
    CommonApiResponse saveInstitute(Institute institute);
}
