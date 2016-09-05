package com.todolist.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.example.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo,Long> {

}
