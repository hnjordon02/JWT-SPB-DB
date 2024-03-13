package com.test.api.users.dto;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.test.api.users.model.UserEntity;
import com.test.api.users.model.UserRole;

@Component
public class UserDtoConverter {
	public GetUserDto convertUserEntityToGetUserDto(UserEntity user) {
		return GetUserDto.builder()
				.username(user.getUsername())
				.fullName(user.getFullName())
				.roles(user.getRoles().stream()
							.map(UserRole::name)
							.collect(Collectors.toSet())
				).build();
	}
}
