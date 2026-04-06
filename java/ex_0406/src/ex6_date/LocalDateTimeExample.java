package ex6_date;

import java.time.LocalDateTime;
public class LocalDateTimeExample {
	public static void main(String[] args) {
		
		// JAVA 8 이후에 등장한 현대적인 날짜 API
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		// 원하는 날짜와 시간을 직접 만들기
		LocalDateTime dateTime = LocalDateTime.of(2026, 4,6,10,30);
		System.out.println(dateTime);
		
		// 날짜/시간 전체를 알고 있기 때문에
		// 연도, 월, 일, 시, 분 등을 꺼낼 수 있다.
		System.out.println("연도 : " + now.getYear()); // 연도 : 2026
		System.out.println("월 : " + now.getMonth()); // 월 : APRIL
		System.out.println("일 : " + now.getDayOfMonth()); // 월 : APRIL, 일 : 6
		System.out.println("시 : " + now.getHour()); // 시 : 16
		System.out.println("분 : " + now.getMinute()); // 분 : 17
		System.out.println("초 : " + now.getSecond()); // 초 : 36
	}
}
