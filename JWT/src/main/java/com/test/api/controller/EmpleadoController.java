package com.test.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.model.Empleado;
import com.test.api.service.EmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoService empleadoService;
	
	@GetMapping("/")
	public ResponseEntity<?> listarEmpleados(){
		try {
			List<Empleado> listarEmpleados = empleadoService.listar();
			return ResponseEntity.ok(listarEmpleados);
		} catch (Exception e) {
			String error = e.getMessage(); 
			return ResponseEntity.internalServerError().body(error);
		}
	}
	
}
