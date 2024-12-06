package com.learning.SimplewebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
//    @ResponseBody
    @RequestMapping("/")
    public String hello(){
        return "This is basic intro";
    }
    @RequestMapping("/about")
    public String aboutPage(){
        return "this is about page!!!!";
    }
}
