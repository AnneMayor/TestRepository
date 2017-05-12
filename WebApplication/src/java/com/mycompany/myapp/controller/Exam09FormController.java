package com.mycompany.myapp.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContext;
import org.apache.catalina.tribes.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Exam09FormController {

  @Autowired
  private ServletContext servletContext;
  
  @RequestMapping(value = "/form/exam01", method = RequestMethod.GET)
  // 나중에 저 이름을 "member/join" 요렇게 바꿔주기
  public String joinForm() {
    return "form/exam01";
  }

  @RequestMapping(value = "/form/exam01", method = RequestMethod.POST)
  public String join(@RequestParam String mid, @RequestParam String mname, @RequestParam String mpassword, @RequestParam(defaultValue = "0") int mage, @RequestParam String[] mskill, @RequestParam String mbirth) {
    // 이건 나이가 꼭 값이 넘어오도록 해주는 코드
    System.out.println("mid: " + mid);
    System.out.println("mname: " + mname);
    System.out.println("mpassword: " + mpassword);
    System.out.println("mage: " + mage);
    System.out.println("mskill: " + Arrays.toString(mskill));
    System.out.println("mbirth: " + mbirth);
    return "form/exam01";
  }

  @RequestMapping(value = "/form/exam02", method = RequestMethod.GET)
  public String joinForm2() {
    return "form/exam02";
  }
  
  @RequestMapping(value = "/form/exam02", method = RequestMethod.POST)
  public String join2(String mid, 
          String mname, 
          String mpassword, 
          @RequestParam(defaultValue = "0") int mage, 
          String[] mskill, 
          String mbirth, 
          MultipartFile attach) throws IOException {
    
    // 파일의 정보 얻기
    String fileName = attach.getOriginalFilename();
    String contentType = attach.getContentType();
    long fileSize = attach.getSize();
    
    // 파일을 서버 하드디스크에 저장(동적 절대주소 알아내는 방법) -> 시행해보면 build한 폴더 안에 동영상 저장됨.(동적 절대주소는 프로젝트 파일 위치가 실제 위치가 아니라 빌드한 file위치가 실제 경로
    // 파일 저장방법: 1. 프로젝트 file에 업로드 2. DB에 업로드
    String realPath = servletContext.getRealPath("/WEB-INF/upload/" + fileName);
    File file = new File(realPath);
    attach.transferTo(file);
    
    System.out.println("fileName: " + fileName);
    System.out.println("contentType: " + contentType);
    System.out.println("fileSize: " + fileSize);
    
    return "form/exam02";
  }
}
