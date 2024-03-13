package com.test.api.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor @Builder
public class CreateUserDto {
	private String username;
	private String fullname;
	private String password;
	private String password2;
}
