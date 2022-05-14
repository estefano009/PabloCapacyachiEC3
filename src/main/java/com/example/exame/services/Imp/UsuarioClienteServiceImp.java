package com.example.exame.services.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exame.dto.HospitalResponseDto;
import com.example.exame.dto.UsuarioClienteRequestDto;
import com.example.exame.dto.UsuarioClienteResponseDto;
import com.example.exame.model.Hospital;
import com.example.exame.model.UsuarioCliente;
import com.example.exame.repository.UsuarioClienteRepository;
import com.example.exame.services.UsuarioClienteService;
@Service
public class UsuarioClienteServiceImp implements UsuarioClienteService {

	@Autowired
	private UsuarioClienteRepository repository;
	
	@Override
	public void guardarUsuarioCliente(UsuarioClienteRequestDto u) {
		
		UsuarioCliente usuarioCliente = new UsuarioCliente();
		usuarioCliente.setIdCliente(u.getIdCliente());
		usuarioCliente.setUsuario(u.getUsuario());
		usuarioCliente.setRol(u.getRol());
		usuarioCliente.setPassword(u.getPassword());
		repository.save(usuarioCliente);


	}

	@Override
	public void eliminarUsuarioCliente(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void editarUsuarioCliente(UsuarioClienteRequestDto u) {
		UsuarioCliente usuarioCliente = new UsuarioCliente();
		usuarioCliente.setIdUsuario(u.getIdUsuario());
		usuarioCliente.setUsuario(u.getUsuario());
		usuarioCliente.setPassword(u.getPassword());
		usuarioCliente.setRol(u.getRol());
		usuarioCliente.setIdCliente(u.getIdCliente());
		repository.saveAndFlush(usuarioCliente);

	}

	@Override
	public List<UsuarioClienteResponseDto> listarUsuarioCliente() {
		List<UsuarioCliente> usuarioClientes = repository.findAll();
		List<UsuarioClienteResponseDto> dto = new ArrayList<UsuarioClienteResponseDto>();
		UsuarioClienteResponseDto usuarioDto = null;
	        
	        for (UsuarioCliente u : usuarioClientes) {
	        	usuarioDto = new UsuarioClienteResponseDto();
	        	usuarioDto.setIdUsuario(u.getIdUsuario());
	        	usuarioDto.setUsuario(u.getUsuario());
	        	usuarioDto.setRol(u.getRol());
	        	usuarioDto.setPassword(u.getPassword());
	        	usuarioDto.setIdCliente(u.getIdCliente());
	            
	            dto.add(usuarioDto);
	        }
	        
	        return dto;
		
		
		
	}

	@Override
	public UsuarioClienteResponseDto UsuarioClienteById(Integer id) {
		
		UsuarioCliente usuarioCliente = repository.findById(id).orElse(null);
		UsuarioClienteResponseDto usuariDto =new UsuarioClienteResponseDto();
		
		usuariDto.setIdUsuario(usuarioCliente.getIdUsuario());
		usuariDto.setUsuario(usuarioCliente.getUsuario());
		usuariDto.setPassword(usuarioCliente.getPassword());
		usuariDto.setRol(usuarioCliente.getRol());
		usuariDto.setIdCliente(usuarioCliente.getIdCliente());
		
		
		return usuariDto;
	}

}
