package ex6_date;

import java.util.Calendar;

public class CalendarExample {
	public static void main(String[] args) {
		
		// Date 클래스의 문제점을 해결하려고 만든 클래스
		// Calendard 클래스는 달력을 표현하는 추상클래스
		// 날짜와 시간을 계산하는 방법이 지역과 문화에 따라 다르기 때문에
		// 특정 역법에 따르는 달력은 자식 클래스에서 구현하도록 되어있다.
		
		// 특별한 역법을 사용하는 경우가 아니라면 직접 하위 클래스를 만들 필요는 없고
		// Calender 클래스의 정적 메서드인 getInstance() 메서드를 사용하묜
		// 컴퓨터에 설정 되어 있는 시간대를 기준으로 객체를 얻을 수 있다.
		
		Calendar now = Calendar.getInstance();
		
		// Calendar 가 제공하는 날짜와 시간에 대한 정보를 얻기 위해서는 get() 메서드를 사용한다.
		int year = now.get(Calendar.YEAR);
		System.out.println("년도 : " + year);
		
		int month = now.get(Calendar.MONTH) + 1; // 0부터 저장을 하기 때문에 0이 1월임
		System.out.println("월 : " + month);
		
		int day = now.get(Calendar.DAY_OF_MONTH);
		System.out.println("일 : " + day);
		
		int week = now.get(Calendar.DAY_OF_WEEK);
		System.out.println("요일 : " + week); // 1: 일요일 ~ 7: 토요일
		
		System.out.println("시 : " + now.get(Calendar.HOUR));
		System.out.println("분 : " + now.get(Calendar.MINUTE));
		System.out.println("초 : " + now.get(Calendar.SECOND));
		
	}
	
}
