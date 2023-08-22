package com.projetojava.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojava.demo.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {}