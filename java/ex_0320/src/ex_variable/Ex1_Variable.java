package ex_variable;

public class Ex1_Variable {

	public static void main(String[] args) {
		//sysout 템플릿으로 만들기
		//System.out.println(10);
		//System.out.println(3.14);
		//System.out.println("홍길동");
		
		int x; //x라는 이름의 정수타입의 변수를 선언
		
		x = 10; //변수 x에 10을 대입
		//수학에서 =  -> 좌변과 우변이 같다는 의미
		//프로그래밍 언어에서 = -> 우변에 값을 좌변에 대입한다는 의미
		
		System.out.println(x+1); //일회성 연산
		
		//연산 후 x의  값은? -> 10
		System.out.println(x);	//x의 값은 불변
		
		x= 55;	//기본의 값을 버리고 새로운 값을 대입할 수 있다.
		System.out.println(x);	// -> 55
		
		//변수 x의 값에 연산을 한 후 다시 대입하면 연산한 값이 유지가 된다.
		//값을 유지하기 위해서는 대입해야  함.
		x = x + 1;
		System.out.println(x); // -> 56
	}

}
