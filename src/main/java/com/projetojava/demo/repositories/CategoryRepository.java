package com.projetojava.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojava.demo.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {}