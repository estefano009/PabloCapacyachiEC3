package com.example.exame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exame.model.UsuarioCliente;

public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Integer> {
	
	UsuarioCliente findByUsuario(String usuario);
	

}
