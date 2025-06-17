package com.jmachuca.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jmachuca.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.jmachuca.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    //http://localhost:8080/api/params/foo?message=Hola%20que%20tal
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Sin mensaje") String message) {

        ParamDto param = new ParamDto();

        param.setMessage(message);
        
        return param;
    }

    // http://localhost:8080/api/params/fooParamCustom?mensaje=Hola%20que%20tal
    @GetMapping("/fooParamCustom")
    public ParamDto fooParamCustom(@RequestParam(required = false, defaultValue = "Sin mensaje", name = "mensaje") String message) {

        ParamDto param = new ParamDto();

        param.setMessage(message);
        
        return param;
    }

    // http://localhost:8080/api/params/bar?text=Tequila&code=14
    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code) {

        ParamMixDto params = new ParamMixDto();

        params.setMessage(text);
        params.setCode(code);

        return params;
    }

    //http://localhost:8080/api/params/request?code=14&message=Alg%C3%BAn%20mensaje
    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {

        ParamMixDto params = new ParamMixDto();

        Integer code = 0;
        
        try {
            code = Integer.parseInt(request.getParameter("code"));    
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir el código: " + e.getMessage());
        }

        params.setCode(code);
        params.setMessage(request.getParameter("message"));

        return params;
    }

}
