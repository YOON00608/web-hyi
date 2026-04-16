package ex3_bytestream.exam;

import java.io.FileInputStream;
import java.util.Arrays;

public class Example {
	public static void main(String[] args) {
		
		byte[] read = new byte[100];
		
		try {
			FileInputStream fis = new FileInputStream("file.txt");
			
			// 파일 내용을 바이트 배열로 읽기
			fis.read(read);
			
			// 바이트 배열을 문자열로 변환 후 공백 제거
			String ori = new String(read).trim();
			String[] fruits = ori.split("\r\n");
			System.out.println(Arrays.toString(fruits));
			
			// 문자열 뒤집기
//			StringBuilder reversed = new StringBuilder(ori).reverse();
			
			// 회문 판별
			
			for(String fruit : fruits) {
				StringBuilder reversed = new StringBuilder(fruit).reverse();
				if(fruit.equals(reversed.toString())) {
					System.out.println(fruit + " -> 회문입니다.");
				}else {
					System.out.println(fruit + " -> 회문이 아닙니다.");
				}
			}
			
//			if(ori.equals(reversed.toString())) {
//				System.out.println(ori + " -> 회문입니다.");
//			}else {
//				System.out.println(ori + " -> 회문이 아닙니다.");
//			}
			
			fis.close();
			
		} catch (Exception e) {
			
		}
	}
}
