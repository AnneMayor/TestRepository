package com.mycompany.myapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Exam10Dao1Impl implements Exam10Dao1{
	
	public void insert() {
		System.out.println("insert()");
	}
	
	
	public void select() {
		System.out.println("select()");
	}
}
