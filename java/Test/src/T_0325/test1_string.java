package T_0325;

import java.util.Scanner;

public class test1_string {
	public static void main(String[] args) {
		// 문자열을 입력받아, 중복된 문자를 제거하고 처음 등장한 순서대로 출력하기
	
//        Scanner sc = new Scanner(System.in);
//        System.out.print("입력 :");
//
//        String input = sc.nextLine();
//        String result = "";
//
//        for (int i = 0; i < input.length(); i++) {
//            char ch = input.charAt(i);
//            
//            if (result.indexOf(ch) == -1) {
//                result = result + ch; 
//            }
//        }
//
//        System.out.println(result);
        
        System.out.println("----------------------------");
        
        // 문자열 hello world를 입력받아 나온 아스키 코드들을 전부 더한 값을 구하여라
        // -> 입력받은 10개의 문자열의 아스키 코드들을 전부 더한 값을 구해라.
        // (문자열은 소문자로 입력해야 한다.)
        
        Scanner sc = new Scanner(System.in);
        
        String [] ar = new String[10];
        int [] asc2;
        int sum = 0; // 총합

        for (int i = 0; i <= 9 ; i++) {
        System.out.println("알파벳을 기입하세요 > ");
        ar [i] = sc.next();
        }

        asc2 = String.join("", ar).chars().toArray();
        System.out.print("입력한 알파벳 : ");

        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i]);
        }System.out.print("\n변환된 아스키 코드 : ");

        for (int i = 0; i <= 9 ; i++) {
        System.out.print("[" + asc2[i] + "]");
        	sum += asc2[i];
        }
        System.out.println();
        System.out.println("더한 값 :" + sum);
        
	}
}
