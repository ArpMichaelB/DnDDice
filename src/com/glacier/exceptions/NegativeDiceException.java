package com.glacier.exceptions;

public class NegativeDiceException extends NumberFormatException {
	private static final long serialVersionUID = 1L;
	public NegativeDiceException()
	{
		super();
	}
	public NegativeDiceException(String message)
	{
		super(message);
	}
}
