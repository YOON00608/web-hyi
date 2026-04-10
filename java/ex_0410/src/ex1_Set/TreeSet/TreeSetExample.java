package ex1_Set.TreeSet;

import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		// TreeSet
		// 데이터를 자동으로 정렬하면서 저장하는 set
		// 1. 중복이 허용되지 않는다.
		
		TreeSet <Integer> scores = new TreeSet<>();
		scores.add(50);
		scores.add(10);
		scores.add(30);
		scores.add(20);
		scores.add(30); // 중복 허용 x
		
		System.out.println(scores); // [10, 20, 30, 50] 자동정렬
		
		// TreeSet 은 정렬되어 있기 때문에 특정 범위의 데이터 검색이 편하다.
		System.out.println(scores.first()); // 10
		System.out.println(scores.last()); // 50
		
		// lower(x)
		// x 보다 작은 값 중에서 가장 가까운 값
		System.out.println(scores.lower(30)); // 20
		
		// higher(x)
		// x 보다 큰 값 중에서 가장 가까운 값
		System.out.println(scores.higher(30)); // 50
		
		// 중위 순회
		// 왼쪽 -> 부모 -> 오른쪽
		// 왼쪽끝 -> 10
		// 10의 오른쪽 -> 20
		// 루트 -> 30
		// 오른쪽 -> 50
		
	}
}
