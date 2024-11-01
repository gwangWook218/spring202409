package com.akw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CustDTO {
	
	//회원 목록 테이블
	private String p_no;
	private String p_name;
	private String p_birth;
	private String p_tel;
	private String p_city;
	private String p_gender;
}
