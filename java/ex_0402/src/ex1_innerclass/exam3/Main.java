package ex1_innerclass.exam3;

public class Main {
	public static void main(String[] args) {
		Calculator re = new Calculator();
		
		re.setResult(new Calculator.Result() {
			
			@Override
			public int value() {
				return 0;
			}
		});
		
		re.add(10, 10);
	}
	
	
	
	
}
