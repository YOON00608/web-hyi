package ex3_bufferedstream;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStreamReaderExample {
    public static void main(String[] args) {
        
        // InputStreamReader: 바이트 스트림을 문자 스트림으로 변환하는 보조 스트림
        try (
            FileInputStream in = new FileInputStream("test.txt");
            InputStreamReader is = new InputStreamReader(in, "UTF-8")
        ) { // try 리소스 선언은 여기서 끝내야 합니다.

            int read = 0;
            // 실제 읽기 로직은 try 블록 내부에서 실행합니다.
            while ((read = is.read()) != -1) {
                System.out.print((char) read);
            }

        } catch (Exception e) {
            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
