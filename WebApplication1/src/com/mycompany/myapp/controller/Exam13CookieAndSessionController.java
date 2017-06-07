package com.mycompany.myapp.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam13CookieAndSessionController {
	@RequestMapping("/cookie/exam01")
	public String exam01(HttpServletResponse response) throws Exception {
		
		// 쿠키 생성
		// 여기서 주의할 점!: 반드시 아스키 문자로 cookie이름과 값을 넣어줘야한다!
		Cookie cookie = new Cookie("name1", "DahyeLee");
		String name2 = "홍길동";
		
		// 이 작업을 url인코딩이라고 함.(이건 단순히 변환해서 전송하는 기능을 담당)
		name2 = URLEncoder.encode(name2, "UTF-8");
		Cookie cookie1 = new Cookie("name2", name2);
		cookie1.setMaxAge(30*24*60*60);
		// 쿠키를 응답 헤더에 추가
		// set메소드: 변경, add메소드: 추가
		// 여기에서 Window -> Show View -> Others -> Debug -> TCP/IP Monitor 프로그램 실행
		response.addCookie(cookie);
		response.addCookie(cookie1);
		
		return "cookie/exam01";
	}
	
//	@RequestMapping("/cookie/exam02")
//	public String exam02(HttpServletRequest request, Model model) throws Exception {
//		String name1 = null;
//		String name2 = null;
//		Cookie[] cookies = request.getCookies();
//		for(Cookie cookie : cookies) {
//			if(cookie.getName().equals("name1")) {
//				name1 = cookie.getValue();
//			} else if(cookie.getName().equals("name2")) {
//				name2 = cookie.getValue();
//				name2 = URLDecoder.decode(name2, "UTF-8");
//			}
//		}
//		
//		model.addAttribute("name1", name1);
//		model.addAttribute("name2", name2);
//		return "cookie/exam02";
//	}
	// exam02까지 스프링을 사용하지 않았을 경우의 쿠키를 보는 방법.
	// 스프링 활용하면 무척 간단해짐.
	
	@RequestMapping("/cookie/exam02")
	// CookieValue 어노테이션: 이건 쿠키 키에다 매개변수로 선언해준 값을 넣어준다는 의미
	// defaultValue="" 의미: 쿠키가 들어오지 않으면 빈 문자열로 출력
	public String exam02(@CookieValue(defaultValue="") String name1, @CookieValue(defaultValue="") String name2, Model model) throws Exception {
		model.addAttribute("name1", name1);
		model.addAttribute("name2", name2);
		return "cookie/exam02";
	}
	
	// Cookie 삭제 실행(쿠키 나이 설정 -> '0': 쿠키를 지금 당장 삭제하겠다는 의미
	@RequestMapping("/cookie/exam03")
	public String exam03(HttpServletResponse reponse) {
		Cookie cookie1 = new Cookie("name1", "");
		Cookie cookie2 = new Cookie("name2", "");
		
		cookie1.setMaxAge(0);
		cookie2.setMaxAge(0);
		
		reponse.addCookie(cookie1);
		reponse.addCookie(cookie2);
		return "redirect:/";
	}
}