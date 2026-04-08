package ex1_generic.exam5;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		SumExample s = new SumExample();
		
		List<Integer> a = Arrays.asList(1,2,3,4,5);
		List<Double> b = Arrays.asList(1.2,2.2,3.3,4.4,5.5);
		
		System.out.println(s.sum(a));
		System.out.println(s.sum(b));
		
	}
}
