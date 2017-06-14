package com.mycompany.myapp.service;

import com.mycompany.myapp.dao.Exam10Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Exam10Service1Impl implements Exam10Service1{
	@Autowired
	private Exam10Dao1 exam10Dao;
	
	@Override
	public void join() {
		System.out.println("Exam10Service1 join()");
		exam10Dao.insert();
	}
	
	@Override
	public void login() {
		System.out.println("Exam10Service1 login()");
		exam10Dao.select();
	}
}
