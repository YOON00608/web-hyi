package ex1_generic.exam;

public class GenericBox<T> {
	
	private T item;
	
	public void setBox(T item) {
		this.item = item;
	}
	
	public T getBox() {
		return item;
	}
	
}
