package ex2_object.exam;

public class MemberMain {
	public static void main(String[] args) {
		
		Member obj1 = new Member("1", "홍길동");
		Member obj2 = new Member("1", "홍길동");
		Member obj3 = new Member("2", "홍길동");
		
		if(obj1.equals(obj2)) {
			System.out.println("두 회원은 같습니다.");
		} else {
			System.out.println("두 회원은 같지 않습니다.");
		}
		
		if(obj1.equals(obj3)) {
			System.out.println("두 회원은 같습니다.");
		} else {
			System.out.println("두 회원은 같지 않습니다.");
		}
		
		Object[] arr = {"Java", 100, 3.14, new Employee("홍길동","개발팀")};
		
		// 반복문으로 배열을 순회하면서
		// 문자열이면 " 문자열 데이터 : xx "
		// 정수면 " 정수 데이터 : xx "
		// 실수면 " 실수 데이터 : xx "
		// Employee 객체면 이름과 부서를 출력해주세요.
		
		for(Object obj : arr) {
			if(obj instanceof String) {
				String str = (String) obj;
				System.out.println("문자열 데이터 : " + str);
			} else if(obj instanceof Integer) {
				System.out.println("정수 데이터 : " + obj);
			} else if(obj instanceof Double) {
				System.out.println("실수 데이터 : " + obj);
			} else if(obj instanceof Employee) {
				Employee emp = new Employee("홍길동", "IT부서");
				System.out.println("사원 정보 : " + emp);
			}
		}
		
	}
}
