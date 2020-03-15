package com.utn.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.utn.project.dtos.EmpresaDTO;
import com.utn.project.entities.Empresa;
import com.utn.project.repositories.EmpresaRepository;

public class EmpresaService {
	private EmpresaRepository repository;
	
	public EmpresaService(EmpresaRepository repository) {
		this.repository = repository;
	}
	@Transactional
	public List<EmpresaDTO> findAll() throws Exception{
		List<Empresa> entidad = repository.findAll();
		List<EmpresaDTO> dto = new ArrayList<>();
		
		try {
			for(Empresa i: entidad) {
				EmpresaDTO data = new EmpresaDTO();
				
				data.setId(i.getId());
				data.setDenominacion(i.getDenominacion());
				data.setTelefono(i.getTelefono());
				data.setHorario(i.getHorario());
				data.setQuienesSomos(i.getQuienesSomos());
				data.setLatitud(i.getLatitud());
				data.setLongitud(i.getLongitud());
				data.setDomicilio(i.getDomicilio());
				data.setEmail(i.getEmail());
				
				dto.add(data);
			}
			return dto;
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	
	public EmpresaDTO findById(int id) throws Exception {
		Optional<Empresa> entityOpcional = repository.findById(id);
		EmpresaDTO data = new EmpresaDTO();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return data;
	}
}
