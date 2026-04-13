package ex1_Map.exam;

import java.util.HashMap;
import java.util.Map;

public class StudentAvg {
	public static void main(String[] args) {
		
		// 이름은 key, 점수를 value로 저장한다.
		// 평균, 최고점 학생을 찾는다.
		
		// ex)
		// 평균점수 : 80점
		// 최고 점수 학생 : 홍길동 / 90점
		
		Map<String,Integer> map = new HashMap<>();
		
		map.put("홍길동", 90);
		map.put("김길동", 55);
		map.put("나길동", 70);
		map.put("박길동", 80);
		
		int sum = 0;
		for(int score : map.values()){
			sum += score;
		}
		
		double avg = (double) sum / map.size();
		System.out.println("평균점수 : " + avg + "점");
		
		
		String topStudent = "";
		int topScore = 0;
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() > topScore) {
				topScore = entry.getValue();
				topStudent = entry.getKey();
			}
		}
		
		System.out.println("최고 점수 학생 : " + topStudent + "/" + topScore + "점");
		
	}
}
