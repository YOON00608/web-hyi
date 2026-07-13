package com.korea.architecture.test;

import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.korea.architecture.di.test.Hospital;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest 
@Slf4j

public class HospitalTest {
	
	@Autowired 
	private Hospital hospital; 

	@Test 
	void hospitalTest() {
		hospital.startMedicalService();
		hospital.treat();
	}
}