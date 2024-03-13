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
@Table(name = "usuario")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Usuario {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer id;
	private String nombre;
	private String password;
}
