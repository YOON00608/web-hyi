package ex6_date;

import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
		
		// Date 클래스
		// 날짜 + 시간을 하나의 객체로 표현
		// 1970년 1월 1일 기준
		// 대부분 메서드가 deprecated(더 이상 사용되지 않음)되어
		// Date() 생성자만 주로 사용된다.
		Date now = new Date();
		System.out.println(now);
		
	}
}
