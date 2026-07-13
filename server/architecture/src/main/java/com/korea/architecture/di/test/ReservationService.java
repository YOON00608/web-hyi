package com.korea.architecture.di.test;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReservationService {
	private final CustomerService customerService;
	private final TravelProductService travelProductService;
	
	public void reserve() {
		System.out.println("여행 예약을 시작합니다.");
		customerService.checkCustomer();
		travelProductService.checkTravelProduct();
		System.out.println("여행 예약이 완료 되었습니다.");
	}

}
