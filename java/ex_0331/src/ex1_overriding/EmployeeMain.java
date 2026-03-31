package ex1_overriding;

public class EmployeeMain {
	public static void main(String[] args) {
			
		Employee e = new Employee("김철수");
		System.out.println(e.getPay());
		
		RegularEmployee e1 = new RegularEmployee("정규직 김철수",3000000);
		System.out.println(e1.name+ " : " + e1.getPay());
		
		PrartTimeEmployee e2 = new PrartTimeEmployee("아르바이트 이영희",100000,50);
		System.out.println(e2.name +" : "+ e2.getPay());
		
	}
}
