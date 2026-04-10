package ex1_Set.HashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Set 인터페이스가 제공하는 메서드
// void add(E e) : 데이터를 삽입
// void remove(Object o) : 선택된 데이터를 삭제
// void clear() : 모든 데이터를 삭제
// int size() : 저장된 데이터의 개수를 반환
// contains(E e) : set 에 해당 데이터가 저장 되어있는지 확인

public class HashSetExample {
	public static void main(String[] args) {
		
		// HashSet 클래스는 Set 인터페이스에서 가장 많이 사용되는 구현클래스이다.
		Set<String> set = new HashSet<>();
		
		set.add("Java");
		set.add("Spring");
		set.add("React");
		set.add("Java"); // 에러는 안 나지만 아예 추가하지 않는다.
		
		System.out.println(set); // [Java, Spring, React] 딱히 정렬이 되진 않는다.
		System.out.println("개수 : " + set.size()); // 3
		
		// HashSet(Collection < ? extends E > c)
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(1,2,3,4,1,2,3,4,2,3,2,4));
		System.out.println(set2); // [1, 2, 3, 4] 알아서 중복을 걸러준다.
		
		// HashSet 에 1~45 사이의 난수 6개 담기
		Set<Integer> lotto = new HashSet<Integer>();
		
		while(lotto.size() < 6) {
			int rand = (int)(Math.random()*45)+1;		
			lotto.add(rand);
			}
			
			System.out.println("로또 번호 : " + lotto);
			
		// set 을 배열로 만들기
		// new Integer[0] -> 배열의 방 개수를 0으로 하면 set이 add 해둔 개수만큼
		// 자동으로 배열의 index가 만들어진다.
		// toArray()
		Integer[] arr = lotto.toArray(new Integer[0]);
			
			
	}
}
