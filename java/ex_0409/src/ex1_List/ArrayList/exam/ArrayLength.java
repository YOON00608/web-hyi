package ex1_List.ArrayList.exam;

import java.util.ArrayList;
import java.util.List;

public class ArrayLength {
	public static void main(String[] args) {
		
		// 문자열 타입 리스트 객체를 만든다.
		// 리스트에 "Java", "Spring", "HTML", "CSS" 를 저장하기
		// 각 문자열의 길이를 계산하여 lengths 라는 새로운 리스트를 만들어서 저장하기
		// lengths 리스트를 출력하기
		
		List<String> list = new ArrayList<>();
		list.add("Java"); list.add("Spring"); list.add("HTML"); list.add("CSS");
		
		List<Integer> lengths = new ArrayList<>();
		
		for(String str : list) { // list에 담긴 문자열을 str이라는 임시 변수에 담는다.
			lengths.add(str.length()); // str.length() : str에 담긴 문자열의 길이를 숫자로 반환한다.
		}
		
		System.out.println(lengths);
		
		List<String> name = new ArrayList<String>();
		name.add("김철수");
		name.add("이영희");
		name.add("김철수");
		name.add("박민수");
		name.add("김철수");
		
		int count = 0;
		for(String s : name) {
			if(s.equals("김철수")) {
				count++;
			}
		}
		
		System.out.println("몇 번 : " + count);
		
		List<Integer> scores = new ArrayList<Integer>();
		scores.add(87);
		scores.add(72);
		scores.add(95);
		scores.add(60);
		scores.add(81);
		
		int max = scores.get(0); // 최고점수 초기값
		int min = scores.get(0); // 최소점수 초기값
		
		for(int score : scores) { 
			if(score > max) {	// 돌다가 더 큰 점수 발견하면 max에 넣어라
				max = score;
			} if(score < min) { // 돌다가 더 작은 점수 발견하면 min에 넣어라
				min = score;
			}
		}
		
		int difference = max - min; 
		
		System.out.println("최고 점수 : " + max);
		System.out.println("최소 점수 : " + min);
		System.out.println("두 점수의 차이 : " + difference);
		
	}
}
