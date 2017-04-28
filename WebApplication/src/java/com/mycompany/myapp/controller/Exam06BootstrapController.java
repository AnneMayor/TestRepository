package com.mycompany.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam06BootstrapController {

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
