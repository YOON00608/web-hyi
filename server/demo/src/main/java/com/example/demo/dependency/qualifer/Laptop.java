package com.example.demo.dependency.qualifer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{

	@Override
	public int getScreenWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

}
