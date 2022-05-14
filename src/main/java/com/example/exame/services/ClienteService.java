package com.example.exame.services;

import java.util.List;

import com.example.exame.dto.ClienteRequestDto;
import com.example.exame.dto.ClienteResponseDto;
import com.example.exame.model.Cliente;


public interface ClienteService {
	
	 public void guardarCliente(ClienteRequestDto c);
	 public void eliminarCliente(Integer id);
	 public void editarCliente(ClienteRequestDto  c);
	 public List<ClienteResponseDto> listarCliente();
	  public ClienteResponseDto clienteById(Integer id);
}
