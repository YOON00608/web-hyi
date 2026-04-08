package ex1_generic.exam5;

import java.util.List;

public class SumExample {
	
	public double sum(List<? extends Number> list) {
		
		double total = 0;
		for(Number n : list) {
			total += n.doubleValue();
		}
		return total;
	}
}
