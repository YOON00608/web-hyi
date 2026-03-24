package ex3_switch;

import java.util.Scanner;

public class Ex3_SwitchExpressionsExample {
	public static void main(String[] args) {
		
		// break를 빼먹으면 fall-through가 발생한다.
		// 값을 변수에 넣으면 중복 코드가 많아진다.
		int num = 2;
//		String result;
//		switch(num) {
//		case 1:
//			result = "A";
//			break;
//		case 2:
//			result = "B";
//			break;
//		case 3:
//			result = "C";
//			break;
//		case 4:
//			result = "D";
//			break;
//		}
		
		//
		String result = switch(num){
		case 1 -> "A";
		case 2 -> "B";
		case 3 -> "C";
		default -> "F";
		};
	
		// 여러 case를 묶기가 불편하다.
		
		int day = 3;
//		String type;
//		switch(day) {
//		case 1:
//		case 2:
//		case 3:
//		case 4:
//		case 5:
//			type = "평일";
//			break;
//		case 6:
//		case 7:
//			type = "주말";
//			break;
//		}
		
		String type = switch(day) {
		case 1,2,3,4,5 -> "평일";
		case 6,7 -> "주말";
		default -> "잘못된 값";
		};
		
		// 화살표 오른쪽에 여러 줄의 로직이 필요하다면 {}을 써야 한다.
		// 이때 최종적으로 반환할 값을 명시하려면 yield 키워드를 사용한다.
		result = switch(num) {
			case 1 -> "하나";
			case 2 -> {
				System.out.println("2가 입력됨");
				yield "둘";
			}
			default -> "기타";
		};
		
		// 정수형 변수를 하나 만들고 해당 달이 며칠까지 있는지
		// switch문을 이용하여 작성하세요.
		// ex) 1월은 31일까지 있습니다.
		
		int month = 3;
		String result3 = switch(month) {
			case 1, 3, 5, 7, 8 -> month + "월은 31일까지 있습니다.";
			case 4, 6, 9, 11 -> month + "월은 30일까지 있습니다.";
			case 2 -> month + "월은 28일까지 있습니다.";
			default -> "다시 입력해주세요.";
		};
		
		System.out.println(result3);
		
		// 계산기 만들기
		// 두 개의 정수형 변수를 키보드에서 입력받는다.
		// 연산자 기호를 담아줄 문자열 변수를 만든다.
		// switch문을 이용하여 정수의 연산을 수행하는 코드 작성하기
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 : ");
		int n1 = sc.nextInt();
		
		System.out.print("두 번째 정수 : ");
		int n2 = sc.nextInt();
		
		System.out.print("연산자 입력 : ");
		String op = sc.next();
		
		switch(op) {
		case "+":
			System.out.println("값: " + (n1 + n2));
			break;
		case "-":
			System.out.println("값: " + (n1 - n2));
			break;
		case "*":
			System.out.println("값: " + (n1 * n2));
			break;
		case "/":
			if(n2 == 0) {
			System.out.println("0으로 나눌 수 없습니다.");
			} else {
				System.out.println("값: " + ((double) n1/n2));
			} break;
			default : System.out.println("잘못 입력했습니다.");
		}
	}
}
