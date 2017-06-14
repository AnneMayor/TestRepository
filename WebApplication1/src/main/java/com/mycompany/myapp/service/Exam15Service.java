package com.mycompany.myapp.service;

import com.mycompany.myapp.dto.Exam15Account;

public interface Exam15Service {
	public Exam15Account getAccount(String ano);
	// 리턴값은 실제 업데이트된 행 수
	public void deposit(String ano, int amount);
	public void withdraw(String ano, int amount);
	public void transfer(String fromAno, String toAno, int amount);
}
