package com.akw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class InjectionDTO {
	
	// 백신 목록 테이블
	private String i_code;
	private String i_name;
	private String i_cnt;
}
