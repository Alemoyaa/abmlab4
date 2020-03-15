package com.utn.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.utn.project.entities.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {

}
