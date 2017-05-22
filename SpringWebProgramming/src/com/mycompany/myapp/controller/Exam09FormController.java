package com.mycompany.myapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.tribes.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestHeader;
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

  // 파일을 다운로드하는 것 이외에는 다 웹클라이언트에게 보이는 views의 jsp파일을 리턴.
  @RequestMapping("/file/exam03")
  public void download(HttpServletResponse response, @RequestHeader("User-Agent") String userAgent) throws Exception {
    // 응답 HTTP 헤더행을 추가
    // 1) 파일 이름(옵션)
    String fileName = "사막.jpg";
    String encodingFileName;
    if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
      // 파일이름을 UTF-8로 변환하여 바이트 배열을 얻고 이를 16진수화 시키는 역할을 하는 encoder
      encodingFileName = URLEncoder.encode(fileName, "UTF-8");
    } else {
      encodingFileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
    }
    // "첨부파일"이니 반드시 웹클라이언트(웹브라우져)는 저장해서 다운로드해야 한다. 
    // 파일이름 경로작성을 위해 역슬래쉬('\')를 넣어줌.
    response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
    // 2) 파일 종류(필수)
    response.addHeader("Content-Type", "image/jpeg");
    // 3) 파일 크기(옵션)
    File file = new File(servletContext.getRealPath("/WEB-INF/upload/사막.jpg"));
    long fileSize = file.length();
    response.addHeader("Content-Length", String.valueOf(fileSize));

    // 응답 HTTP 본문에 파일 데이터 출력
    OutputStream os = response.getOutputStream();
    FileInputStream fis = new FileInputStream(file);
    FileCopyUtils.copy(fis, os);
    os.flush();
    fis.close();
    os.close();
  }
}
