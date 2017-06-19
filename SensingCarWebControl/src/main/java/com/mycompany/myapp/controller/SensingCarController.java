package com.mycompany.myapp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.service.SensingCarService;

@Controller
public class SensingCarController {
	
	@Autowired
	private SensingCarService sensingCar;
	
	private static final Logger logger = LoggerFactory.getLogger(SensingCarController.class);
//	
//	@RequestMapping("/")
//	public String home() {
//		return "home";
//	}

	// RequestMapping 경로를 Ajax에서 요청하면 HTML 혹은 Json 포멧으로 선언 가능
	@RequestMapping("/ultrasonicsensor")
	public void ultrasonicsensor(@RequestParam(defaultValue="90")int angle,
			HttpServletResponse response) throws Exception {
		sensingCar.changeUltrasonicSensorAngle(angle);
		Thread.sleep(500);
		int distance = sensingCar.getUltrasonicSensorDistance();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("distance", distance);
		String json = jsonObject.toString();
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}	
}