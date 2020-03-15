package com.utn.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.utn.project.dtos.EmpresaDTO; 
import com.utn.project.entities.Empresa; 
import com.utn.project.repositories.EmpresaRepository; 
 
@Service
public class EmpresaService {
	private EmpresaRepository repository;
	private EmpresaDTO dtoClass;
	private Empresa entityClass;
	private ModelMapper mMapper = new ModelMapper();
	private EmpresaDTO dto = new EmpresaDTO();
	
	public EmpresaService(EmpresaRepository repository, EmpresaDTO dtoClass, Empresa entityClass) {
		this.repository = repository;
		this.dtoClass = dtoClass;
		this.entityClass = entityClass; 
	} 
	
	@Transactional
	public List<EmpresaDTO> findAll() throws Exception{
		List<Empresa> entities = repository.findAll();
		List<EmpresaDTO> dtos = new ArrayList<>();
		
		try {
			for	(Empresa Iterador: entities) {
				mMapper.map(Iterador, dto); //Esta parte puede traer problemas del modelMapper
				dtos.add(dto);
			}
			return dtos;
		}catch(Exception e) {
			System.out.println("El findall");
			throw new Exception();
		}
	}
	
	@Transactional
	public EmpresaDTO findById(int id) throws Exception {
		
		Optional <Empresa> entityOptional = repository.findById(id);		
		
		try {
			
			Empresa entidad = entityOptional.get();
			mMapper.map(entidad, dtoClass);	//Aca tambien puede dar errores
			return (dtoClass);
			
		}catch (Exception e) {
			System.out.println("El find by id");
			throw new Exception();
		}
	}
	
	@Transactional
	public EmpresaDTO save(EmpresaDTO dto) throws Exception {
		
		Empresa entities = new Empresa(); 
		
		try {
			
			mMapper.map(dto, entities);
			entities =(Empresa) repository.save(entities); // y aca
			
			mMapper.map(entities, dtoClass);
			
			return (dtoClass) ;
			
		}catch (Exception e) {
			System.out.println("El save");
			throw new Exception();
		}
	}
	
	@Transactional
	public EmpresaDTO update(int id, EmpresaDTO dto) throws Exception{
		
		Optional<Empresa> entidadOptional = repository.findById(id); 
		
		try {
			
			Empresa entidad = entidadOptional.get();
			
			Empresa entidadParams = new Empresa();
			
			mMapper.map(dto, entidadParams); // y por aca tambien
			
			try {
				
				if(repository.existsById(id)) {
					
					entidadParams.setId(id);
					entidad = (Empresa) repository.save(entidadParams);
					
					mMapper.map(entidad, dtoClass); // Y aca
					
					return (dtoClass); 
					
				}else {
					throw new Exception();
				}
				
			}catch (Exception e) {
				throw new Exception();
			}
		}catch (Exception e) {
			throw new Exception();
		}
		
	}

	@Transactional
	public boolean delete(int id) throws Exception { //Aca seguro que no
		try {
			if(repository.existsById(id)) {
				repository.deleteById(id);
				return true;
			}else {
				throw new Exception();
			}
		}catch (Exception e) {
			throw new Exception();
		}
	}

	
}
