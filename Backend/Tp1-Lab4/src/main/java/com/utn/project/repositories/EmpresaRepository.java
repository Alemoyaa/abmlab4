package com.utn.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utn.project.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
