package ex1_Map.exam;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
	public static void main(String[] args) {
		
		// 단어 빈도수 분석기
		
		// 문자열을 공백을 기준으로 분리한다.
		// 모두 소문자로 바꾼다.
		// HashMap<String,Integer>에 단어별 개수를 지정한다.
		// String text = "Apple banana apple Banana apple";
		
		Map <String,Integer> map = new HashMap<>();
		String text = "Apple banana apple Banana apple";
		
		// 문자열을 공백을 기준으로 분리한다.
		// 모두 소문자로 바꾼다.
		String[] words = text.toLowerCase().split(" ");
		
		// HashMap<String,Integer>에 단어별 개수를 지정한다.
		
		for (String word : words) {
		    
		    if (map.containsKey(word)) {
		        map.put(word, map.get(word) + 1); // 기존 값 +1
		    } else {
		        map.put(word, 1); // 처음 등장 시 1로 초기화
		    }
		}
	
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
		    System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
