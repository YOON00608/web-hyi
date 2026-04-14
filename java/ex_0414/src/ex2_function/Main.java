package ex2_function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// 메서드를 만들 때 발생하는 다양한 경우의 수를
// 인터페이스로 만들어 놓은 것

// 매번 인터페이스로 만들어야 하는 번거로움이 줄어든다.

public class Main {
	public static void main(String[] args) {
		
		// 출력
		// 저장
		// 로그 남기기
		// 리스트 요소 하나씩 처리하기
		// Cosumer<T>
		
		Consumer<String> consumer = str -> System.out.println("출력 : " + str);
		consumer.accept("안녕하세요");
		consumer.accept("자바");
		
		List<String> fruits = Arrays.asList("사과","바나나","포도");
		
		// 과일 1개를 출력하는 람다식 만들기
		Consumer<String> printer = System.out::println;
		
		// 리스트에 들어있는 모든 내용을 람다식을 이용해 출력해보기
		for(String fruit : fruits) {
			printer.accept(fruit);
		}
		
		// Supplier<T>
		// 값을 만들어서 공급하는 인터페이스
		// 입력은 없고, 반환값만 있다.
		// T get()
		
		Supplier<String> supplier = () -> "안녕하세요.";
		System.out.println(supplier.get());
		
		// Supplier을 사용해 랜덤 주사위 눈을 반환받는 람다식 만들고 눈 뽑기
		
		Supplier<Integer> dice = () -> (int)(Math.random()*6)+1;
		System.out.println(dice.get());
		
		
		// 즉시 객체를 생성
		// 실행하면 무조건 객체가 만들어진다.
		ExpensiveObject obj = new ExpensiveObject();
		
		// Supplier 로 선언을 한다고 해서 객체가 만들어지는 건 아니다.
		Supplier<ExpensiveObject> supplier2 = () -> new ExpensiveObject();
		
		// 필요할 때 get()을 호출해서 객체를 생성한다.
		supplier2.get();
		
		
		// Function<T,R>
		// 입력값을 받아서 다른 결과값으로 변환하는 인터페이스
		// R apply(T t)
		
		// 문자열 길이 구하기
		
		Function<String, Integer> lengthGunction = str -> str.length();
		System.out.println(lengthGunction.apply("hello")); // 5
		System.out.println(lengthGunction.apply("java")); // 4
		
		// numbers에 들어있는 모든 요소에 2를 곱하여 result에 넣기
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> result = new ArrayList<>();
		
		Function<Integer, Integer> num = n -> n * 2;
		for(Integer n : numbers) {
			result.add(num.apply(n));
		}
		
		System.out.println(result);
		
		// Predicate<T>
		// 값을 받아서 조건을 검사한 뒤 true/false를 반환하는 인터페이스
		// boolean test(T t);
		
		Predicate<String> isLongText = str -> str.length() >= 5;
		
		System.out.println(isLongText.test("java")); // false
		System.out.println(isLongText.test("spring")); // true
		
		// BiConsumer<T,U>
		// 값을 두 개 받아서 소비만 한다.
		// void accept(T t, U u);
		
		BiConsumer<String, Integer> printUser =
				(name, age) -> System.out.println("이름 : " + name + ", 나이 : " + age);
		
		printUser.accept("김철수", 25); // 이름 : 김철수, 나이 : 25
		
		// BiPredicate<T,U>
		// 값을 두 개 받아서 조건 검사 후 true/false 반환
		// boolean test(T t, U u)
		
		BiPredicate <String,String> isSame =
				(a,b) -> a.equals(b);
		System.out.println(isSame.test("java", "java")); // true
		System.out.println(isSame.test("java", "spring")); // false
		
		
		
		
		
	}
}
