package com.jmachuca.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    @Value("${config.code}")
    private Integer code;

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues; // Se puede utilizar List en vez de Array 

    @Value("#{ '${config.listOfValues}'.split(',') }") // Utilizar lenguaje de expresión para manipular la cadena
    private List<String> valueList; // Otra forma de inyectar una lista desde properties
    
    @Value("#{ '${config.listOfValues}' }") // Manipular la cadena directamente para que sea un string
    private String valueString;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private Long price;

    @Autowired
    private Environment environment;

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

    // http://localhost:8080/api/var/values
    @GetMapping("/values")
    public Map<String, Object> getValues() {

        Map<String, Object> json = new HashMap<>();
        json.put("code", code);
        json.put("username", username);
        json.put("message", message);
        json.put("listOfValues", listOfValues);

        return json;
    }

    // http://localhost:8080/api/var/valuesInject
    // Injectar valores de application.properties
    @GetMapping("/valuesInject")
    public Map<String, Object> getValuesInject(@Value("${config.title}") String title) {

        Map<String, Object> json = new HashMap<>();
        json.put("code", code);
        json.put("username", username);
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        json.put("title", title);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);

        return json;
    }

    @GetMapping("/valuesInjectProd")
    public Map<String, Object> getValuesInjectProd(@Value("${config.title}") String title) {

        Map<String, Object> json = new HashMap<>();
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);

        return json;
    }

    @GetMapping("/valuesInjectEnv")
    public Map<String, Object> getValuesInjectEnv(@Value("${config.title}") String title) {
        // Utilizar enviroment convierte los valores de properties a strings

        Map<String, Object> json = new HashMap<>();
        json.put("message", environment.getProperty("config.message"));
        json.put("code", environment.getProperty("config.code", Long.class));
        json.put("username", environment.getProperty("config.username"));
        json.put("title", environment.getProperty("config.title"));
        json.put("listOfValues", environment.getProperty("config.listOfValues"));

        return json;
    }

}
