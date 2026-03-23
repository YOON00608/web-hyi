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
		
		// -------------------------------------------
		
		// 컴파일 단계에서 연산
		byte result = 10 + 20;
		System.out.println("result : " + result);
		
		byte v1 = 10;
		byte v2 = 20;
		// java에서는 byte, short, char끼리의 연산은
		// 자동으로 int로 변환이 된다.
		
		// 실행 시점에 연산이 된다.
		// 컴파일러는 확실히 값이 고정된 경우에만 미리 계산한다.
		byte v3 = (byte)(v1 + v2);
		int v4 = v1 + v2;
		
		System.out.println(v3);
		System.out.println(v4);
		
		
		
	}
}
