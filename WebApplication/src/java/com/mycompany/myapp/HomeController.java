package com.mycompany.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String home() {
    System.out.println("home");
    return "home";
  }

  @RequestMapping("/html")
  public String html() {
    return "html";
  }

  @RequestMapping("/css/exam01")
  public String cssExam01() {
    return "css/exam01";
  }

  @RequestMapping("/css/exam02")
  public String cssExam02() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "css/exam02";
  }

  @RequestMapping("/css/exam03")
  public String cssExam03() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "css/exam03";
  }

  @RequestMapping("/javascript/exam01")
  public String javascriptExam01() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "javascript/exam01";
  }

  @RequestMapping("/javascript/exam02")
  public String javascriptExam02() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "javascript/exam02";
  }

  @RequestMapping("/javascript/exam03")
  public String javascriptExam03() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "javascript/exam03";
  }

  @RequestMapping("/javascript/exam04")
  public String javascriptExam04() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "javascript/exam04";
  }

  @RequestMapping("/bootstrap/exam01")
  public String bootstrapExam01() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "bootstrap/exam01";
  }

  @RequestMapping("/bootstrap/exam02")
  public String bootstrapExam02() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "bootstrap/exam02";
  }

  @RequestMapping("/bootstrap/exam03")
  public String bootstrapExam03() { // 이 메소드 이름은 아무거나 상관없음. 잘 알아두자!이런게 내 코딩할 때 무쟈게 중요하게 작용한다...
    return "bootstrap/exam03";
  }
}
