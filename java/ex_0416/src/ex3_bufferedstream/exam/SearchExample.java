package ex3_bufferedstream.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class SearchExample {
	public static void main(String[] args) {
		
		try(
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader brFile = new BufferedReader(new FileReader("story.txt"));
		){
			System.out.print("검색어 입력 : ");
			
			String searchWord = keyboard.readLine();
			
			String line;
			boolean isFound = false;
			
			System.out.println("=== 검색 결과 ===");
			while((line = brFile.readLine()) != null) {
				if(line.contains(searchWord)) {
					System.out.println("- " + line);
					isFound = true;
				}
			}
			if(!isFound) {
				System.out.println("해당 단어가 포함된 문장이 존재하지 않습니다.");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
