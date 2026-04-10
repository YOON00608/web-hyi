package ex1_List.ArrayList.product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
		// 1. 장바구니 생성
		private List<Product> products = new ArrayList<>();
		
		// 2. 상품 추가
		// 같은 상품이 들어오면 수량만 증가
		public void addProduct(String name, int price, int quantity) {
			
			// list 의 size() 가 0이면 반복문을 안 들어간다.
			for(Product p : products) {
				if(p.getName().equals(name)) {
					p.setQuantity(p.getQuantity() + quantity);
					System.out.println("기존 상품 수량 증가 완료");
					return;
				}
			} 
			// 넘어온 제품이 겹치지 않는다면 list 에 추가하기
			products.add(new Product(name, price, quantity));
			System.out.println("상품 추가 완료");
		}
		
		// 3. 장바구니 전체 출력
		public void printCart() {
			// 장바구니가 비어있으면 "장바구니가 비어있습니다." 출력하고 종료
			if(products.size() == 0) {
				System.out.println("장바구니가 비어있습니다.");
				return;
			}
			// 모든 상품을 출력하기
			for(Product p : products) {
				System.out.println(p);
			}
		}
		
		// 4. 총 결제 금액 계산
		public void printTotalPrice() {
			int total = 0;
			for(Product p : products) {
				total += p.getTotalPrice();
			}
			System.out.println("총 결제 금액 : " + total+"원");
		}
		
		// 5. 특정 상품 수량 증가
		public void increaseQuantity(String name) {
			for(Product p : products) {
				if(p.getName().equals(name)) {
				p.setQuantity(p.getQuantity() + 1);
				System.out.println(name +" 수량 증가 후: " + p);
				return;
				}
			}
		}
		
		// 6. 특정 상품 삭제
		public void removeProduct(String name) {
			// 제품이 있으면 삭제하고 "상품 삭제 완료"
			for(Product p : products) {
				if(p.getName().equals(name)) {
					products.remove(p);
					System.out.println("상품 삭제 완료");
					break;
				}
			} 
			// 제품이 없으면 "해당 제품이 없습니다."
			System.out.println("해당 제품이 없습니다.");
			
		}
}
