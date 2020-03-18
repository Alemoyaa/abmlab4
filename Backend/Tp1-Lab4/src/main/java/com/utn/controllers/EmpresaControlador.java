package com.utn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.utn.dto.EmpresaDTO;
import com.utn.service.EmpresaServicio;
import com.utn.service.IBaseServicio; 
@Controller
@RestController
@RequestMapping(path = "api/v1/empresa")
public class EmpresaControlador extends BaseControlador <EmpresaDTO>{

	private EmpresaServicio servicio;

    public EmpresaControlador(EmpresaServicio eServicio) {
        super(eServicio);
        this.servicio = eServicio;
    }
}
