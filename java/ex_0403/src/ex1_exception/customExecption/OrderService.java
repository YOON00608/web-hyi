package ex1_exception.customExecption;

public class OrderService {
	
		public int calculateTotal(int price, int quantity) throws IllegalAccessException{
			if(price < 0) {
				throw new IllegalArgumentException("가격이 1이상이어야 합니다.");
			}
			if(quantity < 0) {
				throw new IllegalArgumentException("수량은 1이상이어야 합니다.");
			}
			return price * quantity;
		}
	
}
