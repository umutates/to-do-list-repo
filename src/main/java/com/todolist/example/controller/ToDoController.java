package com.todolist.example.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todolist.example.entity.ToDo;
import com.todolist.example.entity.User;
import com.todolist.example.service.TodoService;
import com.todolist.example.service.UserService;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private UserService userService;

    @Autowired
    private TodoService toDoService;

    @GetMapping("/add")
    public String getToDo(Model model, HttpServletRequest request) {

        model.addAttribute("todo", new ToDo());

        return "todoadd";

    }

    @PostMapping("/add")
    public String postToDo(@ModelAttribute("todo") ToDo todo, HttpSession session, HttpServletResponse response,
            Model model) {

        if (session.getAttribute("userId") != null) {
            Long sessionId = (Long) session.getAttribute("userId");
            User user = userService.findById(sessionId);
            todo.setUser(user);
            toDoService.save(todo);
            user = userService.findById(sessionId);
            model.addAttribute("succesMessage", "Saved Succes");
            model.addAttribute("userName",user.getName());
            model.addAttribute("todolist", user.getToDoList());

        }

        else {
            model.addAttribute("errorMessage", "Something has gone wrong!Please try again");
            return "redirect:/";
        }

        return "todolist";

    }
    
    @GetMapping("/delete/{id}")
    public String getDelete(@PathVariable("id")Long id) {

        toDoService.delete(id);

        return "redirect:/user/todolist";

    }
}
