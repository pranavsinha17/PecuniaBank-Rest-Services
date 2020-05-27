package com.capgemini.main.exception;


/****************************
 *          @author          Pranav Sinha
 *          Description      It is a service class that provides the services for User Exception
  *         Version             1.0
  *         Created Date    15-APR-2020
 ****************************/
public class UserException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserException(String msg)
	{
		super(msg);
	}

}
