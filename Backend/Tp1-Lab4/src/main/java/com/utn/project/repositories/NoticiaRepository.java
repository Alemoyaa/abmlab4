package com.utn.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.project.entities.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

}
