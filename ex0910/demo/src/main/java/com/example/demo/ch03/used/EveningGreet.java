package com.example.demo.ch03.used;

import org.springframework.stereotype.Component;

@Component
public class EveningGreet implements Greet {
	@Override
	public void greeting() {
		System.out.println("시원한 저녁입니다.");
	}
}
