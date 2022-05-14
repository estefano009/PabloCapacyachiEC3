package com.example.exame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Table(name="usuariocliente")
@Entity
public class UsuarioCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String usuario;
	private String password;
	private String rol;
	private Integer idCliente;
	
	
	@OneToOne(mappedBy = "usuariocliente")
    private Cliente cliente;


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	
	
	
}
