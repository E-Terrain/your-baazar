package com.eterrain.yourbaazar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    @RequestMapping("/getprofile")
    public String getProfile(){
        return "spring boot initial commit !!!";
    }
}
