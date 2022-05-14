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

import com.example.exame.dto.ClienteRequestDto;
import com.example.exame.dto.ClienteResponseDto;
import com.example.exame.services.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(path = "/listar")
    public ResponseEntity<List<ClienteResponseDto>>listar(){
		return new ResponseEntity<List<ClienteResponseDto>>(service.listarCliente(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> guardar(@RequestBody ClienteRequestDto clienteRequestDto){
		service.guardarCliente(clienteRequestDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    
    @DeleteMapping(path	 = "/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
    ClienteResponseDto clienteDto = service.clienteById(id);
		if(clienteDto != null) {
			service.eliminarCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
       
    }
    
    
    @PutMapping
	public ResponseEntity<Void> editar (@RequestBody ClienteRequestDto clienteRequestDto){
			
    	ClienteResponseDto clienteDto = service.clienteById(clienteRequestDto.getIdCliente());
		if(clienteDto != null) {
			service.editarCliente(clienteRequestDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
    
    
    @GetMapping("/{id}")
	public @ResponseBody ResponseEntity<ClienteResponseDto> buscarPorId(@PathVariable Integer id){
		
    	ClienteResponseDto clienteDto = service.clienteById(id);
		if(clienteDto != null) {
			return new ResponseEntity<ClienteResponseDto>(clienteDto, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<ClienteResponseDto>(HttpStatus.NOT_FOUND);
		
	}

}
