package com.akw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akw.dto.ArtistDTO;
import com.akw.service.ArtistService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuditionController {

	private final ArtistService artistService;
	
//	참가자 등록
	@GetMapping("/save")
	public String save() {
		return "save";
	}
	
	@PostMapping("/save")
	public String save(ArtistDTO artistDTO) {
		artistService.insertOne(artistDTO);
		return "redirect:/";
	}
	
//	참가자 확인
	@GetMapping("/basic")
	public String listBasic(Model model) {
		model.addAttribute("artistList", artistService.selectAll_basic());
		return "index";
	}
	
	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("artistList", artistService.selectAll());
		return "index";
	}
	
	@GetMapping("/{artist_id}")
	public String findById(@PathVariable("artist_id") String artist_id, Model model) {
		System.out.println("=========>>" + artist_id);
		model.addAttribute("artist", artistService.selectOne(artist_id));
		return "detail";
	}
	
//	참가자 정보 수정
	@GetMapping("/update/{artist_id}")
	public String udpate(@PathVariable("artist_id") String artist_id, Model model) {
//		타임리프에서 붙인 "를 제거하는 부분
		artist_id = artist_id.replace('"', ' ').trim();
		
		ArtistDTO artistDTO = artistService.selectOne(artist_id);
		model.addAttribute("artist", artistDTO);
		return "update";
	}
	
	@PostMapping("/update/{artist_id}")
	public String update(ArtistDTO artistDTO, Model model) {
//		정보 수정
		artistService.update(artistDTO);
		
//		수정된 정보 다시 불러와서 화면으로 보내기
		ArtistDTO dto = artistService.selectOne(artistDTO.getArtist_id());
		model.addAttribute("artist", dto);
		return "detail";
	}
	
//	참가자 정보 삭제
	@GetMapping("/delete/{artist_id}")
	public String delete(@PathVariable("artist_id") String artist_id, Model model) {
//		타임리프에서 붙인 "를 제거하는 부분
		artist_id = artist_id.replace('"', ' ').trim();
		
		artistService.delete(artist_id);
		return "redirect:/";
	}
	
//	멘토 점수 확인
	@GetMapping("/pointlist")
	public String pointList(Model model) {
		model.addAttribute("pointList", artistService.selectMentoPoint());
		return "list_point";
	}
	
//	순위 확인
	@GetMapping("/ranklist")
	public String rankList(Model model) {
		model.addAttribute("rankList", artistService.selectRank());
		return "list_rank";
	}
}
