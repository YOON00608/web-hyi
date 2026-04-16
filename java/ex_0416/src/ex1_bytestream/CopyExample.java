package ex1_bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyExample {
	public static void main(String[] args) {
		
		// 상대경로에 있는 이미지 파일을 바이트기반 스트림으로 읽어서 복사본 만들기
		// 복사본 이름 : wall_copy.jpg
		// 복사하면서 걸리는 시간을 currentTimeMillis(); 로 측정하기
		
		// 소스 파일과 복사될 파일 경로 설정
		String sourcePath = "wall.jpg";
		String targetPath = "wall_copy.jpg2";
		
		// 시작 시간 측정
		long startTime = System.currentTimeMillis();
		
		try {
			// try-with-resources 구문을 사용하여 스트림을 자동 닫기
			FileInputStream fis = new FileInputStream(sourcePath);
			FileOutputStream fos = new FileOutputStream(targetPath);
			
			byte[] buffer = new byte[1024];
			int length = 0;
			
			// 파일의 끝(-1)에 도달할 때까지 읽어서 사용
			while((length = fis.read(buffer)) != -1) {
				// buffer의 0부터 length개만큼 출력파일에 기록
				fos.write(buffer,0,length);
			}
			// 파일은 4mb
			// 우리가 전달한 배열은 512byte
			// 우리가 전달한 파일을 512바이트씩 잘라서 여러번 읽고 쓰는 방식
			
			// 종료 시간 측정 및 결과 출력
			long endTime = System.currentTimeMillis();
			long duration = endTime - startTime;
			
			System.out.println("복사가 완료 되었습니다.");
			System.out.println("복사본 파일명 : " + targetPath);
			System.out.println("소요 시간 : " + duration + "초");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("파일 처리 중 오류가 발생했습니다.");
		} 
		
	}
}
