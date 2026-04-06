package ex5_Math;

import java.util.Arrays;
import java.util.Scanner;

public class RandomExample {
	public static void main(String[] args) {
		
		// 로또번호 (1 ~ 45) 를 뽑아서 배열에 넣는다.
        int[] lotto = new int[6];
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = (int) (Math.random() * 45) + 1;
            
            // 중복체크
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
        }

        // 키보드에서 6개의 숫자를 입력 받아서 번호 맞춘다.
        Scanner sc = new Scanner(System.in);
        int[] myNumbers = new int[6];
        System.out.println("1~45 사이의 숫자 6개를 입력하세요:");
        for (int i = 0; i < myNumbers.length; i++) {
            myNumbers[i] = sc.nextInt();
        }
       
        // 각 배열을 정렬한 뒤 Arrays.equals(0) 활용한다.
        Arrays.sort(lotto);
        Arrays.sort(myNumbers);
        
        System.out.println("\n당첨 번호: " + Arrays.toString(lotto));
        System.out.println("나의 번호: " + Arrays.toString(myNumbers));

        if (Arrays.equals(lotto, myNumbers)) {
            System.out.println("축하합니다! 1등에 당첨되었습니다!");
        } else {
        	System.out.println("꽝!");
        }
	}
}
