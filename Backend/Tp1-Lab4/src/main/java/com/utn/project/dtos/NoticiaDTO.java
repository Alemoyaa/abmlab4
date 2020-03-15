package com.utn.project.dtos;

import java.io.Serializable;
import java.util.Date;

public class NoticiaDTO implements Serializable {
	private int id;
	private String titulo;
	private String resumen;
	private String imagen;
	private String html;
	private byte publicada;
	private Date fecha;
	private int idEmpresa;
	
	public NoticiaDTO() {

	}
	
	public NoticiaDTO(int id, String titulo, String resumen, String imagen, String html, byte publicada, Date fecha,
			int idEmpresa) {
		this.id = id;
		this.titulo = titulo;
		this.resumen = resumen;
		this.imagen = imagen;
		this.html = html;
		this.publicada = publicada;
		this.fecha = fecha;
		this.idEmpresa = idEmpresa;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getResumen() {
		return resumen;
	}
	
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getHtml() {
		return html;
	}
	
	public void setHtml(String html) {
		this.html = html;
	}
	
	public byte getPublicada() {
		return publicada;
	}
	
	public void setPublicada(byte publicada) {
		this.publicada = publicada;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public int getIdEmpresa() {
		return idEmpresa;
	}
	
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}	
	
}
