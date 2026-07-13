package com.korea.architecture.di.test;

import org.springframework.stereotype.Component;

@Component
public class SmsNotificationService implements NotificationService {

	@Override
	public void send(String message) {
		System.out.println("메시지 알림 전송 : 회원가입을 축하합니다.");
	}

}
