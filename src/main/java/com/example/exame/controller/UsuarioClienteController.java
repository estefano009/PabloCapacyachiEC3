package com.example.exame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.exame.dto.UsuarioClienteRequestDto;
import com.example.exame.dto.UsuarioClienteResponseDto;
import com.example.exame.services.UsuarioClienteService;

@Controller
@RequestMapping("/usuariocliente")
public class UsuarioClienteController {
	
	
	@Autowired
	private UsuarioClienteService service;
	
	@GetMapping(path = "/listar")
	public ResponseEntity<List<UsuarioClienteResponseDto>>listar(){
		return new ResponseEntity<List<UsuarioClienteResponseDto>>(service.listarUsuarioCliente(),HttpStatus.OK);
    }

	@PostMapping
    public ResponseEntity<Void> guardar(@RequestBody UsuarioClienteRequestDto usuarioDto){
		service.guardarUsuarioCliente(usuarioDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    
	@DeleteMapping(path	 = "/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
    UsuarioClienteResponseDto usuarioDto = service.UsuarioClienteById(id);
		if(usuarioDto != null) {
			service.eliminarUsuarioCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
       
    }
	
	
	 @PutMapping
		public ResponseEntity<Void> editar (@RequestBody UsuarioClienteRequestDto usuarioDto){
				
	    	UsuarioClienteResponseDto usuarioClienteDto = service.UsuarioClienteById(usuarioDto.getIdUsuario());
			if(usuarioClienteDto != null) {
				service.editarUsuarioCliente(usuarioDto);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	 
	 
	 @GetMapping("/{id}")
		public @ResponseBody ResponseEntity<UsuarioClienteResponseDto> buscarPorId(@PathVariable Integer id){
			
		 UsuarioClienteResponseDto usuarioDto = service.UsuarioClienteById(id);
			if(usuarioDto != null) {
				return new ResponseEntity<UsuarioClienteResponseDto>(usuarioDto, HttpStatus.OK);
				
			}
			
			return new ResponseEntity<UsuarioClienteResponseDto>(HttpStatus.NOT_FOUND);
			
		}


}
