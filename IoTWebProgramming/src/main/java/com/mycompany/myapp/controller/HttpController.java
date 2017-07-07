package com.mycompany.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller	
@RequestMapping("/http")
public class HttpController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpController.class);
	
	@RequestMapping("/exam01")
	public String exam01(
			@RequestParam(defaultValue="0")double thermistor, @RequestParam(defaultValue="0")double photoResistor, Model model) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		model.addAttribute("thermistor", thermistor);
		model.addAttribute("photoResistor", photoResistor);
		return "http/exam01";
	}
	
	@RequestMapping("/exam02")
	public String exam02(String title, String content, MultipartFile attach, Model model) throws Exception {
		// 중복이미지파일 저장을 막기위해 시간정보를 넣어줌.
		String savedfilename = new Date().getTime() + "-" + attach.getOriginalFilename();
		String savedfilepath = "C:/Temp/" + savedfilename;
		attach.transferTo(new File( savedfilepath ));	
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		model.addAttribute("originalfilename", attach.getOriginalFilename());
		model.addAttribute("filecontent", attach.getContentType());
		model.addAttribute("savedfilename", savedfilename);
		return "http/exam02";
	}
	
	@RequestMapping("/exam03")
	public void exam03(String param1, String param2, HttpServletResponse response) throws IOException {
		LOGGER.info(param1);
		LOGGER.info(param2);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("param1", param1);
		jsonObject.put("param2", param2);
		String json = jsonObject.toString();
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}
	
	@RequestMapping("/exam04")
	public void exam04(String param1, String param2, MultipartFile attach, HttpServletResponse response) throws IOException {
		LOGGER.info(param1);
		LOGGER.info(param2);
		LOGGER.info(attach.getOriginalFilename());
		LOGGER.info(attach.getContentType());
		LOGGER.info(String.valueOf(attach.getSize()));
		
		String fileName = new Date().getTime() + attach.getOriginalFilename();
		attach.transferTo(new File("C:/Temp/" + fileName));
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("param1", param1);
		jsonObject.put("param2", param2);
		jsonObject.put("fileName", attach.getOriginalFilename());
		jsonObject.put("fileSize", attach.getSize());
		jsonObject.put("fileType", attach.getContentType());
		String json = jsonObject.toString();
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}
}