package com.example.exame.dto;

public class HospitalResponseDto {
	
	private Integer idHospital;
	private String nombre;
	private String descripcion;
	private String distrito;
	public Integer getIdHospital() {
		return idHospital;
	}
	public void setIdHospital(Integer idHospital) {
		this.idHospital = idHospital;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	

}
