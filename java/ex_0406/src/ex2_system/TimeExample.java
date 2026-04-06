package ex2_system;

public class TimeExample {
	public static void main(String[] args) {
		
		// currentTimeMillis()
		// 1970년 1월 1일 0시 0분 0초부터 현재까지 흐른 시간을 밀리초 단위로 반환
		// 로그 시간을 쓰거나 날짜를 계산할 때 사용한다.
		long time = System.currentTimeMillis();
		System.out.println(time); // 1775444629137
		
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10000000; i++) {}; // 작업
		
		long end = System.currentTimeMillis();
		System.out.println("걸린시간(ms) : " + (end - start)); // 걸린시간(ms) : 1
		
		/////
		
		// nanoTime()
		// 정확한 시간을 측정하기 위한 메서드
		// 나노초 (1초 = 10억 ns)
		// 성능 테스트를 하거나 알고리즘 비교를 할 때 사용한다.
		
		start = System.nanoTime();
		for(int i = 0; i < 10000000; i++) {}; // 작업
		
		end = System.nanoTime();
		System.out.println("걸린시간(ms) : " + (end - start)); // 걸린시간(ms) : 1579800
		
	}
}
