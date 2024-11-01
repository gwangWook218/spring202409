package com.akw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akw.dto.InjectionDTO;
import com.akw.repository.InjectionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InjectionService {

	private final InjectionRepository injectionRepository;
	
	public void save(InjectionDTO dto) {
		injectionRepository.save(dto);
	}
	
	public List<InjectionDTO> findAll() {
		return injectionRepository.findAll();
	}
	
	public InjectionDTO findById(String i_code) {
		return injectionRepository.findById(i_code);
	}
	
	public void update(InjectionDTO dto) {
		injectionRepository.update(dto);
	}
	
	public void deleteById(String i_code) {
		injectionRepository.deleteById(i_code);
	}
}
