package com.utn.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.utn.project.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
