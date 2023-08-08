package com.projetojava.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojava.demo.domain.Category;
import com.projetojava.demo.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository _categoryRepo;

    public Category search(Integer id) {
        Optional<Category> obj = _categoryRepo.findById(id);
        return obj.orElse(null);
    }

}
