package com.travel.journey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String mainpage() {
		return "mainpage";
	}
	
	@RequestMapping("/postinglist")
	public String postinglist() {
		return "postinglist";
	}
}