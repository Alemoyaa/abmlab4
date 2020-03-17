package com.utn.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.utn.dto.EmpresaDTO;
import com.utn.entity.EmpresaEntidad;
import com.utn.repository.EmpresaRepositorio;

@Service
public class EmpresaServicio extends BaseServicio<EmpresaEntidad, EmpresaDTO>{

	private EmpresaRepositorio Erepository;
	
	public EmpresaServicio(EmpresaRepositorio repository,
			ModelMapper mMapper) {
		super(repository, EmpresaDTO.class, EmpresaEntidad.class, mMapper);
		this.Erepository = repository;
	}

}
