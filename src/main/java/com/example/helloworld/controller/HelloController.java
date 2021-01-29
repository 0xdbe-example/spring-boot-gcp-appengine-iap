package com.example.helloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.helloworld.models.UserData;

@RestController
public class HelloController {

    @RequestMapping("/")
        public UserData greeting(
          @RequestHeader("X-Goog-Authenticated-User-Email") String email,
          @RequestHeader("X-Goog-Authenticated-User-Id") String id,
          @RequestHeader("x-goog-iap-jwt-assertion") String jwt) {
            return new UserData(email, id, jwt);
        }
}
