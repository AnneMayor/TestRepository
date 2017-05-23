package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao1;

@Component
public class Exam10Service2Impl implements Exam10Service2{
	
	// setter 주입
	private Exam10Dao1 exam10Dao1;
	
	@Autowired
	public void setExam10Dao2(Exam10Dao1 exam10Dao1) {
		this.exam10Dao1 = exam10Dao1;
		System.out.println("ExamDao2");
	}

	@Override
	public void join() {
		System.out.println("Exam10Service2 회원가입");
		exam10Dao1.insert();
	}

	@Override
	public void login() {
		System.out.println("Exam10Service2 로그인");
		exam10Dao1.select();
	}
}