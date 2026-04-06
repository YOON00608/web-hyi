package ex3_String;

import java.util.Arrays;

public class ByteToStringExample {
	public static void main(String[] args) {
		
		String data = "자바";
		
		// String -> byte 배열
		byte[] arr1 = data.getBytes();
		// 문자열을 컴퓨터가 처리할 수 있는 숫자(byte)로 바꾼 것이다.
		System.out.println("arr1 : " + Arrays.toString(arr1)); // arr1 : [-20, -98, -112, -21, -80, -108]
		
		// byte 배열 -> String
		String str1 = new String(arr1);
		System.out.println("str1 : " + str1); // str1 : 자바
		
	}
}
