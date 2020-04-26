package com.cg.pecuniabank.passbook.exception;

public class AccountDoesntExistException extends RuntimeException {
	private static final long serialVersionUID=1;
	
	public AccountDoesntExistException(String msg){
		super(msg);
	}
}
