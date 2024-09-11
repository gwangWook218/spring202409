package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberCrudRepository;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(JdbcApplication.class, args).getBean(JdbcApplication.class).execute();
	}

	@Autowired
	MemberCrudRepository repository;
	
	private void execute() {
		executeInsert();
		executeSelect();
	}
	
	private void executeInsert() {
		Member member = new Member(null, "이순신");
		member = repository.save(member);
		System.out.println("등록 데이터:" + member);
	}
	
	private void executeSelect() {
		System.out.println("--- 전체 데이터르 취득합니다 ---");
		Iterable<Member> members = repository.findAll();
		for (Member member : members) {
			System.out.println(member);
		}
	}
}