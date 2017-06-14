package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.myapp.Exception.NoAccountException;
import com.mycompany.myapp.dao.Exam15Dao;
import com.mycompany.myapp.dto.Exam15Account;

@Component
public class Exam15ServiceImpl implements Exam15Service {

	@Autowired
	private Exam15Dao dao;

	@Override
	public Exam15Account getAccount(String ano) {
		return dao.selectByAno(ano);
	}

	@Override
	public void deposit(String ano, int amount) {
		Exam15Account account = dao.selectByAno(ano);
		account.setAbalance(account.getAbalance() + amount);
		dao.update(account);
	}

	@Override
	public void withdraw(String ano, int amount) {
		Exam15Account account = dao.selectByAno(ano);
		account.setAbalance(account.getAbalance() - amount);
		dao.update(account);
	}

	@Override
	// 트랜잭션에선 반.드.시 예외처리를 해줘야 한다!!!!!!!!!!
	@Transactional
	// 위의 어노테이션이 선언된 메소드에서 런타임 예외가 발생하면 자동으로 rollback을 해준다!!!!
	public void transfer(String fromAno, String toAno, int amount) throws NoAccountException {
		Exam15Account fromAccount = dao.selectByAno(fromAno);
		if (fromAccount != null) {
			fromAccount.setAbalance(fromAccount.getAbalance() - amount);
			dao.update(fromAccount);
		} else {
			throw new NoAccountException("출금 계좌가 존재하지 않음.");
		}

		Exam15Account toAccount = dao.selectByAno(toAno);
		if (toAccount != null) {
			toAccount.setAbalance(toAccount.getAbalance() + amount);
			dao.update(toAccount);
		} else {
			throw new NoAccountException("입금 계좌가 존재하지 않음.");
		}
	}
}