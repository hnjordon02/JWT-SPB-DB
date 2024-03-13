package com.test.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.api.model.Empleado;
import com.test.api.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	public List<Empleado> listar(){
		return empleadoRepository.listar();
	}
}
