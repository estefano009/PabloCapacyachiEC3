package com.example.exame.services.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exame.dto.HospitalRequestDto;
import com.example.exame.dto.HospitalResponseDto;
import com.example.exame.model.Hospital;
import com.example.exame.repository.HospitalRepository;
import com.example.exame.services.HospitalService;

@Service
public class HospitalServiceImp implements HospitalService {

	
	@Autowired
	private HospitalRepository repository;
	
	@Override
	public void guardarHospital(HospitalRequestDto h) {
		
		
		Hospital hospital = new Hospital();
		hospital.setIdHospital(h.getIdHospital());
		hospital.setNombre(h.getNombre());
		hospital.setDescripcion(h.getDescripcion());
		hospital.setDistrito(h.getDistrito());
		repository.save(hospital);


	}

	@Override
	public void eliminarHospital(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void editarHospital(HospitalRequestDto h) {
		
		Hospital hospital = new Hospital();
		hospital.setIdHospital(h.getIdHospital());
		hospital.setNombre(h.getNombre());
		hospital.setDistrito(h.getDistrito());
		hospital.setDescripcion(h.getDescripcion());

		repository.saveAndFlush(hospital);
	}
	

	@Override
    public List<HospitalResponseDto> listarHospital() {

        List<Hospital> hospital = repository.findAll();
        List<HospitalResponseDto> dto = new ArrayList<HospitalResponseDto>();
        HospitalResponseDto hospitalDto = null;
        
        for (Hospital h : hospital) {
        	hospitalDto = new HospitalResponseDto();
        	hospitalDto.setIdHospital(h.getIdHospital());
        	hospitalDto.setNombre(h.getNombre());
        	hospitalDto.setDescripcion(h.getDescripcion());
        	hospitalDto.setDistrito(h.getDistrito());
            
            dto.add(hospitalDto);
        }
        
        return dto;
    }
	@Override
	public HospitalResponseDto hospitalById(Integer id) {
		
		Hospital hospital = repository.findById(id).orElse(null);
		HospitalResponseDto hospitalDto =new HospitalResponseDto();
		
		hospitalDto.setIdHospital(hospital.getIdHospital());
		hospitalDto.setNombre(hospital.getNombre());
		hospitalDto.setDistrito(hospital.getDistrito());
		hospitalDto.setDescripcion(hospital.getDescripcion());
		
		
		return hospitalDto;

	}

}
