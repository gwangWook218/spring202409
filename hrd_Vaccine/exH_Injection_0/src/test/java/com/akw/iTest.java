package com.akw;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.akw.dto.InjectionDTO;
import com.akw.repository.InjectionRepository;

@SpringBootTest
public class iTest {
	
	@Autowired
	InjectionRepository repository;

//	@Test
//	@DisplayName("지문0: 값의 포함")
//	void 기본테스트() {
////		given
//		String strReq = "메소드별로 단위테스트를 할 수 있다.";
//		String strResp = "단위테스트 수정 확인 정답(초록), 오답(빨강)";
//		
////		when
//		System.out.println("----------------");
//		System.out.println(strReq);
//		System.out.println("----------------");
//		System.out.println(strResp);
//		
////		then
//		assertThat(strReq).contains("단위테스트");
//		assertThat(strResp).contains("정답(초록), 오답(빨강)");
	
	@Test
	@DisplayName("지문1: 백신테이블 기본데이터 확인")
	void 백신테이블() {
//		'A001', '코로나', '10'
//		'A002', 'A형간염', '15'
		
//		given
		Integer row = 1;
		List<InjectionDTO> list = repository.findAll();
		
//		when
		System.out.println("----------------");
		System.out.println("=====" + list.size() + "행");
		System.out.println("=====" + list.get(row).getI_code() + " = " + list.get(row).getI_name() + " = " + list.get(row).getI_cnt());
		System.out.println("----------------");
		
//		then
		assertThat(list.size()).isEqualTo(2);
		assertThat(list.get(row).getI_name()).contains("A형");
	}
}
