package ex1_array;

import java.util.Scanner;

public class Ex1_ArrayExample {
	public static void main(String[] args) {
		
//		char[] cards = {'1','L','O','2','V','3','E','l','e'};
//		String myWord = "";
		
		// 배열에서 문자만 뽑아서 단어 만들기
		// 아스키코드 활용하기
		
//		for(char c : cards) {
//			if(c >= 65 && c <= 90) { // 소문자도 포함 : || c >=97 && c <= 122
//			myWord += c;
//		}
//	}
//		System.out.println("단어 : " + myWord);
		
		// 변수 money 10 ~ 5000원 사이의 난수를 발생시켜 넣는다.
		// 단, 1의 자리 숫자는 반드시 0이 되도록 한다.
		// 발생된 난수 money를 동전으로 바꾸면 각 동전이 몇 개 필요한지 코드로 작성하기
		// 가능한 적은 수의 동전을 사용하도록 한다.
		
//		int[] coin = {500,100,50,10};
//		
//		// 10 ~ 5000사이의 난수
//		int money = ((int)(Math.random()*500+1))*10;
//		System.out.println("잔돈 : " + money);
//		
//		// 발생된 난수를 큰 동전부터 나누기
//		for(int i = 0; i < coin.length; i++) {
//			int res = money / coin[i];
//			System.out.println(coin[i] + "원" + "필요한 동전 : " + res);
//			money = money % coin[i];
//		}
//		
//		System.out.println("-------------------");
		
		// 키보드에서 배열의 길이를 입력 받는다.
		// 입력 받은 배열의 길이만큼 알파벳을 요소로 넣는다.
		// 배열의 모든 요소를 출력한다.
		// 배열의 길이 : 5 - > ABCDE
		
//		Scanner sc = new Scanner(System.in);
//		// 배열의 선언과 생성 -> 길이를 키보드로 입력받기
//		System.out.print("배열의 길이 : ");
//		int length = sc.nextInt();
//		
//		char[] a = new char[length];
//		
//		// 배열의 길이만큼 반복하여 요소에 알파벳 넣기 (아스키 코드 활용)
//		
//		for(int i = 0; i < a.length; i++) {
//			a[i] = (char)('A'+ i);
//			
//			System.out.print(a[i]);
//		}


//		System.out.println("-------------------");
		
		// 로또번호 구하기
		// 1 ~ 45사이의 난수를 발생시켜 로또번호 6자리를 만드는 코드 작성하기
		// 구한 로또번호를 배열에 담기
		// 번호가 중복되는지 비교하기 << ??? 
		
		// 로또번호를 담을 배열
		int[] loo = new int[6];
		
		// 배열의 길이만큼 반복
		outer : for(int i = 0; i < loo.length;) {
			
			// 난수를 하나 뽑아 배열에 저장
			loo[i] = (int)(Math.random()*45+1);
			
			// 중복이 있는지 검사
			for(int j = 0; j < i; j++) {
				// 같은 게 있다면
				if(loo[i] == loo[j]) {
					// 다시 뽑아야 한다.
					continue outer;	// 라벨 : 일치하는 게 없으면 나가라
				}
			}
			System.out.println(loo[i] + "");
			i++;
		} // outer
			
			
		
		
		
		
		
	
			
		
		
	}
}
