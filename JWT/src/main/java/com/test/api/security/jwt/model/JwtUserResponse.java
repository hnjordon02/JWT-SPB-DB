package com.test.api.security.jwt.model;

import java.util.Set;

import com.test.api.users.dto.GetUserDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtUserResponse extends GetUserDto{

	private String token;
	
	@Builder(builderMethodName = "jwtUserResponseBuilder")
	public JwtUserResponse(String username, String fullName,Set<String> roles, String token) {
		super(username,fullName,roles);
		this.token = token;
	}
}
