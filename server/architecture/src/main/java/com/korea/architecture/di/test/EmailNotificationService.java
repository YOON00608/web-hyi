package com.korea.architecture.di.test;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationService implements NotificationService {

	@Override
	public void send(String message) {
		System.out.println("이메일 알람 전송: 회원가입을 축하합니다.");
	}

}
