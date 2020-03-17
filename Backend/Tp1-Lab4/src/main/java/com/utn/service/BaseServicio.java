package com.utn.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.utn.dto.BaseDTO;
import com.utn.entity.BaseEntidad;

public class BaseServicio <ENTITY extends BaseEntidad, DTO extends BaseDTO> implements IBaseServicio<DTO>{
	private JpaRepository<ENTITY,Integer>repository;
	private Class<DTO> dtoClass;
	private Class entityClass;
	private ModelMapper mMapper;
	
	
	public BaseServicio(JpaRepository<ENTITY, Integer> repository, Class<DTO> dtoClass, Class entityClass, ModelMapper mMapper) {
        this.repository = repository;
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
        this.mMapper = mMapper;
    }
	
	   private DTO convertToDto(ENTITY entity) {
	        return  mMapper.map(entity, (Type) dtoClass);
	    }

	    private ENTITY convertToEntity(DTO dto) {
	        return  mMapper.map(dto, (Type) entityClass);
	    }
	
	
	
    @Override
    @Transactional
    public List<DTO> findAll() throws Exception {
        List<ENTITY> entities = repository.findAll();
        try {
            return entities.stream().map(this::convertToDto).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
    @Override
    @Transactional
    public DTO findById(int id) throws Exception {
        Optional<ENTITY> entityOptional = repository.findById(id);
        try {
            if (entityOptional.isPresent()) {
                return convertToDto(entityOptional.get());
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
    @Override
    @Transactional
    public DTO save(DTO dto) throws Exception {
        try {
            ENTITY entity = repository.save(convertToEntity(dto));
            return convertToDto(entity);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    @Transactional
    public DTO update(int id, DTO dto) throws Exception {
        Optional<ENTITY> entityOptional = repository.findById(id);
        try {
            ENTITY entity = entityOptional.get();
            ENTITY entityParams = convertToEntity(dto);
            try {
                if (repository.existsById(id)) {
                    entityParams.setId(id);
                    entity = repository.save(entityParams);
                    return convertToDto(entity);
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) throws Exception {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
