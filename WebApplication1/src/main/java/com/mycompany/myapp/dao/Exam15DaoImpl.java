package com.mycompany.myapp.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam15Account;

@Component
public class Exam15DaoImpl implements Exam15Dao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Exam15Account selectByAno(String ano) {
		Exam15Account account = sqlSessionTemplate.selectOne("account.selectByAno", ano);
		return account;
	}

	@Override
	public int update(Exam15Account account) {
		// 만약, where조건절이 PK가 아닌 중복값이 허용될 경우 1이상의 리턴값이 나올 수 있음.(insert는 보통 PK값이 리턴되게 함.)
		int row = sqlSessionTemplate.update("account.update", account);
		return row;
	}
}