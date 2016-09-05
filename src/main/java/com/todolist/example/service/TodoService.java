package com.todolist.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.example.entity.ToDo;
import com.todolist.example.repository.ToDoRepository;

@Service
public class TodoService {

    @Autowired
    private ToDoRepository toDoRepository;
    
    public ToDo save(ToDo toDo){
      return  toDoRepository.save(toDo);
    }

    public void delete(Long id) {

        toDoRepository.delete(id);
        
    }
    
}
