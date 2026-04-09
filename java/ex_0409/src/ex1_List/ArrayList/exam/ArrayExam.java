package ex1_List.ArrayList.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayExam {
	public static void main(String[] args) {
		
		// Integer 타입의 리스트 객체 만들기
		List <Integer> list = new ArrayList<Integer>();
		
		// 리스트에 (1~30 사이의)난수 10개 넣기
		Random r = new Random();
		
		for(int i = 0; i < 10; i++) { // 10개의 숫자를 한정
			int rNum = r.nextInt(30)+1; // 1~30 난수
			list.add(rNum); // list에 넣겠다
		}
		
		System.out.println("생성된 난수 : " + list);
		
		// 리스트에 담긴 데이터 중 홀수의 총합을 구하세요
		int sum = 0; // 값을 담을 곳은 초기화
		//for(int num : list) {
		//	if(num % 2 != 0) { // num을 2로 나눴는데 0이 아니면
		//		sum += num; // 반복해서 저장되어 있는 sum(총합)에 num(나오는 홀수)를 다 더해라
		//	}
		//}
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) % 2 == 1){
				sum += list.get(i);
			}
		}
		
		System.out.println("홀수의 총합 : " + sum);
		
	}
}
