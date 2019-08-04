package com.example.projeto1.controllers;

import com.example.projeto1.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


//recebe requisicoes
@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
     this.userRepository = userRepository;
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    //@ResponseBody
    public String getUser(Model model){
        model.addAttribute("usersList", this.userRepository.findAll());

        return "user";//retornando um template
    }
}
