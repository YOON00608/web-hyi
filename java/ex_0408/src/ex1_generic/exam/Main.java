package ex1_generic.exam;

public class Main {
	public static void main(String[] args) {
		
		GenericBox<String> bx = new GenericBox<>();
		
		bx.setBox("사과");
		System.out.println(bx.getBox());
		
		///
		
		GenericBox<Integer> bx2 = new GenericBox<>();
		
		bx2.setBox(100);
		System.out.println(bx2.getBox());
		
	}
}
