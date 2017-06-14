package com.mycompany.myapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam14AopController {
	// 1번은 로그인이 없이 실행할 수 있는 페이지
	@RequestMapping("/aop/exam01")
	public String exam01(HttpSession session) {
		session.setAttribute("mid", "spring");
		return "aop/exam01";
	}
	
	// 2번은 로그인 여부 검사후 실행할 수 있는 페이지
	// 원래라면 여기에 로그인 여부 검사 코드 작성해야하나 그렇게 하지않고 aop를 활용할 계획
	@RequestMapping("/aop/exam02Write")
	public String exam02Write() {
		return "aop/exam02";
	}
	
	@RequestMapping("/aop/exam02Update")
	public String exam02Update() {
		return "aop/exam02";
	}
}
