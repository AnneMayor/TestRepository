package com.mycompany.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam05JqueryController {

  @RequestMapping("/jquery/exam01")
  public String jqueryExam01() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "jquery/exam01";
  }

  @RequestMapping("/jquery/exam02")
  public String jqueryExam02() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "jquery/exam02";
  }

  @RequestMapping("/jquery/exam03")
  public String jqueryExam03() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "jquery/exam03";
  }

  @RequestMapping("/jquery/exam04")
  public String jqueryExam04() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "jquery/exam04";
  }

  @RequestMapping("/jquery/exam04_html_fragement")
  public String jqueryExam04HtmlFragment() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "jquery/exam04_html_fragement";
  }

  @RequestMapping("/jquery/exam04_json")
  public String jqueryExam04Json() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "jquery/exam04_json";
  }

}
