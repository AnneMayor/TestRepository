package com.mycompany.myapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Exam10Dao3ImplA implements Exam10Dao3{
	
	// private으로 바깥에 노출이 안되므로 소문자로 해도 됨.
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam10Dao3ImplA.class);
	
	public void insert() {
		LOGGER.info("회원가입");
	}
	
	public void select() {
		LOGGER.info("회원검색");
	}
}
