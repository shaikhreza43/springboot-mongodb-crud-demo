package com.springboot.mongodb.demo.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonApiResponse<T> {

    private T data;
    private String message;
    private int statusCode;
}
