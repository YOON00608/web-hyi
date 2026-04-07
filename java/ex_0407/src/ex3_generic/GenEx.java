package ex3_generic;

public class GenEx<T> {
	
	// 제네릭 타입의 변수 value;
	T value;
	
	// value 값을 반환하는 getValue();
	public T getValue() {
		return value;
	}
	
	// value 값을 세팅하는 setValue();
	
	public void setValue(T value) {
		this.value = value;
	}
	
	
}
