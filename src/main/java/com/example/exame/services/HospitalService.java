package com.example.exame.services;

import java.util.List;


import com.example.exame.dto.HospitalRequestDto;
import com.example.exame.dto.HospitalResponseDto;




public interface HospitalService {
	
	public void guardarHospital(HospitalRequestDto h);
	public void eliminarHospital(Integer id);
	public void editarHospital(HospitalRequestDto h);
	public List<HospitalResponseDto> listarHospital();
	public HospitalResponseDto hospitalById(Integer id);

}
