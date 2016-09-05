package com.todolist.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todolist.example.entity.User;

@Controller
@RequestMapping("*")
public class IndexController {
    @RequestMapping(value={"", "/", "index"})
    public String index() {
        return "index";
    }
    
   
    
    
    
}
