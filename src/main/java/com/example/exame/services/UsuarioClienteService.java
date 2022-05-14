package com.example.exame.services;

import java.util.List;

import com.example.exame.dto.UsuarioClienteRequestDto;
import com.example.exame.dto.UsuarioClienteResponseDto;
import com.example.exame.model.UsuarioCliente;

public interface UsuarioClienteService {
	
	
	public void guardarUsuarioCliente(UsuarioClienteRequestDto u);
	public void eliminarUsuarioCliente(Integer id);
	public void editarUsuarioCliente(UsuarioClienteRequestDto u);
	public List<UsuarioClienteResponseDto> listarUsuarioCliente();
	public UsuarioClienteResponseDto UsuarioClienteById(Integer id);

}
