package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
	
	@GetMapping("show")
	public String showView(Model model) {
//		Model에 데이터 추가
		model.addAttribute("name", "이순신");
		
//		반환값으로 뷰 이름을 설정
		return "useThymeleaf";
	}
}
