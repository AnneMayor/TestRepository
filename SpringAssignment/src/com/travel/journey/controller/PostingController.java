package com.travel.journey.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travel.journey.dto.Travel;
import com.travel.journey.service.TravelService;

@Controller
@RequestMapping("/file")
public class PostingController {
	@Autowired
	private ServletContext servletContext;

	@Autowired
	private TravelService travelService;
	

	@RequestMapping("/mainimage1")
	public void download1(
			HttpServletResponse response, 
			@RequestHeader("User-Agent") String userAgent) throws Exception {
		String fileName = "austrailia1.jpg";
		String encodingFileName;
		if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}

		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		response.addHeader("Content-Type", "image/jpeg");
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/austrailia1.jpg"));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
	
	@RequestMapping("/mainimage2")
	public void download2(
			HttpServletResponse response, 
			@RequestHeader("User-Agent") String userAgent) throws Exception {
		String fileName = "spain1.jpg";
		String encodingFileName;
		if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}

		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		response.addHeader("Content-Type", "image/jpeg");
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/spain1.jpg"));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
	
	@RequestMapping("/mainimage3")
	public void download3(
			HttpServletResponse response, 
			@RequestHeader("User-Agent") String userAgent) throws Exception {
		String fileName = "내일로1.jpg";
		String encodingFileName;
		if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}

		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		response.addHeader("Content-Type", "image/jpeg");
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/내일로1.jpg"));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
	
	@RequestMapping("/mainimage4")
	public void download4(
			HttpServletResponse response, 
			@RequestHeader("User-Agent") String userAgent) throws Exception {
		String fileName = "japan_summer1.jpg";
		String encodingFileName;
		if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}

		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		response.addHeader("Content-Type", "image/jpeg");
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/japan_summer1.jpg"));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
	
	@RequestMapping("/mainimage5")
	public void download5(
			HttpServletResponse response, 
			@RequestHeader("User-Agent") String userAgent) throws Exception {
		String fileName = "japan_winter1.JPG";
		String encodingFileName;
		if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}

		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		response.addHeader("Content-Type", "image/jpeg");
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/japan_winter1.JPG"));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
	
	@RequestMapping("/mainimage6")
	public void download6(
			HttpServletResponse response, 
			@RequestHeader("User-Agent") String userAgent) throws Exception {
		String fileName = "usa1.JPG";
		String encodingFileName;
		if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}

		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		response.addHeader("Content-Type", "image/jpeg");
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/usa1.JPG"));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
	
	@RequestMapping("/mainimage7")
	public void download7(
			HttpServletResponse response, 
			@RequestHeader("User-Agent") String userAgent) throws Exception {
		String fileName = "canada1.JPG";
		String encodingFileName;
		if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}

		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		response.addHeader("Content-Type", "image/jpeg");
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/canada1.JPG"));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
	
	@RequestMapping("/austrailia")
	public void imageShow(HttpServletResponse response, 
			@RequestHeader("User-Agent") String userAgent, int tnumber) throws Exception {
		Travel travel = travelService.getTravel(tnumber);
		String fileName = travel.getToriginalfilename();
		System.out.println(fileName);
		String encodingFileName;
		if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		
		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		response.addHeader("Content-Type", "image/jpeg");
		File file = new File(servletContext.getRealPath(travel.getTfilecontent()));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
}