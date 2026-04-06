package ex6_date;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
		
		// 날짜와 시간 더하기 빼기
		// 일 더하기 
		System.out.println("10일 뒤 : " + now.plusDays(10)); // 10일 뒤 : 2026-04-16T16:19:07.542702300
		
		// 월 더하기
		System.out.println("2달 뒤 : " + now.plusMonths(2)); // 2달 뒤 : 2026-06-06T16:20:16.300664500
		
		// 년 더하기
		System.out.println("1년 뒤 : " + now.plusYears(1)); //1년 뒤 : 2027-04-06T16:21:01.434818600
		
		// 빼기 : minusDay, minusMonth...
		
		// 문자열로 출력형식 바꾸기
		DateTimeFormatter formatter = 
				DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
		
		String result = now.format(formatter);
		System.out.println(result); // 2026년 04월 06일 16시 33분 35초
		
		// 문자열을 LocalDateTime 으로 바꾸기
		String str = "2026/04/06 16:37";
		formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		LocalDateTime dateTime2 = LocalDateTime.parse(str, formatter);
		
		System.out.println(dateTime2); // 2026-04-06T16:37
		
		// 날짜 비교 가능
		// isbefore() : 앞선 시간인지 비교
		// isAfter() : 뒤의 시간인지 비교
		LocalDateTime meeting = LocalDateTime.of(2026, 4, 10, 14, 0);
		
		System.out.println(now.isBefore(meeting)); // true
		System.out.println(now.isAfter(meeting)); //  false
		
		// 날짜의 특정 부분만 바꾸기
		// 이미 만들어진 날짜/시간 객체에서
		// 연도나 월, 일, 시를 바꾼 새로운 객체를 만들 수 있다.
		LocalDateTime changed = now.withYear(2030)
				.withMonth(12)
				.withDayOfMonth(25)
				.withHour(9);
		System.out.println(now); // 원본은 안 바뀜 : 2026-04-06T16:46:38.496527300
		System.out.println(changed); // 2030-12-25T09:46:38.496527300
		
		// 현재 시간이 09:00 ~ 18:00 사이인지 확인하여
		// 예약 가능 여부를 출력하는 코드
		
		LocalTime now1 = LocalTime.now();
		
		LocalTime startTime = LocalTime.of(9, 0);
		LocalTime endTime = LocalTime.of(18, 0);
		
		if(now1.isAfter(startTime) && now1.isBefore(endTime)) {
			System.out.println("현재 시간 : " + now1);
			System.out.println("예약이 가능합니다.");
		} else {
			System.out.println("현재 시간 : " + now1);
			System.out.println("예약이 불가능합니다.");
		}
		
	
		
		
	}
}
