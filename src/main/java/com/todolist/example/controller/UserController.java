package com.todolist.example.controller;



import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todolist.example.entity.User;
import com.todolist.example.service.UserService;



@Controller
@RequestMapping(headers = "Accept=text/html", value = "/user")
public class UserController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;
    
    
    @GetMapping("/singup")
    public String getSingUp(Model model) {
        model.addAttribute("user",new User());
        return "singup";
    }
    
    
    
    @PostMapping("/add")
    public String postAdd(@Valid @ModelAttribute("user") User user, BindingResult result,Model model) {

      
        
        userService.save(user);
        LOGGER.debug("SAVE_OK");
        model.addAttribute("singUpMessage","Congratulations!Registry successful.");
        return "redirect:/login";
    }
    
    @GetMapping("/todolist")
    public String getToDoList(Model model,HttpSession session) {
        if (session.getAttribute("userId") != null) {
            Long sessionId = (Long) session.getAttribute("userId");
            User user = userService.findById(sessionId);
            model.addAttribute("succesMessage", "Saved Succes");
            model.addAttribute("todolist", user.getToDoList());
            model.addAttribute("userName",user.getName());
        }

        else {
            model.addAttribute("errorMessage", "Something has gone wrong!Please try again");
            return "redirect:/";
        }

        return "todolist";
    }
    
   

}
