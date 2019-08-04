package com.example.projeto1.controllers;

import com.example.projeto1.repository.UserRepository;
import com.example.projeto1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


//recebe requisicoes
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    //@ResponseBody
    public String getUser(Model model){
        model.addAttribute("usersList", this.userService.findAll());

        return "user";//retornando um template
    }
}
