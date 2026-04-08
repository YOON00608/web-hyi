package ex1_generic.exam6;

public class Example {
	
	public static <T> void printFirstAndLast(T[] array){
		
		if (array != null && array.length > 0) {
	        System.out.println(array[0]);
	        System.out.println(array[array.length - 1]);
	    }
	}
	
	public static void main(String[] args) {
		
		Character[] grades = {'A', 'B', 'C', 'D', 'F'};
		Double[] scores = {98.5, 77.0, 80.0, 95.5};
		
		Example.printFirstAndLast(grades);
		Example.printFirstAndLast(scores);
		
	}
}
