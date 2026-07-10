package com.example.demo.dependency.qualifer;

import org.springframework.stereotype.Component;

@Component
public class DeskTop implements Computer{

	@Override
	public int getScreenWidth() {
		// TODO Auto-generated method stub
		return 1920;
	}
	
}
