package com.jmachuca.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmachuca.curso.springboot.webapp.springboot_web.models.User;
import com.jmachuca.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    
    // http://localhost:8080/api/var/baz/mesa
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {

        ParamDto param = new ParamDto();

        param.setMessage(message);

        return param;
    }

    // http://localhost:8080/api/var/mix/teclado/1213
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {

        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);

        return json;
    }

    /*
    http://localhost:8080/api/var/create
    {
       "name": "Pedro",
       "lastname": "Doe",
       "email": "pedro.doe@correo.com"
    }
    */
    @PostMapping("/create")
    public User create(@RequestBody User user) {

        return user;
    } 

}
