package com.mycompany.myapp.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mycompany.myapp.dto.Exam13Member;

@Controller
// @SessionAttributes(value=new String[]{"name1", "name2", "member"})
// 아래 어노테이션의 의미: Request에 저장되는 키와 값을 Session에 저장하겠다는 명령어
// 하나의 키만 사용할 경우, "name1" 이렇게만 써주면 된다.
@SessionAttributes(value = { "name1", "name2", "member" })
public class Exam13CookieAndSessionController {
	private Logger logger = LoggerFactory.getLogger(Exam13CookieAndSessionController.class);

	@RequestMapping("/cookie/exam01")
	public String exam01(HttpServletResponse response) throws Exception {

		// 쿠키 생성
		// 여기서 주의할 점!: 반드시 아스키 문자로 cookie이름과 값을 넣어줘야한다!
		Cookie cookie = new Cookie("name1", "DahyeLee");
		String name2 = "홍길동";

		// 이 작업을 url인코딩이라고 함.(이건 단순히 변환해서 전송하는 기능을 담당)
		name2 = URLEncoder.encode(name2, "UTF-8");
		Cookie cookie1 = new Cookie("name2", name2);
		cookie1.setMaxAge(30 * 24 * 60 * 60);
		// 쿠키를 응답 헤더에 추가
		// set메소드: 변경, add메소드: 추가
		// 여기에서 Window -> Show View -> Others -> Debug -> TCP/IP Monitor 프로그램 실행
		response.addCookie(cookie);
		response.addCookie(cookie1);

		return "cookie/exam01";
	}

	// @RequestMapping("/cookie/exam02")
	// public String exam02(HttpServletRequest request, Model model) throws
	// Exception {
	// String name1 = null;
	// String name2 = null;
	// Cookie[] cookies = request.getCookies();
	// for(Cookie cookie : cookies) {
	// if(cookie.getName().equals("name1")) {
	// name1 = cookie.getValue();
	// } else if(cookie.getName().equals("name2")) {
	// name2 = cookie.getValue();
	// name2 = URLDecoder.decode(name2, "UTF-8");
	// }
	// }
	//
	// model.addAttribute("name1", name1);
	// model.addAttribute("name2", name2);
	// return "cookie/exam02";
	// }
	// exam02까지 스프링을 사용하지 않았을 경우의 쿠키를 보는 방법.
	// 스프링 활용하면 무척 간단해짐.

	@RequestMapping("/cookie/exam02")
	// CookieValue 어노테이션: 이건 쿠키 키에다 매개변수로 선언해준 값을 넣어준다는 의미
	// defaultValue="" 의미: 쿠키가 들어오지 않으면 빈 문자열로 출력
	public String exam02(@CookieValue(defaultValue = "") String name1, @CookieValue(defaultValue = "") String name2,
			Model model) throws Exception {
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

	// @RequestMapping("/session/exam04")
	// public String exam04(HttpSession session) {
	// // 세션에 문자열 정보를 저장
	// session.setAttribute("name1", "Dahye Lee");
	// session.setAttribute("name2", "이다혜");
	// // 문자뿐만 아니라 객체도 세션에 저장 가능
	// Exam13Member member = new Exam13Member();
	// member.setMname("Spring");
	// session.setAttribute("member", member);
	// return "redirect:/";
	// }

	@RequestMapping("/session/exam04")
	public String exam04(Model model) {
		model.addAttribute("name1", "Dahye Lee");
		model.addAttribute("name2", "이다혜");
		Exam13Member member = new Exam13Member();
		member.setMname("Spring");
		model.addAttribute("member", member);
		return "redirect:/";
	}

	// @RequestMapping("/session/exam05")
	// public String exam05(HttpSession session) {
	// String name1 = (String) session.getAttribute("name1");
	// String name2 = (String) session.getAttribute("name2");
	// Exam13Member member = (Exam13Member) session.getAttribute("member");
	//
	// // logger.debug(name1);
	// // logger.debug(name2);
	// // logger.debug(member.getMname());
	// //
	// return "session/exam05";
	// }

	@RequestMapping("/session/exam05")
	// @ModelAttribute의 의미: Model을 통해서 저장된 키와 값을 불러오는 명령어
	public String exam05(@ModelAttribute String name1, @ModelAttribute String name2,
			@ModelAttribute Exam13Member member) {
		logger.debug(name1);
		logger.debug(name2);
		logger.debug(member.getMname());
		return "session/exam05";
	}

//	@RequestMapping("/session/exam06")
//	// @ModelAttribute의 의미: Model을 통해서 저장된 키와 값을 불러오는 명령어
//	// 세션에서 삭제해도 Model에는 남아있을 수 있다.
//	// @SessionAttributes대신 HttpRequest를 사용하자!
//	// Model값이 남아있기에 서버 세션 읽기를 하면 Model값들을 읽어오는 것!이 점 명심하자!그러니 HttpSession대신 SessionStatus를 활용하도록 하자!
//	public String exam06(HttpSession session) {
//		session.removeAttribute("name1");
//		session.removeAttribute("name2");
//		session.removeAttribute("member");
//		return "redirect:/";
//	}
	
	@RequestMapping("/session/exam06")
	public String exam06(SessionStatus sessionStatus) {
		// 세션에 있는 모든 정보를 삭제
		// @SessionAttributes를 사용할 경우 이용
		sessionStatus.setComplete();
		return "redirect:/";
	}
}