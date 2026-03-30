package ex1_final;

public class KoreanMain {
	public static void main(String[] args) {
		
		Korean k1 = new Korean("112345-1234567","김자바");
		
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		System.out.println(k1.name);
		
		// k1.nation = "일본"; 
		// k1.ssn = "123332-1234567";
		// 두 필드는 final로 정하였기 때문에 값을 변경할 수 없다.
		k1.name = "나카무라";
		System.out.println(k1.name);
		
		
	}
}
