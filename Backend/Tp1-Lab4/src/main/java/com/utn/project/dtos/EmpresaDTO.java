package com.utn.project.dtos;

import java.io.Serializable;

public class EmpresaDTO implements Serializable {
	private int id;
	private String denominacion;
	private String telefono;
	private String horario;
	private String quienesSomos;
	private float latitud;
	private float longitud;
	private String domicilio;
	private String email;
	
	public EmpresaDTO() {
		
	}
	
	public EmpresaDTO(int id, String denominacion, String telefono, String horario, String quienesSomos, float latitud,
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
