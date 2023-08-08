package com.projetojava.demo.resources;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojava.demo.domain.Category;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    
    @GetMapping
    public List<Category> listar() {

        Category cat1 = new Category(1, "informatica");
        Category cat2 = new Category(2, "Escritorio");

        List<Category> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat2);

        return lista;
    }
    
}
