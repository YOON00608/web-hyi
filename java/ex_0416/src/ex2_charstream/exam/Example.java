package ex2_charstream.exam;

import java.io.FileReader;

public class Example {
	public static void main(String[] args) {
		
		try(FileReader fr = new FileReader("test.txt")) {
			
			int upperCount = 0;
			int lowerCount = 0;
			int data = 0;
			
			while((data = fr.read()) != -1) {
			
				if(data >= 'A' && data <= 'Z') {
					upperCount++;
				}else if(data >= 'a' && data <= 'z') {
					lowerCount++;
				}
			}
			
			System.out.println("대문자 : " + upperCount + "개");
			System.out.println("소문자 : " + lowerCount + "개");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
