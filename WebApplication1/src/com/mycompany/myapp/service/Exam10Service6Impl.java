package com.mycompany.myapp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Exam10Dao3;

@Component
public class Exam10Service6Impl implements Exam10Service6 {

	// @Autowired - 타입을 기준
	// Resource는 자바에서 제공하는 어노테이션이고 Autowired는 Spring에서 제공하는 어노테이션
	// 이름이 겹치는 경우엔 동작 제대로 안할 수 있음.
	@Resource(name="exam10Dao3ImplA")
	private Exam10Dao3 exam10Dao3;
	
	@Override
	public void join() {
		System.out.println("Exam10Service6 회원가입");
		exam10Dao3.insert();
	}

	@Override
	public void login() {
		System.out.println("Exam10Service6 로그인");
		exam10Dao3.select();
	}
}