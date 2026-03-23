package ex2_casting;

public class Ex2_DemotionExample {
	public static void main(String[] args) {
		
		// int > byte
		int var1 = 10;
		byte var2 = (byte)var1;
		System.out.println(var2); // 10 그대로 유지
		
		// long > int
		long var3 = 300;
		int var4 = (int)var3;
		System.out.println(var4); // 300 그대로 유지
		
		// int > char
		int var5 = 65;
		char var6 = (char)var5;
		System.out.println(var6); // A 출력
		
		// 위 경우에서는 값의 손실은 없다.
		
		// double > int
		double var7 = 3.1415952;
		int var8 = (int)var7;
		System.out.println(var8); // 3 출력
		
		// 실수를 정수로 변환하면 소수점 아래에 숫자들이 소실된다.
		// 내가 생각한 것과 다른 결과가 나올 수 있으므로,
		// 주의해야 한다.
		
	}
}
