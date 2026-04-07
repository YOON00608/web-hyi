package ex3_generic;

// 클래스에 제네릭을 부여하게 되면 해당 클래스를 선언할 때 데이터 타입을 부여하게 된다.
public class DataList<T> {
	
	private Object[] data;
	private int size;
	private int defaultSize = 10;
	
	// defaultSize 만큼의 배열을 생성하는 생성자 만들기
	public DataList() {
		data = new Object[defaultSize];
	}
	
	// size 값을 전달 받아서 size 크기 만큼의 길이를 받는 배열을 만드는 생성자 만들기
	public DataList(int size) {
		data = new Object[size];
	}
	
	// 값을 받아서 배열에 순차적으로 넣는 add 메서드 만들기
	public void add(T value) {
		data[size++] = value;
	}
	
	// 인덱스를 받아서 배열의 값을 반환하는 get 메서드 만들기
	public T get(int index) {
		return (T)data[index];
	}
	
	// 배열에 데이터가 몇 개 들어가 있는지 확인하는 size() 메서드 만들기
	public int size() {
		return size;
	}
	
}
