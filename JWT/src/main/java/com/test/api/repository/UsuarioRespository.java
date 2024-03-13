package com.test.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.api.model.Usuario;

public interface UsuarioRespository extends JpaRepository<Usuario, Integer>{

//	Optional<Usuario> findOneByUser(String nombre);
}
