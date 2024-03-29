package com.example.projeto1.service;


import com.example.projeto1.entity.User;
import com.example.projeto1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
   }
}
