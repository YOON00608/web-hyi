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
		
		
		
		
	}
}
