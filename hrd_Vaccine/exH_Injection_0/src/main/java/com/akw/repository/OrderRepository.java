package com.akw.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.akw.dto.OrderDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

	private final SqlSessionTemplate sql;

	// ----- 등록(dto) 주사접종
	// view에 입력한 값이 dto를 통해 전달
	public void save(OrderDTO dto) {
		sql.insert("mapperOrder.save", dto);
	}

	// ----- 확인 주사접종목록
	public List<OrderDTO> findAll() {
		return sql.selectList("mapperOrder.findAll");
	}

	// ----- 확인(id) 주사접종목록
	public OrderDTO findById(Integer id) {
		return sql.selectOne("mapperOrder.findById", id);
	}

	// ----- 수정(dto) 주사접종
	public void update(OrderDTO dto) {
		sql.update("mapperOrder.update", dto);
	}

	// ----- 삭제(id) 주사접종
	public void delete(Integer id) {
		sql.delete("mapperOrder.delete", id);
	}
}
