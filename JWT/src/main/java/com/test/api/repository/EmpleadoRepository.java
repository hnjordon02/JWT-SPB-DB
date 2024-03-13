package com.test.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.api.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

	@Query(value="SELECT * FROM empleados ORDER BY id ASC", nativeQuery = true)
	List<Empleado> listar();
}
