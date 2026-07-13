package com.korea.architecture.di.test;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Doctor {
	
	private final Patient patient;
	
	public void treat() {
		// 1. 환자 정보 확인을 먼저 실행합니다.
		checkInformation(); 
		
		// 2. 그 다음 의사의 진료 시작과 완료를 진행합니다.
		System.out.println("의사가 환자 진료를 시작합니다.");
		System.out.println("환자 진료가 완료되었습니다.");
	}
	
	public void checkInformation() {
		patient.checkInformation();
	}
}
