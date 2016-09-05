package com.todolist.example;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.todolist.example.entity.User;
import com.todolist.example.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;
    
    private User user;
    
    @Before
    public void SetUp(){
        user=new User();
        user.setName("Umut");
        user.setSurname("Ates");
        user.setEmail("umutates.05@gmail.com"+Math.random());
        user.setPassword("12345678");
        
        
        
    }
    
    @Test
    public void shouldSaveUserWhenCallSaveMethod() {
        user=userService.save(user);
        
        assertNotNull(user.getEmail());
        
    }
    
    @Test
    public void shoulGetUserWhenCallFindByIdMethod(){
        user=userService.save(user);
        user=userService.findById(user.getId());
        
        assertNotNull(user);

    }

}
