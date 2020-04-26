package com.cg.pecuniabank.passbook.exception;

public class TransactionsNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public TransactionsNotFoundException(String msg)
	{
		super(msg);
	}
}
