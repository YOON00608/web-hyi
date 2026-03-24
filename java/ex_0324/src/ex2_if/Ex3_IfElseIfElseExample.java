package ex2_if;

public class Ex3_IfElseIfElseExample {
	public static void main(String[] args) {
		int score = 0;
		// 점수가 100 ~ 90점 "A"
		// 89 ~ 80 "B"
		// 79 ~ 70 "C"
		// 69 ~ 60 "D"
		// 59 ~ 0 "F"
		// 0보다 작은 수가 들어왔을 때도 " 다시 입력해주세요 " 출력하기
		
		if(score > 100 || score < 0) {
			System.out.println("다시 입력해주세요.");
		} else if (score >= 90) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else if (score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}  
		
		
		
		
	}
}
