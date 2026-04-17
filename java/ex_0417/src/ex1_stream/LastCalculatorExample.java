package ex1_stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LastCalculatorExample {
	public static void main(String[] args) {

		// 최종연산
		// 스트림처리의 마지막 단계
		// 이 단계가 와야 스트림이 실제로 동작한다.

		// 스트림 파이프라인의 마지막에서 실행되는 연산

		// count()
		// 조건에 맞는 요소 개수를 센다.
		List<String> words = Arrays.asList("java", "spring", "db", "react");

		long count = words.stream().filter(s -> s.length() >= 5).count();

		System.out.println("길이가 5이상인 요소의 개수 : " + count);

		// anyMatch()
		// 하나라도 조건에 맞는 요소가 있으면 true 아니면 false를 반환한다.

		List<Integer> numbers = Arrays.asList(1, 3, 5, 8);

		boolean result = numbers.stream().anyMatch(x -> x % 2 == 0);

		System.out.println(result);

		// allMatch()
		// 모든 요소가 조건에 맞아야 true

		result = numbers.stream().allMatch(x -> x % 2 == 0);

		System.out.println(result);

		// noneMatch()
		// 모든 요소가 조건에 하나도 맞지 않아야 true

		result = numbers.stream().noneMatch(x -> x % 2 == 0);

		System.out.println(result);

		// 결과를 모으는 최종 연산
		// collect()
		// 스트림의 결과를 리스트, 셋, 맵 등으로 모으는 최종 연산이다.

		// Collectors.toList() : 결과를 리스트로 반환
		words.stream().filter(s -> s.length() >= 5).collect(Collectors.toList());

		// Collectors.toSet() : 셋으로 반환

		// Collectors.toMap(k,v) : 맵으로 반환

		// 누적해서 합치기
		// reduce()

		int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		// 시작값 : 0
		// 1. 시작값이 a로 들어간다.
		// 2. 컬렉션의 요소들은 b로 들어간다.
		// 3. 더한 값을 a에 넣는다.
		// 4. 다음 요소를 b에 넣는다.
		// 5. 모든 요소를 순회할 때까지 반복한다.

		System.out.println(sum);

		// toArray()
		// 스트림 결과를 배열로 반환

		Object[] arr = numbers.stream().toArray();

		// 기본형 스트림 전용 최종 연산

		// sum()
		sum = IntStream.rangeClosed(1, 5).sum();
		System.out.println("결과 : " + sum);

		// average()
		OptionalDouble avg = IntStream.of(10, 20, 30).average();

		// Optional 클래스
		// 자바에서 값이 있을 수도 있고, 없을 수도 있다는 상황을
		// 안전하게 표현하기 위한 클래스이다.

		// 객체에 값이 들어있지 않으면 NPE가 발생한다.

		// 값이 안 들어있으면 기본값을 반환해라.
		double average = avg.orElse(0.0);

		// ifPresent()
		// 값이 있을 때만 실행한다.
		avg.ifPresent(System.out::println);

		// max()
		// 최대값 구하기
		OptionalInt max2 = IntStream.of(7, 3, 2, 9).max();
		max2.ifPresent(System.out::println);
		
		// min()
		// 최소값 구하기
		OptionalInt min = IntStream.of(7, 3, 2, 9).min();
		min.ifPresent(System.out::println);
		
		
		
		
		
		
		

	}
}
