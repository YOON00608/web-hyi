package ex1_abstract.Example.AllExample;

public class Main {
	public static void main(String[] args) {
		
		// 부모 타입 배열 사용하기
		// 반복문(for)을 사용하여 모든 객체의 printFare()를 호출하시오.
		Transport[] t = {new Bus("버스",1200),
						 new Taxi("택시",3000,10,100),
						 new AirPlane("비행기",1200,1000,2000)};
		for(Transport transport : t) {
			transport.printFare(50);
			System.out.println("--------");
		}
	}
}
