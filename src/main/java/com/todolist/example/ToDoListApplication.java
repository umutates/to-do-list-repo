package com.todolist.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ToDoListApplication {

    
    
	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}
}
