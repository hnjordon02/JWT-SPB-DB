package com.test.api.users.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.api.users.model.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{
	
	Optional<UserEntity> findByUsername(String username);

}
