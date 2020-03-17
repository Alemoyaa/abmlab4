package com.utn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.entity.EmpresaEntidad;
  
public interface EmpresaRepositorio extends JpaRepository<EmpresaEntidad, Integer> {

}
