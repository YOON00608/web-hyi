package com.korea.petclinic.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ReservationVO {
	private Long id;
	String petName;

	String ownerName;

	String animalType;

	String doctorName;

	LocalDate reservationDate;

	String status;

	int price;
 
}
