package com.utn.controllers;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.utn.service.IBaseServicio;


@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
@Transactional
public class BaseControlador <DTO> {

private IBaseServicio<DTO> servicio;
	
	public BaseControlador(IBaseServicio<DTO> servicio) {
		this.servicio=servicio;
	}
	
	   @GetMapping("/")
	    public ResponseEntity getAll() {
	        try {
	            return ResponseEntity.ok().body(servicio.findAll());
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("{\"message\": \"Error. Please try again later.\"}");
	        }
	    }
	   
	   @GetMapping("/{id}")
	    public ResponseEntity getOne(@PathVariable int id) {
	        try {
	            return ResponseEntity.ok().body(servicio.findById(id));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("{\"message\": \"Error. Please check the ID, and try again later.\"}");
	        }
	    }

	    @PostMapping("/")
	    public ResponseEntity post(@RequestBody DTO dto) {
	        try {
	            return ResponseEntity.ok().body(servicio.save(dto));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("{\"message\": \"Error. Please check the BODY request, and try again later.\"}");
	        }
	    }

	    @PutMapping("/{id}")
	    @Transactional
	    public ResponseEntity put(@PathVariable int id, @RequestBody DTO dto) {
	        try {
	            return ResponseEntity.ok().body(servicio.update(id, dto));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity delete(@PathVariable int id) {
	        try {
	            return ResponseEntity.ok().body(servicio.delete(id));
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("{\"message\": \"Error. Please check the ID, and try again later.\"}");
	        }
	    }
	
}
