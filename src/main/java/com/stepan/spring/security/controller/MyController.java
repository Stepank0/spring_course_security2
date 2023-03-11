package com.stepan.spring.security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")// Связываем страницу после авторизации с .JSP view_for_all_employees
    public String getInfoForAllEmps(){
        return "view_for_all_employees";
    }

}
