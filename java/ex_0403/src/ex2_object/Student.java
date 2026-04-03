package ex2_object;

public class Student {
	
	private int no;
	private String name;

	public Student(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() { return no; }
	public String getName() { return name; }

	//Object의 hashCode() 메소드를 재정의해서
	// 학생 번호화 이름 해시코드를 합한 새로운 해시코드를 반환하도록 한다.
	@Override
	public int hashCode() {
		int hashCode = no + name.hashCode();
		return hashCode;
	}
}
