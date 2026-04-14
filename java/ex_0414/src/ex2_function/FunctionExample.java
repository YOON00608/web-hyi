package ex2_function;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// 람다식의 합성 : 여러 함수를 하나의 함수처럼 연결해서 새로운 함수를 만드는 것

// 람다식의 결합 : 함수 실행을 순서대로 이어서 실행하는 것

public class FunctionExample {
	public static void main(String[] args) {
		// java에서는 다음 인터페이스에서 합성을 지원한다.
		// Function<T,R>
		// Predicate<T>
		// Consumer<T>
		
		// 핵심 메서드
		// andThen()
		// 현재 함수를 실행 -> 다음 함수를 실행한다.
		
		Function<Integer, Integer> multiply = x -> x * 2;
		Function<Integer, Integer> add = x -> x + 3;
		
		Function<Integer, Integer> result = multiply.andThen(add);
		System.out.println(result.apply(5)); 
		// 5 -> multiply -> 10 -> add -> 13
		
		// compose()
		// 괄호 안의 함수를 실행 -> 앞에 있는 함수를 실행
		
		result = multiply.compose(add);
		System.out.println(result.apply(5));
		// 5 -> add -> 8 -> multiply -> 16
		
		// Predicate의 결합 (조건 합치기)
		
		Predicate<Integer> isPositive = x -> x > 0;
		Predicate<Integer> isEven = x -> x % 2 == 0;
		
		// and()
		Predicate<Integer> result2 = isPositive.and(isEven);
		
		System.out.println(result2.test(4)); // true
		System.out.println(result2.test(-2)); // false
		
		// x > 0 && x % 2 == 0
		
		// or()
		result2 = isPositive.or(isEven);
		
		System.out.println(result2.test(4)); // true
		System.out.println(result2.test(-2)); // true
		
		// negate()
		result2 = isPositive.negate();
		System.out.println(result2.test(5));
		
		// Consumer<T>의 결합
		// andThen()
		
		Consumer<String> print1 = s -> System.out.println("1 : " + s);
		Consumer<String> print2 = s -> System.out.println("2 : " + s);
		
		Consumer<String> result3 = print1.andThen(print2);
		result3.accept("Hello");
		
		
		Scanner sc = new Scanner(System.in);
		
		Function<String, String> Replace = s -> s.replace(" ", "");
		Function<String, String> lower = s -> s.toLowerCase();
		Function<String, String> prefix = s -> "user_" + s;
		
		Function<String, String> pipeline = Replace.andThen(lower).andThen(prefix);
		
		System.out.print("문자열 입력 : ");
		String message = sc.nextLine();
		
		String result4 = pipeline.apply(message);
		System.out.println(result4);
		
		
		
		
		
		
		
		
		
	}
}
