package com.example.exame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exame.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
