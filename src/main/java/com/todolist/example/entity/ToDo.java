package com.todolist.example.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ToDo {
    
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoId;
    
    @ManyToOne
    private User user;
    
    private String define;
    
    private Date date;

     public Long getToDoId() {
    
        return toDoId;
    }


    
    public void setToDoId(Long toDoId) {
    
        this.toDoId = toDoId;
    }


    public String getDefine() {
    
        return define;
    }

    
    public void setDefine(String define) {
    
        this.define = define;
    }


    
    public User getUser() {
    
        return user;
    }


    
    public void setUser(User user) {
    
        this.user = user;
    }



    public Date getDate() {

        return date;
    }



    public void setDate(Date date) {

        this.date = date;
    }


    
  


   
}
