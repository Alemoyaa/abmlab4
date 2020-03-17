package com.utn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.entity.NoticiaEntidad;
 
public interface NoticiaRepositorio extends JpaRepository<NoticiaEntidad, Integer> {

}
