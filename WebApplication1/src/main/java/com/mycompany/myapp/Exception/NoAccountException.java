package com.mycompany.myapp.Exception;

// Spring에선 사용자정의(트랜잭션) 예외처리를 하려면 "반.드.시" RumtimeException이여야 가능!!!
// try-catch 발생문을 잡으려면 extends Exception이고 런타임 예외처리 하려면 extends RuntimeException
public class NoAccountException extends RuntimeException {
	
	public NoAccountException() {}
	public NoAccountException(String message) {
		super(message);
	}
}
