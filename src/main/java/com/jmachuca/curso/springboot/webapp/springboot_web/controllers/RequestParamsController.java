package com.jmachuca.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jmachuca.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Sin mensaje") String message) {

        ParamDto param = new ParamDto();

        param.setMessage(message);
        
        return param;
    }

    @GetMapping("/fooParamCustom")
    public ParamDto fooParamCustom(@RequestParam(required = false, defaultValue = "Sin mensaje", name = "mensaje") String message) {

        ParamDto param = new ParamDto();

        param.setMessage(message);
        
        return param;
    }
}
