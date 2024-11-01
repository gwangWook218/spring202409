package com.akw.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderDTO {

	// 접종코드
	private Integer p_seno;

	// 회원코드
	private String p_no;

	// 회원이름
	private String p_name;

	// 백신코드
	private String i_code;

	// 백신명
	private String i_name;

	// 접종날짜
	private Date p_date;
}
