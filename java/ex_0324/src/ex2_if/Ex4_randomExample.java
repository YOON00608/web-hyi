package ex2_if;

import java.util.Scanner;

public class Ex4_randomExample {
	public static void main(String[] args) {
		// Math 클래스
		// random()메서드
		// - 0.0 <= ~ < 1.0 사이의 double타입 난수를 하나 뽑아주는 기능
		
		// static 키워드가 붙어있으면 객체 생성없이 호출 가능
		
		int num = (int)(Math.random()*6) + 1; // 1 <= x < 7;
		
		if(num == 1) {
			System.out.println("1이 나왔습니다.");
		} else if(num == 2) {
			System.out.println("2가 나왔습니다.");
		} else if(num == 3) {
			System.out.println("3이 나왔습니다.");
		} else if(num == 4) {
			System.out.println("4가 나왔습니다.");
		} else if(num == 5) {
			System.out.println("5가 나왔습니다.");
		} else {
			System.out.println("6이 나왔습니다.");
		}
		
		////////////////////////////////////////////////
		
		// 구매 금액에 따라 할인률이 적용된 금액 구하기
		// 10만원 이상 구매 시 20% 할인
		// 5만원 이상 구매 시 10% 할인
		// 키보드에서 금액을 입력 받고 몇 % 할인 받았는지,
		// 최종금액이 얼만지 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("구매 금액 : ");
		int price = sc.nextInt();
		int discount = 0;

		if(price >= 100000) {
			discount = 20;
		} else if(price >= 50000) {
			discount = 5;
		} else {
			discount = 0;
		}
		
		System.out.println("적용된 할인율 : " + discount + "%");
		System.out.println("최종 금액: " + price * (1-(discount/100.0))+"원");
		
		
	}
}
