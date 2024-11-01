package com.example.quiz.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
//	식별 ID
	@Id
	private Integer id;
	
//	퀴즈 내용
	private String question;
	
//	퀴즈 답
	private Boolean answer;
	
//	작성자
	private String author;
}
