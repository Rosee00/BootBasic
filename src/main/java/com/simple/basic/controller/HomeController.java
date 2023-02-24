package com.simple.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //@컨트롤러를 보고 빈으로 등록됨
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home"; //아무런 기본 설정이 없을때 templates밑에 설정된 home파일을 따라가게 된다
	}
	
}
