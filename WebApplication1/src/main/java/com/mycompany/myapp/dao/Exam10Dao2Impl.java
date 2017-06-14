package com.mycompany.myapp.dao;

import org.springframework.stereotype.Component;

@Component
public class Exam10Dao2Impl implements Exam10Dao2{
	
	public void insert() {
		System.out.println("Exam10Dao2 insert()");
	}
	
	
	public void select() {
		System.out.println("Exam10Dao2 select()");
	}
}
