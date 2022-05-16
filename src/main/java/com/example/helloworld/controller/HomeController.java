package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;

import com.example.helloworld.helper.JwtHelper;

@Controller
public class HomeController {

    @RequestMapping("/")
        public String getHome(
          Model model,
          Authentication authentication,
          @RequestHeader("X-Goog-Authenticated-User-Email") String email,
          @RequestHeader("X-Goog-Authenticated-User-Id") String id,
          @RequestHeader("x-goog-iap-jwt-assertion") String jwt) {
            model.addAttribute("mail", email);
            model.addAttribute("userid", id);
            model.addAttribute("jwt", jwt);
            model.addAttribute("jwtDecoded", JwtHelper.decodeBase64toString(jwt));
            model.addAttribute("spingUserName", authentication.getName());
            return "home";
        }
}
