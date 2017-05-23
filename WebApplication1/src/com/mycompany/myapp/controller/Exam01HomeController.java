package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam01HomeController {
	// 이건 굳이 파이널일 필요가 없으나 어차피 한 개의 객체만 생성해서 사용할 것이기에 이렇게 선언
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam01HomeController.class);
	
	@RequestMapping("/")
	public String home() {
		LOGGER.info("/요청 처리함");
		System.out.println("home()");
		return "home";
	}	
}