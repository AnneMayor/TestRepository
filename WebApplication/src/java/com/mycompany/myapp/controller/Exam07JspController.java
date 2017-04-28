package com.mycompany.myapp.controller;

import com.mycompany.myapp.dto.Board;
import com.mycompany.myapp.dto.Member;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class Exam07JspController {

  @RequestMapping("/exam01")
  public String exam01() {
    return "jsp/exam01";
  }

  @RequestMapping("/exam02")
  public String exam02() {
    return "jsp/exam02";
  }

  @RequestMapping("/exam03")
  public String exam03() {
    return "jsp/exam03";
  }

  @RequestMapping("/exam04")
  public String exam04(Model model) {
    model.addAttribute("name2", "홍길동");
    model.addAttribute("member2", new Member("홍길동", 30));
    return "jsp/exam04";
  }

  @RequestMapping("/exam05")
  public String exam05(Model model) {
    model.addAttribute("name3", "LEE");
    model.addAttribute("member3", new Member("Jang", 20));

    Board board = new Board();
    board.setBno(1);
    board.setBcontent("Java");
    board.setBdate(new Date());
    board.setBwriter("Lee");
    model.addAttribute("board", board);

    return "jsp/exam05";
  }
}
