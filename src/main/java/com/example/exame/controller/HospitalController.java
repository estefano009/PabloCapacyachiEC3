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

import com.example.exame.dto.HospitalRequestDto;
import com.example.exame.dto.HospitalResponseDto;
import com.example.exame.services.HospitalService;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	@GetMapping(path = "/listar")
	public ResponseEntity<List<HospitalResponseDto>>listar(){
		return new ResponseEntity<List<HospitalResponseDto>>(service.listarHospital(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> guardar(@RequestBody HospitalRequestDto hospitalDto){
		service.guardarHospital(hospitalDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    
    @DeleteMapping(path	 = "/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
    HospitalResponseDto hospitDto = service.hospitalById(id);
		if(hospitDto != null) {
			service.eliminarHospital(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
       
    }
    
    
    
    @PutMapping
	public ResponseEntity<Void> editar (@RequestBody HospitalRequestDto hospitalDto){
			
    	HospitalResponseDto hospitDto = service.hospitalById(hospitalDto.getIdHospital());
		if(hospitDto != null) {
			service.editarHospital(hospitalDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
    
    
    @GetMapping("/{id}")
	public @ResponseBody ResponseEntity<HospitalResponseDto> buscarPorId(@PathVariable Integer id){
		
    	HospitalResponseDto hospitalDto = service.hospitalById(id);
		if(hospitalDto != null) {
			return new ResponseEntity<HospitalResponseDto>(hospitalDto, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<HospitalResponseDto>(HttpStatus.NOT_FOUND);
		
	}
	
}
