package ex2_charstream;

import java.io.FileWriter;

public class FileWriterExample {
	public static void main(String[] args) {
		
		try {
			
			FileWriter fw = new FileWriter("hello.txt",true);
			fw.write("첫 번째 줄 작성합니다.\n");
			fw.write("두 번째 줄도 문제 없습니다.");
			
			fw.close();
		} catch (Exception e) {
		}	
	}
}
