package com.utn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private String fecha;
	
	@ManyToOne()
	@JoinColumn(name = "empresa.id")   
	private EmpresaEntidad idEmpresa; 

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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public EmpresaEntidad getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(EmpresaEntidad idEmpresa) {
		this.idEmpresa = idEmpresa;
	}



	
	
	
	
	

}