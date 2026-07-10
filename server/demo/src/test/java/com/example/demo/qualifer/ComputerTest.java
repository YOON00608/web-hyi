package com.example.demo.qualifer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dependency.qualifer.Computer;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ComputerTest {
	
	private final Computer computer;
	
	public ComputerTest(Computer computer) {
		this.computer = computer;
	}
	
	@Test
	public void computerTest() {
		log.info(computer.getScreenWidth()+"");
	}
	
	
}
