package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.Form;

@Controller
public class RequestParamController {

	@GetMapping("show")
	public String shoeView() {
		return "entry";
	}
	
	@PostMapping("confirm")
	public String confirmView(Form f) {
		return "confirm2";
	}
}
