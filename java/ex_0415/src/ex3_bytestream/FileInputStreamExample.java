package ex3_bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// 스트림(stream)
// 데이터가 한 방향으로 흐르는 통로이다.
// 파일에 데이터를 저장하거나, 파일에서 데이터를 읽어올 때
// 자바는 데이터를 한 번에 통째로 다루기보다 흐름처럼 조금씩
// 읽고 쓰는 방식으로 처리한다.

// 바이트기반스트림
// 데이터를 1바이트(8비트)로 처리하는 스트림
// 데이터를 아주 작은 단위인 바이트로 읽고 쓴다.
public class FileInputStreamExample {
	public static void main(String[] args) {
		
		// 파일에서 바이트 단위로 데이터를 읽어오는 클래스
		// 파일이 없으면 예외가 발생할 수 있기 때문에 예외 처리를 해줘야 한다.
		try {
			FileInputStream fis = new FileInputStream("test.txt");
			
			// read()
			// 파일에서 1바이트를 읽어서 int로 반환합니다.
			
			int data = fis.read();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
