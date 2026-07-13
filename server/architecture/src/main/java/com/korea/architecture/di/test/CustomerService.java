package com.korea.architecture.di.test;

import org.springframework.stereotype.Component;

@Component
public class CustomerService {
	public void checkCustomer() {
		System.out.println("고객 정보를 확인합니다.");
	}
}
