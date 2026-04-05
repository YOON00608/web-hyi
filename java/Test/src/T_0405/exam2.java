package T_0405;

public class exam2 {
	// 학생 3명을 배열에 넣고 이름을 출력하세요.
	
	String name;
	
	public exam2(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		
		exam2[] s = {
				new exam2("고길동"),
				new exam2("홍길동"),
				new exam2("김길동")
		};
		
		for(exam2 e : s){
			System.out.println(e.name);
		}
		
	}
	
}
