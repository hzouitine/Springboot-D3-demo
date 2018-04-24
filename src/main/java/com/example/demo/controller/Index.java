package com.example.demo.controller;

import com.example.demo.domain.Age;
import com.example.demo.services.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Index {

    private AgeService ageService;

    @Autowired
    public Index(AgeService ageService) {
        this.ageService = ageService;
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) Integer age) {
        Age ageObj = new Age();
        if (age != null) {
            ageObj.setAge(age);
            ageService.save(ageObj);
        }
        System.out.println(ageService.findAll());
        return "index";
    }


}
