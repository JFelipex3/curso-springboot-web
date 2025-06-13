package com.jmachuca.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmachuca.curso.springboot.webapp.springboot_web.models.User;
import com.jmachuca.curso.springboot.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details() {

        UserDto userDto = new UserDto();
        User user = new User("Jhonnatan", "Machuca");
        userDto.setTitle("Hola Mundo con DTO");
        userDto.setUser(user);
        userDto.setFullName(user.getName() + " " + user.getLastname());

        return userDto;
    }
    
    @GetMapping("/details-map")
    public Map<String, Object> detailsMap() {

        User user = new User("Jhonnatan", "Machuca");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo con Map");
        body.put("user", user);

        return body;
    }
}
