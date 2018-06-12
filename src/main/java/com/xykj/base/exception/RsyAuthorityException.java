package com.xykj.base.exception;

public class RsyAuthorityException extends RuntimeException{
	private static final long serialVersionUID = 5708356487065386029L;
	public RsyAuthorityException() {
		super();
	}
	
	public RsyAuthorityException(String message){
		super(message);
	}
}
