package com.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ExampleController {

    @GetMapping("/example")
    public String example(){
        return "example";//example.html
    }
}
