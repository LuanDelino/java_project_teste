package com.projetojava.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetojava.demo.domain.States;

@Repository
public interface StatesRepository extends JpaRepository<States, Integer> {}