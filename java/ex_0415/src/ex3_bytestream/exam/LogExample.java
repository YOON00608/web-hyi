package ex3_bytestream.exam;

import java.io.FileInputStream;

public class LogExample {
	public static void main(String[] args) {
        
		try {
            FileInputStream fis = new FileInputStream("logs/error.log");

            // 1. 파일 크기만큼 byte 배열 선언
            byte[] bytes = new byte[fis.available()];

            // 2. byte 배열 전체 읽기
            fis.read(bytes);

            // 3. byte 배열 → String 변환
            String content = new String(bytes);

            // 4. "ERROR" 등장 횟수 세기
            int count = 0;
            int index = 0;
            while ((index = content.indexOf("ERROR", index)) != -1) {
                count++;
                index += "ERROR".length();
            }

            System.out.println("ERROR 등장 횟수: " + count);

            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
		
	
}
