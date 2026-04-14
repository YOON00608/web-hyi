package ex3_Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionExample {
	public static void main(String[] args) {
		
		// List, Set 계열에서 공통적으로 쓰이는 메서드
		List<String> list = Arrays.asList("사과","바나나","포도");
		
		list.forEach(s -> System.out.println(s));
		
		// removeIf()
		List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		
		nums.removeIf(x -> x % 2 == 0); // 결과가 true인 것들을 삭제한다.
		System.out.println(nums); // [1, 3, 5, 7, 9]
		
		// 이름에 "민" 글자가 들어있는 사람만 지운 후 출력하기
		Set<String> names = new HashSet<>();
		names.add("김민수");
		names.add("박갑수");
		names.add("홍길동");
		names.add("조민박");
		names.add("최자바");
		
		names.removeIf(n -> n.contains("민"));
		System.out.println(names); // [홍길동, 박갑수, 최자바]
		
		// List 인터페이스
		// replaceAll() : 각 요소를 바꿀 때
		// sort() : 정렬 기준을 람다로 넘길 때
		
		List<String> names2 = new ArrayList<>(Arrays.asList("park","lee","kim"));
		
		names2.replaceAll(name -> name.toUpperCase());
		System.out.println(names2); // [PARK, LEE, KIM]
		
		// compareTo() : 문자열끼리 사전식 비교
		// 사전순으로 뒤에 있는게 더 큰 수라고 판단
		// 음수 : a가 b보다 앞에 와야 한다.
		// 0 : 둘이 같음
		// 양수 : a가 b보다 뒤에 와야 한다.
		names2.sort((a,b) -> a.compareTo(b));
		System.out.println(names2); // [KIM, LEE, PARK]
		
		// Map 인터페이스
		// forEach(BiConsumer<K,V>)
		// 키와 값을 같이 순회할 때 사용
		
		Map<String, Integer> map = new HashMap<>();
		map.put("사과", 1000);
		map.put("바나나", 2000);
		
		map.forEach((key,value) -> System.out.println(key + " " + value));
		
		// replaceAll()
		// 모든 값을 일괄 수정할 때 사용
		map.replaceAll((key,value) -> value + 500);
		System.out.println(map); // {사과=1500, 바나나=2500}
		
		
	}
}
