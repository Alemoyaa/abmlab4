package com.utn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "noticia")
public class NoticiaEntidad extends BaseEntidad{

	@Column(name = "noticia_titulo")
	private String titulo;
	@Column(name = "noticia_resumen")
	private String resumen;
	@Column(name = "noticia_imagen")
	private String imagen;
	@Column(name = "noticia_html")
	private String html;
	@Column(name = "noticia_publicada")
	private byte publicada;
	@Column(name = "noticia_fecha")
	private Date fecha;
	@Column(name = "noticia_idEmpresa")
	private int idEmpresa; 

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