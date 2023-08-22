package com.projetojava.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetojava.demo.domain.Address;
import com.projetojava.demo.domain.Category;
import com.projetojava.demo.domain.City;
import com.projetojava.demo.domain.Client;
import com.projetojava.demo.domain.State;
import com.projetojava.demo.domain.enums.ClientType;
import com.projetojava.demo.domain.Product;
import com.projetojava.demo.repositories.AddressRepository;
import com.projetojava.demo.repositories.CategoryRepository;
import com.projetojava.demo.repositories.CityRepository;
import com.projetojava.demo.repositories.ClientRepository;
import com.projetojava.demo.repositories.ProductRepository;
import com.projetojava.demo.repositories.StateRepository;

@SpringBootApplication
public class StartupApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository _categoryRepository;

	@Autowired
	private ProductRepository _productRepository;

	@Autowired
	private CityRepository _cityRepository;

	@Autowired
	private StateRepository _stateRepository;

	@Autowired
	private ClientRepository _clientRepository;

	@Autowired
	private AddressRepository _addressRepository;

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


		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São Paulo");

		City cid1 = new City(null, "Uberlandia", est1);
		City cid2 = new City(null, "São Paulo", est2);
		City cid3 = new City(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));

		_stateRepository.saveAll(Arrays.asList(est1, est2));
		_cityRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "12345678910", ClientType.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27558878", "23354555"));
		
		Address end1 = new Address(null, "Rua ABC", "300", "Apto 303", "Jardim", "38220834", cli1, cid1);
		Address end2 = new Address(null, "Avenida ABV", "105", "Sala 800", "Centro", "38777012", cli1, cid2);

		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

		_clientRepository.saveAll(Arrays.asList(cli1));
		_addressRepository.saveAll(Arrays.asList(end1, end2));



	}

}
