package com.example.exame.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "hospital")
@Entity
public class Hospital {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHospital;
	private String nombre;
	private String descripcion;
	private String distrito;
	
	
	@ManyToMany(mappedBy = "hospital" , cascade = {CascadeType.PERSIST ,CascadeType.MERGE})
	private List<Cliente> cliente = new ArrayList<>();

	
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


	public List<Cliente> getCliente() {
		return cliente;
	}


	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}
	
	

}
