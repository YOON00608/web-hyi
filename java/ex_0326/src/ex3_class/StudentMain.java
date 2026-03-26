package ex3_class;

public class StudentMain {
	public static void main(String[] args) {
		
//		Student s = new Student();
//		
//		System.out.println("이름 : " + s.name);
//		System.out.println("나이 : " + s.age);
//		System.out.println("점수 : " + s.score);
//		
//		
//		Student s1 = new Student();
//		s1.name = "홍길동";
//		s1.age = 27;
//		s1.score = 60;
//		
//		System.out.println("이름 : " +s1.name);
//		System.out.println("나이 : " +s1.age);
//		System.out.println("점수 : " +s1.score);
		
		
		Student[] students = new Student[3];
		
		students[0] = new Student("홍길동", 20, 90);
		students[1] = new Student("고길동", 30, 80);
		students[2] = new Student("금길동", 25, 70);
		
		System.out.println();
		for(int i = 0; i < students.length; i++) {
			System.out.println("이름 : " + students[i].name);
			System.out.println("나이 : " + students[i].age);
			System.out.println("성적 : " + students[i].score);
		}
		
		
		
	}
}
