package com.mycompany.myapp.controller;

import com.mycompany.myapp.dto.Board;
import com.mycompany.myapp.dto.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    List<Board> list = new ArrayList<Board>();
    for (int i = 1; i <= 10; i++) {
      Board b= new Board();
      b.setBno(i);
      b.setBtitle("Title" + i);
      b.setBcontent("Java");
      b.setBdate(new Date());
      b.setBwriter("Lee" + i);
      list.add(b);
    }
    model.addAttribute("list", list);
    return "jsp/exam05";
  }
}