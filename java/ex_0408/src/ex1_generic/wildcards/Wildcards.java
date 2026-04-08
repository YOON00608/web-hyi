package ex1_generic.wildcards;

import java.util.List;

// 와일드카드
// 제네릭 타입에서 "정확한 타입은 모르겠지만, 어떤 범위 안에 있는 타입이다."
// 라고 표현할 때 사용한다.
// List<String> : 정확히 String 을 담는 리스트
// List<Integer> : 정확히 Integer 을 담는 리스트

	// 와일드 카드의 기본 문법
	// <?> : 타입을 모른다. 아무 타입이나 가능하다.
	public class Wildcards {
	
	public void printList(List<?> list) {
		for(Object obj : list) {
			System.out.println(obj);
		}
	}
	
	// <? extends T> : T 또는 T의 자식 타입만 가능하다. (상한 제한)
	// Number 클래스이거나, Number를 상속받은 자식 클래스들만 들어올 수 있다.
	public void printNumbers(List<? extends Number> list) {
		for(Number obj : list) {
			System.out.println(obj);
		}
	}
	
	// <? super T> : T 또는 T의 부모 타입만 가능하다. (하한 제한)
	// 이 리스트는 최소한 Integer를 담을 수 있는 상자여야 한다.
	// 그러니 Integer 본인이거나, Integer의 조상(부모) 타입 리스트만 가능하다.
	public void addNumbers(List<? super Integer> list) {
		for(Object obj : list) {
			System.out.println(obj);
		}
	}
	
}
