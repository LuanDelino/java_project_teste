package com.projetojava.demo.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/categories")
public class CategoriaResource {
    
    @RequestMapping(method=RequestMethod.GET)
    public String listar() {
        return "Listar funcionando!";
    }
    
}
