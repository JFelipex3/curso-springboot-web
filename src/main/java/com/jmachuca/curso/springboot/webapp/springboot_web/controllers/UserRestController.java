package com.jmachuca.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/list")
    public List<User> list() {
        User user1 = new User("George", "Dafoe");
        User user2 = new User("Amanda", "Martinez");
        User user3 = new User("Jhon", "Doe");

        List<User> users = List.of(user1, user2, user3);

        return users;
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
