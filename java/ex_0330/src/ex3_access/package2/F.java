package ex3_access.package2;

import ex3_access.package1.D;

public class F {
	
	// 다른 패키지의 다른 클래스
	D d1 = new D(true);
	// D d2 = new D(1); -> default 접근제한 생성자 X
	// D d3 = new D("문자열"); -> private 접근제한 생성자 X
	
	
	
}
