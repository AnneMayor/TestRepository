package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam12Dao;
import com.mycompany.myapp.dto.Exam07Board;
import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12Service1Impl implements Exam12Serivce1 {

	@Autowired
	private Exam12Dao exam12Dao;
	
	@Override
	public void write(Exam12Board board) {
		exam12Dao.insert1(board);
	}

	@Override
	public void join(Exam12Member member) {
		exam12Dao.insert2(member);
	}
}