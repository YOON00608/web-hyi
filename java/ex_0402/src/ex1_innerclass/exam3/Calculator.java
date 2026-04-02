package ex1_innerclass.exam3;

public class Calculator {
	
	public static interface Result{
		int value();
	}
	
	private Result result;

	public void setResult(Result result) {
		this.result = result;
	}
	
	void add(int a, int b) {
		int sum = a + b;
		System.out.println("계산 결과 : " + sum);
	}
	
}
