package com.cg.pecuniabank.passbook.exception;

public class TransactionFailedException extends Exception
{
	
	private static final long serialVersionUID = 1L;

	public TransactionFailedException(String msg)
	{
		super(msg);
	}
}
