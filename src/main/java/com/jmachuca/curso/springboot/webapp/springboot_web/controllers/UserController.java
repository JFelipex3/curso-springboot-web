package com.jmachuca.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jmachuca.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

    @ModelAttribute("users")
    public List<User> userModel() {

        List<User> users = new ArrayList<>();

        users = Arrays.asList(
            new User("Carlos", "Gomez"),
            new User("Ana", "Perez", "ana.perez@correo.com"),
            new User("Luis", "Fernandez"),
            new User("Maria", "Lopez", "maria.lopez@correo.com")
        );

        return users;
    }
    
    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Jhonnatan", "Machuca");
        user.setEmail("test@correo.com");

        model.addAttribute("title", "Hola Mundo");
        model.addAttribute("user", user);

        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {

        model.addAttribute("title", "Listado de Usuarios");
        //model.addAttribute("users", users);

        return "list";
    }
}
