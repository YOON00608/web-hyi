package ex2_annotaion.standard;

public class Parent {
	
	public void method() {};
	
	class Child extends Parent{
		
		@Override
		public void method() {
			super.method();
		}
	}
	
}
