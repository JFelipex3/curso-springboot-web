package com.jmachuca.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"", "/", "/home"})
    public String home() {
        // Actividades a realizar
        return "redirect:/list"; // Redirige a la ruta /list, los parametros previos se pierden. (cambia la URL en el navegador, ej: http://localhost:8080/list)
        //return "forward:/list"; // Redirige a la ruta /list, los parametros previos se mantienen.(mantiene la URL en el navegador, ej: http://localhost:8080/home)
    }

}
