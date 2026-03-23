package ex1_datatype;

public class Ex1_CharExample {
	public static void main(String[] args) {
		// 문자형 자료형 : char
		// 문자형 데이터는 무조건 한 글자
		// 데이터를 '' 에 담아야 한다.
		
		char c1 = 'A';
		char c2 = '가';
		
		// 컴퓨터는 문자를 그대로 저장하지 못한다.
		// 대신 문자에 대응하는 숫자(코드값)를 저장한다.
		// 유니코드 > 아스키코드
		char c3 = 65;	// 'A' 나오는 이유: 아스키코드
		char c4 = 44032; // '가' 나오는 이유 : 유니코드
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
	}
}
