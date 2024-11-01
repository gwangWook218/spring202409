package com.akw.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akw.dto.CustDTO;
import com.akw.dto.InjectionDTO;
import com.akw.dto.OrderDTO;
import com.akw.service.CustService;
import com.akw.service.InjectionService;
import com.akw.service.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final CustService custService;
	private final InjectionService injectionService;
	private final OrderService orderService;
	
//	주사접종
	@GetMapping("/saveOrder")
	public String save() {
		return "saveOrder";
	}
	
	@PostMapping("/{id}")
	public String save(OrderDTO dto) {
		orderService.save(dto);
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String findAllOrder(Model model) {
		List<OrderDTO> list = orderService.findAll();
		model.addAttribute("orderList", list);
		return "index";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable("id") Integer id, Model model) {
		OrderDTO dto = orderService.findById(id);
		model.addAttribute("order", dto);
		return "detail";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Integer id, Model model) {
		OrderDTO dto = orderService.findById(id);
		return "update";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
		orderService.delete(id);
		return "redirect:/";
	}
	
//	회원목록 조회
	@GetMapping("/listCust")
	public String listCust(Model model) {
		List<CustDTO> list = custService.findAll();
		model.addAttribute("custList", list);
		return "list_cust";
	}
	
//	백신별 접종 조회
	@GetMapping("/listInjection")
	public String listInjection(Model model) {
		List<InjectionDTO> list = injectionService.findAll();
		model.addAttribute("injectionList", list);
		return "list_injection";
	}
}
