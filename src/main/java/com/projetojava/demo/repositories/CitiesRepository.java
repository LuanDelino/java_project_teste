package com.projetojava.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojava.demo.domain.Cities;

@Repository
public interface CitiesRepository extends JpaRepository<Cities, Integer> {}