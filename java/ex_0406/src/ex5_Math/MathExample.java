package ex5_Math;

public class MathExample {
	public static void main(String[] args) {
		
		// ceil() : 올림
		double v1 = Math.ceil(5.3);
		System.out.println(v1); // 6.0
		
		// floor() : 내림
		double v2 = Math.floor(5.3);
		System.out.println(v2); // 5.0
		
		// abs() : 절대값
		double v3 = Math.abs(-10);
		System.out.println(v3); // 10.0
	
		// max() : 최대값 찾기
		long v4 = Math.max(3, 7);
		System.out.println("더 큰 수 : " + v4); // 더 큰 수 : 7
		
		// Min() : 최소값 찾기
		long v5 = Math.min(3, 7);
		System.out.println("더 작은 수 : " + v5); // 더 작은 수 : 3
		
		 int[] arr = {5,2,9,1,7};
		 // max(), min() 을 활용하여 최대값과 최소값 구하기
		 // 최대값 : 9, 최소값 : 1
		 int max = arr[0];
		 int min = arr[0];
		
		 for(int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		 }
		 System.out.println("최대 값 : " + max);
		 System.out.println("최소 값 : " + min);
		
		// round() 반올림
		// 무조건 소수점 첫째 자리에서 반올림을 한다.
		System.out.println(Math.round(3.15)); // 3
		
		double pi = 3.14159;
		double result2 = Math.round(pi*100)/100.0;
		System.out.println(result2); // 3.14
		
		// pow() : 제곱
		System.out.println(Math.pow(2,3)); // 8.0
		
		// sqrt() : 제곱근
		System.out.println(Math.sqrt(9.0)); // 3.0
		
		// 10 ~ 20 사이의 랜덤정수를 출력하기
		int num = (int) (Math.random() * 11) + 10;
		System.out.println(num);
		
		// 두 점 사이의 거리를 구하세요
		// x1 = -5, x2 = 8
		
		int x1 = -5;
		int x2 = 8;
		
		double distance = Math.abs(x1 - x2);
		System.out.println("두 점 사이의 거리 : " + distance); // 두 점 사이의 거리 : 13.0
		
		// 물건 53개를 한 박스에 8개씩 담으려고 한다.
		// 필요한 박스의 개수를 구하세요.
		
		int total = 53;
		int box = 8;
		
		int boxes = (int) Math.ceil((double)total / box);
		System.out.println("필요한 박스 개수 : " + boxes); // 필요한 박스 개수 : 7
		
		
	}
}
