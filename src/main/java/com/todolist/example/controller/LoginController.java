package com.todolist.example.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.todolist.example.entity.User;
import com.todolist.example.service.UserService;

@Controller

public class LoginController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String postLogin(@Valid @ModelAttribute("user") User user, BindingResult result,Model model,HttpServletResponse response,HttpSession session) {

        User checkUser =userService.findByEmailAndPassword(user.getEmail(),user.getPassword());
       
      if (checkUser==null) {
          model.addAttribute("errorMessage","Wrong Email or Password.Please Try Again");
          return "login";
    }  
        session.setAttribute("userId",checkUser.getId());
        model.addAttribute("todolist",checkUser.getToDoList());
        model.addAttribute("userName",checkUser.getName());
        return "todolist";
    }
   
    @GetMapping("/login")
    public String getLogin(Model model){
       
        model.addAttribute("user",new User());
        
        return "login";
        
    }
    
    @GetMapping("/logout")
    public String getLogOut(Model model,HttpSession session){
       session.removeAttribute("userId");
        
        return "redirect:/";
        
    }
}
