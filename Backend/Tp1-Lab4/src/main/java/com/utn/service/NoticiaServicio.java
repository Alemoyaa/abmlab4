package com.utn.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.utn.dto.NoticiaDTO; 
import com.utn.entity.NoticiaEntidad;
import com.utn.repository.NoticiaRepositorio;

@Service
public class NoticiaServicio extends BaseServicio<NoticiaEntidad, NoticiaDTO>{
	
	private NoticiaRepositorio NRepository;
	
	public NoticiaServicio(NoticiaRepositorio repository, ModelMapper mMapper) {
		super(repository, NoticiaDTO.class, NoticiaEntidad.class, mMapper );
		this.NRepository = repository;
	}
	
}
