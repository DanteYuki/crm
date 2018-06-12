package com.xykj.base.exception;

/**
 * 登陆异常
 */
public class RsyLoginException extends Exception{
	private static final long serialVersionUID = 8002244930973335608L;
	
	public RsyLoginException(){
		super();
	}
	
	public RsyLoginException(String message) {
		super(message);
	}
}
