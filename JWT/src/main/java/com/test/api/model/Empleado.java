package com.test.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleados")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Empleado {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name ="email")
	private String email;
	@Column(name = "department")
	private String department;
}
