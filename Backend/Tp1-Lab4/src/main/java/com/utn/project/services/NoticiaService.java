package com.utn.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utn.project.dtos.NoticiaDTO;
import com.utn.project.entities.Noticia;
import com.utn.project.repositories.NoticiaRepository;

@Service
public class NoticiaService{
	
	private NoticiaRepository repository;
	private NoticiaDTO dtoClass;
	private Noticia entityClass;
	private ModelMapper mMapper = new ModelMapper();
	private NoticiaDTO dto = new NoticiaDTO();
	
	
	public NoticiaService(NoticiaRepository repository, NoticiaDTO dtoClass, Noticia entityClass) {
		this.repository = repository;
		this.dtoClass = dtoClass;
		this.entityClass = entityClass; 
	}
	
	@Transactional
	public List<NoticiaDTO> findAll() throws Exception{
		List<Noticia> entities = repository.findAll();
		List<NoticiaDTO> dtos = new ArrayList<>();
		
		try {
			for	(Noticia Iterador: entities) {
				mMapper.map(Iterador, dto); //Esta parte puede traer problemas del modelMapper
				dtos.add(dto);
			}
			return dtos;
		}catch(Exception e) {
			throw new Exception();
		}
	}
	
	@Transactional
	public NoticiaDTO findById(int id) throws Exception {
		
		Optional <Noticia> entityOptional = repository.findById(id);		
		
		try {
			
			Noticia entidad = entityOptional.get();
			mMapper.map(entidad, dtoClass);	//Aca tambien puede dar errores
			return (dtoClass);
			
		}catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Transactional
	public NoticiaDTO save(NoticiaDTO dto) throws Exception {
		
		Noticia entities = new Noticia(); 
		
		try {
			
			mMapper.map(dto, entities);
			entities =(Noticia) repository.save(entities); // y aca
			
			mMapper.map(entities, dtoClass);
			
			return (dtoClass) ;
			
		}catch (Exception e) {
			throw new Exception();
		}
	}
	
	@Transactional
	public NoticiaDTO update(int id, NoticiaDTO dto) throws Exception{
		
		Optional<Noticia> entidadOptional = repository.findById(id); 
		
		try {
			
			Noticia entidad = entidadOptional.get();
			
			Noticia entidadParams = new Noticia();
			
			mMapper.map(dto, entidadParams); // y por aca tambien
			
			try {
				
				if(repository.existsById(id)) {
					
					entidadParams.setId(id);
					entidad = (Noticia) repository.save(entidadParams);
					
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
