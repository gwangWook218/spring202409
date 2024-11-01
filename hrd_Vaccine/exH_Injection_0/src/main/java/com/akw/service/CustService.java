package com.akw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akw.dto.CustDTO;
import com.akw.repository.CustRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustService {
	
	private final CustRepository custRepository;

	public void save(CustDTO dto) {
		custRepository.save(dto);
	}
	
	public List<CustDTO> findAll() {
		return custRepository.findAll();
	}
	
	public CustDTO findById(String p_no) {
		return custRepository.findById(p_no);
	}
	
	public void update(CustDTO dto) {
		custRepository.update(dto);
	}
	
	public void deleteById(String p_no) {
		custRepository.deleteById(p_no);
	}
}
