package com.projetojava.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetojava.demo.domain.Category;
import com.projetojava.demo.repositories.CategoryRepository;

@SpringBootApplication
public class StartupApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository _categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(StartupApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");

		_categoryRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
