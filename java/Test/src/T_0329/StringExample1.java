package T_0329;
import java.util.Scanner;
public class StringExample1 {
	public static void main(String[] args) {
		// 1. 키보드에서 입력받아 연속된 문자를 문자+개수 형태로 압축하기.
		// ex) aaabbc => a3b2c1
		
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 입력: ");
		String input = sc.nextLine();

		String result = "";
		int count = 1;

		for (int i = 0; i < input.length(); i++) {

		// 마지막 문자이거나 다음 문자와 다를 때
		if (i == input.length() - 1 || input.charAt(i) != input.charAt(i + 1)) {
		      result += input.charAt(i) + "" + count;
		      count = 1;
		} else {
		       count++;
			}
		}

		        System.out.println("압축 결과: " + result);
		    
		// 2. 다음 문자열에서 "프로그래밍"이라는 단어가
		// 몇 번째 위치에 있는지 찾아 출력하시오. 
		// 만약 단어가 없으면 "찾을 수 없음"을 출력하세요.
		// String text = "나는 자바 프로그래밍을 공부합니다.";

		String text = "나는 자바 프로그래밍을 공부합니다.";

		int index = text.indexOf("프로그래밍");

		if (index == -1) {
		    System.out.println("찾을 수 없음");
		} else {
		    System.out.println("위치: " + index);
		}
		        
		        
		// 3. 영어 문장을 하나 입력받고,
		// 이 문장의 모음의 개수를 센 뒤,
		// 모음이 각 단어마다 몇 개 들어있는지 확인하는 코드를 작성하시오.
	    // 1) toCharArray(), toLowerCase(), split(’ ’)을 이용하는 것이 좋습니다.
	    // 2) 여기서 의미하는 ‘단어’는 띄어쓰기로 구분되는 단위를 말합니다.
		// (ex.)There is a cat → There, is, a, cat
		
		
		// 4. 이메일을 입력하면 아이디와 도메인을 나눠 정리해서 보여주는 코드
		// 조건 : String[], split("@") 사용

		// 결과 예시1
		// 이메일을 입력해주세요.
		// java1234@gmail.com

		// [ 사용자 정보 ]
		// 아이디: java1234
		// 도메인: gmail.com


		        System.out.println("이메일을 입력해주세요.");
		        String email = sc.nextLine();

		        String[] parts = email.split("@");

		        // 예외 처리 (형식이 잘못된 경우)
		        if (parts.length != 2) {
		            System.out.println("올바른 이메일 형식이 아닙니다.");
		            return;
		        }

		        System.out.println("\n[ 사용자 정보 ]");
		        System.out.println("아이디: " + parts[0]);
		        System.out.println("도메인: " + parts[1]);
		    
		
	
	}
}
