package ex2_file.exam;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		
		// 1. 현재 프로젝트를 기준으로 uploads 폴더를 나타내는 File 객체 생성
		String path = "C:\\Users\\adminn\\Desktop\\web-hyi\\java\\ex_0415\\uploads";
		File f = new File(path);
		
		// 2. 폴더가 없으면 생성
		
		File dir = new File("uploads\\dogFolder");
		
		boolean result = dir.mkdirs();
		if(result) {
			System.out.println("폴더 생성");
		}else {
			System.out.println("이미 존재하는 폴더");
		}
		
		// 3. 폴더인지 확인
		if(f.isDirectory()) {
			System.out.println("폴더입니다.");
		}else {
			System.out.println("uploads는 폴더가 아닙니다.");
		}
		
		// 4. 폴더 안에 들어있는 파일과 폴더 목록을 출력한다.
		// 각 항목에 대해 다음 형식으로 출력한다.
		// 폴더면 ⇒ [DIR] 폴더명, 파일이면 ⇒ [FILE] 파일명
		File[] files = f.listFiles();
		for(File file : files) {
			if(file.isDirectory()) {
				System.out.println("[DIR]" + file.getName());
			}else {
				System.out.println("[FILE]"+ file.getName());
			}
		}
		
		// 5. 전체 개수 출력
		System.out.println("전체 개수 : " + files.length); // 전체 개수 : 4
		
	}
}
