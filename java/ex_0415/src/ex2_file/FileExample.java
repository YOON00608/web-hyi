package ex2_file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileExample {
	public static void main(String[] args) {
		
		// File 클래스
		// 자바에서 파일과 디렉터리(폴더)를 다루기 위한 클래스
		
		// 메모장까지의 경로
		String path = "C:\\Users\\adminn\\Desktop\\web-hyi\\test.txt";
		
		// 준비된 경로로 File 객체를 생성
		File f = new File(path);
		
		// 주요 메서드
		// getName();
		// 파일명 또는 마지막 경로명을 반환한다.
		System.out.println(f.getName()); // test.txt
		
		// getPath()
		// 생성할 때 넣은 경로를 반환한다.
		System.out.println(f.getPath());
		
		// getAbsolutePath()
		// 절대경로로 반환
		System.out.println(f.getAbsolutePath());
		
		// exist()
		// 파일이나 폴더가 실제로 존재하는지 확인
		if(f.exists()) {
			System.out.println("존재한다.");
		}else {
			System.out.println("존재하지 않는다.");
		}
		
		// isFile()
		// 최종목적지가 파일인지 확인한다.
		if(f.isFile()) {
			System.out.println("파일입니다.");
		}else {
			System.out.println("파일이 아닙니다.");
		} // 파일입니다.
		
		// isDirectory()
		// 최종 목적지가 폴더인지 확인
		if(f.isDirectory()) {
			System.out.println("폴더입니다.");
		}else{
			System.out.println("폴더가 아닙니다.");
		} // 폴더가 아닙니다.
		
		
		// length()
		// 파일 크기를 바이트 단위로 반환한다.
		System.out.println("파일 크기 : " + f.length()); // 파일 크기 : 18
		
		// lastModified()
		// 마지막 수정 시간을 밀리초(long)로 반환한다.
		System.out.println(f.lastModified()); // 1776228193382
		
		// createNewFile()
		// 실제 빈 파일을 생성한다.
		// 이미 있으면 false를 반환한다.
		File f2 = new File("text.txt");
		try {
			boolean result = f2.createNewFile();
			System.out.println(result ? "파일 생성 성공 ":"이미 파일이 존재함");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// mkdir()
		// 폴더를 1개 생성해준다.
		File dir = new File("myFolder");
		boolean result = dir.mkdir();
		if(result) {
			System.out.println("폴더 생성");
		}else {
			System.out.println("이미 존재하는 폴더");
		} 
		
		// mkdirs()
		// 필요한 상위 폴더까지 모두 생성해준다.
		dir = new File("a/b/c");
		
		result = dir.mkdirs();
		if(result) {
			System.out.println("폴더 생성");
		}else {
			System.out.println("이미 존재하는 폴더");
		} // 폴더 생성
		
		// delete()
		// 파일 또는 빈 폴더를 삭제한다.
		result = f2.delete();
		if(result) {
			System.out.println("삭제 완료");
		} // 삭제 완료
		
		// 폴더는 내부가 비어있어야 삭제 가능
		// 안에 파일이 있는 폴더는 바로 삭제되지 않는다.
		
		// list()
		// 이름 목록을 문자열 배열로 반환한다.
		// 목표 폴더의 바로 밑에있는 폴더와 파일만 반환한다.
		dir = new File("C:\\Users\\adminn\\Desktop\\web-hyi\\java\\ex_0415");
		String[] names = dir.list();
		
		if(names != null) {
			System.out.println(Arrays.toString(names));
		}
		
		// listFiles()
		// File[] 배열로 반환
		
		File[] files = dir.listFiles((d,name) -> name.endsWith(".txt")); // .txt 가 붙은 파일만 보여준다.
		for(File file : files) {
			System.out.println(file.getName());
		}
		
		
	}
}
