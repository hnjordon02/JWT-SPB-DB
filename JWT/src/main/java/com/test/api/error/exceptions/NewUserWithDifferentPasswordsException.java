package com.test.api.error.exceptions;

public class NewUserWithDifferentPasswordsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NewUserWithDifferentPasswordsException() {
		super("Las contraseñas no coinciden.");
	}
	

}
