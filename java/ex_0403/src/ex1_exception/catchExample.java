package ex1_exception;

public class catchExample {
	public static void main(String[] args) {
		
		// catch 메서드는 시스템으로부터 넘어오는 예외 객체를 받아서 처리한다.
		try {
			String[] arr = {"100","1oo"};
			
			for(int i = 0; i <= arr.length; i++) {
				int value  = Integer.parseInt(arr[i]);
			}
			// 해당 타입의 예외가 발생하면 catch 블록이 실행된다.
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없음 : " + e.getLocalizedMessage());
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println("배열 인덱스가 초과됨 : " + e.getMessage());
		
			// 예외가 발생하면 catch 블록은 위에서부터 차례대로 검사 대상이 되는데,
			// 하위 예외도 상위 클래스타입 변수에 대입 될 수 있기 때문에
			// 마지막에 써야 한다.
		} catch (Exception e) {
			System.out.println("실행에 문제가 있습니다."); // 위 두 개를 제외한 나머지 예외를 다 받음
		}
	}
}
