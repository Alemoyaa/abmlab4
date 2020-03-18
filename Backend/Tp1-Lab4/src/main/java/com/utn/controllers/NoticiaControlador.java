package com.utn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.utn.dto.NoticiaDTO; 
import com.utn.service.NoticiaServicio; 

@Controller
@RestController
@RequestMapping(path = "api/v1/noticia")
public class NoticiaControlador extends BaseControlador <NoticiaDTO>{

	private NoticiaServicio servicio;

    public NoticiaControlador(NoticiaServicio nServicio) {
        super(nServicio);
        this.servicio = nServicio;
    }
}
