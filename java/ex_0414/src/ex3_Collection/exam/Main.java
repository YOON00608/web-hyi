package ex3_Collection.exam;

import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		
		ProductService service = new ProductService();
		
		// 상품 등록
		service.addProduct(new Product("POO1", "삼각김밥", 1200, 10));
		service.addProduct(new Product("POO2", "콜라", 2000, 0));
		service.addProduct(new Product("POO3", "도시락", 4500, 5));
		
		// 전체 상품 출력
		System.out.println(" === 전체 상품 목록 === ");
		service.printAllProduct();
		
		// P001 가격 10% 인상
		service.updateProduct("POO1", p -> {p.setPrice((int)(p.getPrice() * 1.1));
		return p;
		});
		
		// P003 상품명 앞뒤 공백 제거
		service.updateProduct("P003", p -> {
			p.setName(p.getName().trim());
			return p;
		});
		
		// 재고가 있는 상품만 조회
		System.out.println(" === 재고가 있는 상품 === ");
		Predicate<Product> hasStock = p -> p.getStock() > 0;
		service.findProductsByCondition(hasStock);
		
		// 품절 상품 삭제
		Predicate<Product> outOfStock = p -> p.getStock() == 0;
		service.deleteProductsByCondition(outOfStock);
		
		// 삭제 후 전체 출력
		System.out.println(" === 품절 상품 삭제 후 === ");
		service.printAllProduct();
		
	}
}
