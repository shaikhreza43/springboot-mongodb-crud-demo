package com.springboot.mongodb.demo.service;

import com.springboot.mongodb.demo.common.CommonApiResponse;
import com.springboot.mongodb.demo.model.Institute;
import com.springboot.mongodb.demo.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class InstituteServiceImpl implements InstituteService {

    @Autowired
    private InstituteRepository instituteRepository;

    @Override
    public CommonApiResponse saveInstitute(Institute institute) {

        CommonApiResponse response = null;

        try {
            Institute saved = instituteRepository.save(institute);

            response = CommonApiResponse.builder().message("Institute Created Successfully").statusCode(HttpStatus.CREATED.value()).data(saved).build();
        } catch (Exception ex) {
            response = CommonApiResponse.builder().message(ex.getLocalizedMessage()).statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).data(null).build();
        }
        return response;
    }
}
