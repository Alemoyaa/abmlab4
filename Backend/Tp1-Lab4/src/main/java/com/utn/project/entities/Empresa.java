package com.utn.project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_Empresa")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "empresa_denominacion")
	private String denominacion;
	@Column(name = "empresa_telefono")
	private String telefono;
	@Column(name = "empresa_horario")
	private String horario;
	@Column(name = "empresa_quienesSomos")
	private String quienesSomos;
	@Column(name = "empresa_latitud")
	private float latitud;
	@Column(name = "empresa_longitud")
	private float longitud;
	@Column(name = "empresa_domicilio")
	private String domicilio;
	@Column(name = "empresa_email")
	private String email;
	
	public Empresa() {
		
	}

	public Empresa(int id, String denominacion, String telefono, String horario, String quienesSomos, float latitud,
			float longitud, String domicilio, String email) {
		this.id = id;
		this.denominacion = denominacion;
		this.telefono = telefono;
		this.horario = horario;
		this.quienesSomos = quienesSomos;
		this.latitud = latitud;
		this.longitud = longitud;
		this.domicilio = domicilio;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDenominacion() {
		return denominacion;
	}


	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}


	public String getQuienesSomos() {
		return quienesSomos;
	}


	public void setQuienesSomos(String quienesSomos) {
		this.quienesSomos = quienesSomos;
	}


	public float getLatitud() {
		return latitud;
	}


	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}


	public float getLongitud() {
		return longitud;
	}


	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	

}