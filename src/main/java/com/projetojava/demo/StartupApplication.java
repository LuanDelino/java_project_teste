package com.projetojava.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetojava.demo.domain.Category;
import com.projetojava.demo.domain.Cities;
import com.projetojava.demo.domain.States;
import com.projetojava.demo.domain.Product;
import com.projetojava.demo.repositories.CategoryRepository;
import com.projetojava.demo.repositories.CitiesRepository;
import com.projetojava.demo.repositories.ProductRepository;
import com.projetojava.demo.repositories.StatesRepository;

@SpringBootApplication
public class StartupApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository _categoryRepository;

	@Autowired
	private ProductRepository _productRepository;

	@Autowired
	private CitiesRepository _citiesRepository;

	@Autowired
	private StatesRepository _statesRepository;

	public static void main(String[] args) {
		SpringApplication.run(StartupApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");

		Product p1 = new Product(null, "Computador", 2000);
		Product p2 = new Product(null, "Impressora", 800);
		Product p3 = new Product(null, "Mouse", 300);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		_categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		_productRepository.saveAll(Arrays.asList(p1, p2, p3));


		States est1 = new States(null, "Minas Gerais");
		States est2 = new States(null, "São Paulo");

		Cities cid1 = new Cities(null, "Uberlandia", est1);
		Cities cid2 = new Cities(null, "São Paulo", est2);
		Cities cid3 = new Cities(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));

		_statesRepository.saveAll(Arrays.asList(est1, est2));
		_citiesRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
	}

}
