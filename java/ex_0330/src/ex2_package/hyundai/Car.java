package ex2_package.hyundai;

// import의 역할
// 긴 이름을 줄여서 쓰기 위한 문법
import java.security.AllPermission;
import ex2_package.hankook.SnowTire;

public class Car {
	
		// 타이어가 필요하다
	
		// 클래스의 전체 경로를 다 작성해줬기 때문에 import를 써주지 않아도 된다.
		ex2_package.hankook.Tire tire1 = new ex2_package.hankook.Tire();
		ex2_package.kumho.Tire tire2 = new ex2_package.kumho.Tire();
		
		// 클래스명이 겹치지 않으면 import로 간단하게 작성할 수 있다.
		SnowTire tire3 = new SnowTire();
		AllPermission tire4 = new AllPermission();
	
	
	
	
	
	
}
