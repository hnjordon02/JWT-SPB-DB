package com.test.api.users.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.users.dto.CreateUserDto;
import com.test.api.users.dto.GetUserDto;
import com.test.api.users.dto.UserDtoConverter;
import com.test.api.users.services.UserEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	private final UserEntityService userEntityService;
	private final UserDtoConverter userDtoConverter;
	
	
	@PostMapping("/")
	public GetUserDto nuevoUsuario( @RequestBody CreateUserDto newUser) {
		return userDtoConverter.convertUserEntityToGetUserDto(userEntityService.nuevoUsuario(newUser));
	}
}
