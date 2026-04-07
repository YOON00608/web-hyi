package ex7_regex;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class PatternExample {
	public static void main(String[] args) {
		
		// 전화번호 정규식
		String regExp = "(02|010)-[0-9]{3,4}-[0-9]{4}"; // 02 또는 010 + 3글자 아님 4글자 + 4글자
		String data = "010-123-4567";
		
		boolean result = Pattern.matches(regExp, data);
		System.out.println(result); // true
		
		// 주민등록번호 정규식 만들기
		regExp = "[0-9]{6}-[0-9]{7}";
		String ssn = "001234-1234567";
		
		
		String birth = ssn.substring(0,6);
		int year = Integer.parseInt("20" + birth.substring(0,2));
		System.out.println("생일 : " + year);
		
		int month = Integer.parseInt(birth.substring(2,4));
		System.out.println("월 : " + month);
		
		int day = Integer.parseInt(birth.substring(4,6));
		System.out.println("일 : " + day);
		
		try {
			LocalDate.of(year, month, day);
		} catch (Exception e) {
			System.out.println("잘못된 날짜");
		}
		
		// 숫자만 입력 되었는지 검사
		// 문자열이 숫자로만 이루어져 있는지 검사하는 코드
		// "12345" 는 통과
		// "12a45" 는 실패
		// 다른 값이 주어져도 실행이 되어야 한다.
		
		String str = "12345";
		regExp = "[0-9]+";
		
		System.out.println(str.matches(regExp)); // true
		
//		for(int i = 0; i < str.length(); i++) {
//			char ch = str.charAt(i);
//			if(ch < '0' && ch > '9') {
//				System.out.println("다른 글자가 포함됨");
//				break;
//			}
//		} -> 기존 방식
		
		// 아이디 형식검사
		// 영어 소문자로 시작
		// 영어 소문자 + 숫자만 허용
		// 5 ~ 12자
		
		str = "user123";
		regExp = "[a-z][a-z0-9]{4,11}";
		System.out.println(str.matches(regExp)); // true
		
		// 이메일 형식 검사
		// - 아이디 부분 : 영문, 숫자, _
		// @ 와 도메인 포함
		// 예시 : test01@gmail.com
		
		str = "test01@gmail.com";
		regExp = "[a-zA-z0-9_]+@[a-zA-Z0-9]+.[a-zA-Z]{2,}";
		
		System.out.println(str.matches(regExp)); // true
		
		// 숫자만 출력 
		
		String[] arr = {"123","abc","4567","a1b2"};
		
		regExp = "[0-9]+";
		
		for(String s : arr) {
			if(s.matches(regExp))
			System.out.println(s);
		}
		
		
		// 한글만 출력
		String[] arr2 = {"홍길동","Tom","김철수","a1","김이박조길동"};
		
		regExp = "[가-힣]{2,5}";
		for(String s2 : arr2) {
			if(s2.matches(regExp))
				System.out.println(s2);
		}
		
		
		
		
		
	}
}
