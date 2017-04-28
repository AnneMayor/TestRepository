package com.mycompany.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/css")
public class Exam03CssController {

  @RequestMapping("/exam01")
  public String cssExam01() {
    return "css/exam01";
  }

  @RequestMapping("/exam02")
  public String cssExam02() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "css/exam02";
  }

  @RequestMapping("/exam03")
  public String cssExam03() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "css/exam03";
  }
}
