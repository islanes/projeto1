package com.example.projeto1.config;

import com.example.projeto1.entity.User;
import com.example.projeto1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent args){

        List<User> users = userRepository.findAll();
        if(users.isEmpty()) {

            createUser("Islane", "islane@email.com");
            createUser("Luiz", "luiz@email.com");
            createUser("Pedro", "pedro@email.com");
        }

        User user = userRepository.findByName("Isl");
        System.out.println("O nome procurado foi encontrado: " +user.getName());

        User user1 = userRepository.findByEmail("islane@email.com");
        System.out.println("O email procurado foi encontrado: " +user1.getEmail());

    }

    public void createUser(String name, String email){
        User user = new User(name,email);
        userRepository.save(user);


    }
}
