package com.test.api.security.jwt;

import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.security.jwt.model.JwtUserResponse;
import com.test.api.security.jwt.model.LoginRequest;
import com.test.api.users.dto.GetUserDto;
import com.test.api.users.dto.UserDtoConverter;
import com.test.api.users.model.UserEntity;
import com.test.api.users.model.UserRole;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider tokenProvider;
	private final UserDtoConverter converter;
	
	
	@PostMapping("/auth/login")
	public JwtUserResponse login(@Validated @RequestBody LoginRequest loginRequest) {
		Authentication authentication = 
				authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginRequest.getUsername(),
							loginRequest.getPassword()	
						)							
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserEntity user = (UserEntity) authentication.getPrincipal();
		String jwtToken = tokenProvider.generateToken(authentication);
		
		return convertUserEntityAndTokenToJwtUserResponse(user, jwtToken);
				
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/user/me")
	public GetUserDto me(@AuthenticationPrincipal UserEntity user) {
		return converter.convertUserEntityToGetUserDto(user);
	}
	
	private JwtUserResponse convertUserEntityAndTokenToJwtUserResponse(UserEntity user, String jwtToken) {
		return JwtUserResponse
				.jwtUserResponseBuilder()
				.username(user.getUsername())
				.fullName(user.getFullName())
				.roles(user.getRoles().stream().map(UserRole::name).collect(Collectors.toSet()))
				.token(jwtToken)
				.build();
		
	}
	

}
