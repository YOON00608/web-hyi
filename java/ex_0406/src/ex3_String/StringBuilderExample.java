package ex3_String;

public class StringBuilderExample {
	public static void main(String[] args) {
		
		// toString() 을 제외한 다른 메서드는 StringBuilder 객체를 반환한다.
		// 그렇기 때문에 연이어서 다른 메서드를 호출할 수 있는 메서드 체이닝 패턴을 사용할 수 있다.
		String data = new StringBuilder()
				.append("DEF") // 문자열을 끝에 추가
				.insert(0, "ABC") // 문자열을 지정 위치에 추가
				.delete(3, 4) // 문자열 일부를 삭제 (3이상 4미만이라고 생각하자)
				.toString(); // 완성된 문자열을 반환
		System.out.println(data); // ABCEF
		
		// 범위를 가지고 사용하는 메서드의 특징 : 
		// 대부분 끝값은 포함하지 않는다.
		
	}
}
