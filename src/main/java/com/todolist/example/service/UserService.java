package com.todolist.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.example.entity.User;
import com.todolist.example.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    /**
     * This method action is to save user
     * @param {@link User}
     * @return {@link Status}
     */
    public User save(User user){
        
        return userRepository.save(user);
    }
    
    public User findByEmailAndPassword(String email,String password){
        
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User findById(Long id) {
           
        return userRepository.findOne(id);
        
    }

    public User findByEmail(String email) {

        
        return userRepository.findByEmail(email);
    }
}
