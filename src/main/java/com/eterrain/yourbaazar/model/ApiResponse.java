package com.eterrain.yourbaazar.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse extends ResponseEntity {
    int errorCode;
    String errorDesc;

    public ApiResponse() {
        super(HttpStatus.OK);
    }

}