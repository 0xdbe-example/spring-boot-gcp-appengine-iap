package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;


@RestController
public class authentication {

    @RequestMapping("/auth")
    public ResponseEntity<String> getAuthData (
        Authentication authentication
    ){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");
        
        return new ResponseEntity<>(
            authentication.getName(), headers, HttpStatus.OK);
    }
        

    
    
}
