package com.capgemini.pecuniabank.exception;

public class UserDefinedException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserDefinedException(String msg) {
		super(msg);
	}

}
