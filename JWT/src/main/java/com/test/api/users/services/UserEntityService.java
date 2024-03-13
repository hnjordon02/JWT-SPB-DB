package com.test.api.users.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.test.api.service.base.BaseService;
import com.test.api.users.dto.CreateUserDto;
import com.test.api.users.model.UserEntity;
import com.test.api.users.model.UserRole;
import com.test.api.users.repos.UserEntityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository>{
	
	private final PasswordEncoder passwordEncoder;
	
	public Optional<UserEntity> findUserByUsername(String username){
		return this.repositorio.findByUsername(username);
	}
	
	/**
	 * Nos permite crear un nuevo UserEntity con rol USER
	 * 
	 * @param newUser
	 * @return
	 */
	public UserEntity nuevoUsuario(CreateUserDto newUser) {
		Optional<UserEntity> existingUserOptional = this.repositorio.findByUsername(newUser.getUsername());
		if(existingUserOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El nombre de usuario ya existe.");
		}
		if (newUser.getPassword().contentEquals(newUser.getPassword2())) {
			UserEntity userEntity = UserEntity.builder()
								    .username(newUser.getUsername())
								    .password(passwordEncoder.encode(newUser.getPassword()))
								    .fullName(newUser.getFullname())
								    .createdAt(LocalDateTime.now())
								    .roles(Stream.of(UserRole.USER).collect(Collectors.toSet())).build();
		
				return save(userEntity);

		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Las constraseñas no coinciden");
		}

	}

}
