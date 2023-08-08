package com.projetojava.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojava.demo.domain.Category;
import com.projetojava.demo.services.CategoryService;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    
    @Autowired
    private CategoryService _categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<?> listById(@PathVariable Integer id) {

        Category obj = _categoryService.search(id);

        return ResponseEntity.ok().body(obj);
    }

    
}
