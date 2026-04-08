package ex1_generic.wildcards;

import java.util.Arrays;
import java.util.List;

public class WildcardsMain {
	public static void main(String[] args) {
		
		Wildcards wc = new Wildcards();
		List<String> list1 = Arrays.asList("A","B","C");
		List<Integer> list2 = Arrays.asList(1,2,3);
		List<Double> list3 = Arrays.asList(1.1,2.2,3.3);
		
		wc.printList(list1);
		wc.printList(list2);	
		
		// wc.printNumbers(list1); String 과는 관계가 없음.
		wc.printNumbers(list2);
		wc.printNumbers(list3);
		
		// wc.addNumbers(list1);
		wc.addNumbers(list2);
		// wc.addNumbers(list3);
	}
}
