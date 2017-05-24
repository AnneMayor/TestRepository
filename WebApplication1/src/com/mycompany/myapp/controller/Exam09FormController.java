package com.mycompany.myapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
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
	
	@RequestMapping(value="/form/exam01",method=RequestMethod.GET)
	public String joinForm() {
		return "form/exam01";
	}
	
	@RequestMapping(value="/form/exam01",method=RequestMethod.POST)
	public String join(String mid, String mname, String mpassword, @RequestParam(defaultValue = "0")int mage, String[] mskill, String mbirth) {
		System.out.println("mid: " + mid);
		System.out.println("mname: " + mname);
		System.out.println("mpassword: " + mpassword);
		System.out.println("mage: " + mage);
		System.out.println("mskill: " + Arrays.toString(mskill));
		System.out.println("mbirth: " + mbirth);
		return "form/exam01";
	}
	
	@RequestMapping(value="/form/exam02",method=RequestMethod.GET)
	public String JoinForm2() {
		return "form/exam02";
	}
	@RequestMapping(value="/form/exam02",method=RequestMethod.POST)
	public String Join2(
			String mid,
			String mname,
			String mpassword,
			@RequestParam(defaultValue = "0")int mage,
			String[] mskill,
			String mbirth,
			MultipartFile attach) throws Exception {
		
		//�뙆�씪 �젙蹂� 異쒕젰
		String fileName = attach.getOriginalFilename();
		String contentType = attach.getContentType();
		long filesize = attach.getSize();
		//�뙆�씪 �꽌踰� �븯�뱶�뵒�뒪�겕�뿉 ���옣
		String realPath = servletContext.getRealPath("/WEB-INF/upload/" + fileName);
		File file = new File(realPath);
		attach.transferTo(file);
		
		System.out.println(fileName);
		System.out.println(contentType);
		System.out.println(filesize);
		
		return "form/exam02";
	}
	
	@RequestMapping("/file/exam03")
	public void download(
			HttpServletResponse response,
			@RequestHeader("User-Agent") String userAgent) throws Exception{
		//�쓳�떟 HTTP �뿤�뜑�뻾 異붽�
		//1)�뙆�씪�쓽 �씠由�(�샃�뀡)
		String fileName = "펭귄.png";
		String encodingFileName;
		if(userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
			//System.out.println(encodingFileName);
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			//System.out.println(encodingFileName);					
		}
		
		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		//2)�뙆�씪�쓽 醫낅쪟
		response.addHeader("Content-Type", "image/png");
		//2* 釉뚮씪�슦���뿉 �뵲瑜� �씤肄붾뵫 諛⑸쾿
		//3)�뙆�씪�쓽 �겕湲�(�샃�뀡)
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/penguins.jpg"));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));
		//媛��뒫�븯硫� �꽭 媛� �떎 �꽔�뼱以� 寃�
		//�쓳�떟 HTTP 蹂몃Ц�뿉 �뙆�씪 �뜲�씠�꽣瑜� 異쒕젰
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
	
}