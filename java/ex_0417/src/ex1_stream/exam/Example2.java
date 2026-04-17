package ex1_stream.exam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example2 {
	public static void main(String[] args) {

		// 주문 금액이 50000원 이상인 주문의 개수를 구하시오.
		List<Integer> orders = Arrays.asList(12000, 80000, 45000, 50000, 99000, 30000);
		long count = orders.stream().filter(n -> n >= 50000).count();

		System.out.println("50000원 이상인 주문의 개수 : " + count);

		// 회원 나이 목록이 있을 때 아래를 각각 구하시오.
		// 미성년자가 한 명이라도 있는지
		// 전원 성인인지
		// 100세 초과 회원은 없는지
		List<Integer> ages = Arrays.asList(21, 35, 17, 42, 63, 14);

		boolean result = ages.stream().anyMatch(n -> n < 20);
		System.out.println("미성년자가 한 명이라도 있는지 " + result);

		result = ages.stream().allMatch(n -> n >= 20);
		System.out.println("전원 성인인지 : " + result);
		
		result = ages.stream().noneMatch(n -> n > 100);
		System.out.println("100세 초과 회원은 없는지 : " + result);
		
		// 정수 리스트에서 짝수만 골라 제곱한 값들의 총합을 구하시오.
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		
		int result2 = numbers.stream()
		.filter(n -> n % 2 == 0)
		.map(n -> n * n)
		.reduce(0, (a,b) -> a + b);
		
		System.out.println(result2);
		
		// 학생 점수 목록에서 80점 이상인 점수만 내림차순 정렬하여 새로운 리스트로 만드시오.
		List<Integer> scores = Arrays.asList(55,90,82,67,99,80,73);
		
		scores.stream()
		.filter(n -> n >= 80)
		.sorted((a,b) -> b - a)
		.forEach(x -> System.out.print(x + " "));
		
		// 다음 Product 객체 "리스트"를 이용하여
		// 상품명(name)을 key, 가격(price)을 value로 가지는 Map을 생성하시오.
		// 단, 가격이 10000원 이상인 상품만 포함하시오.
		
		List<Product> products = Arrays.asList(
				new Product("마우스",8000),
				new Product("키보드",30000),
				new Product("모니터",150000),
				new Product("노트",2000)
				);
		
		
		Map<String, Integer> productMap = products.stream()
				.filter(p -> p.getPrice() >= 10000)
				.collect(Collectors.toMap(Product::getName, Product::getPrice));
		
		System.out.println(productMap);
		

	}
}
