package com.example.demo.controller;

import com.example.demo.domain.Age;
import com.example.demo.services.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @GetMapping("/all")
    @ResponseBody
    public int[] getAll(){
        return ageService.getChartData();
    }

    @GetMapping("/show")
    public String visualize(){
        return "chart";
    }

    @GetMapping("/show2")
    public String visualize2(){
        return "chart2";
    }

}
