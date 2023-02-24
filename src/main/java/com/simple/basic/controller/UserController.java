package com.simple.basic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.UsersVO;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	//로그인기능
	@PostMapping("/login")
	public String loginForm(UsersVO vo, HttpSession session) { //HttpSession을 사용하면 바로 session을 사용할 수 있음
		//select * from 유저 where id = ? and pw = ?
		//System.out.println(vo.toString());
		
		//서비스영역 호출(로그인 성공 가정)
		UsersVO userVO = new UsersVO();
		userVO.setId("aaa");
		userVO.setName("길동이");
		
		//로그인성공 - 세션을 이용해서 인증값제공(로그인 성공직후)
		if(userVO != null) {
			session.setAttribute("user_id", userVO.getId()); //토큰
			return "redirect:/user/mypage";//로그인성공
		} 
				
		return "user/login"; //로그인실패
	}
	
	//특정유저들만 접근할 수 있는 페이지
	@GetMapping("/mypage")
	public String mypage(HttpSession session) {
		//세션검사
		/*
		if(session.getAttribute("user_id") == null) {
			return "redirect:/user/login";
		}
		*/
		System.out.println("컨트롤러실행");
		
		return "user/mypage";
	}

	@GetMapping("/info")
	public String info() {
		return "user/info";
	}
}
