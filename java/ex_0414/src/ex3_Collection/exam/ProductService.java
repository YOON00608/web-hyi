package ex3_Collection.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProductService {
	
	// 제품을 담기 위한 리스트
	private List<Product> productList = new ArrayList<>(); 
	
	// 1. 제품 추가하기
	public void addProduct(Product product) {
		// 입력받은 상품의 코드가 이미 저장소에 있는지 확인
		if(findByCode(product.getCode()) != null) { // 반환값이 null이 아니다.
		
			// 이미 있다면 경고 메시지를 보여주고 메서드를 종료
			System.out.println("이미 존재하는 상품 코드입니다.");
			return;
		}
		// 중복이 없다면 리스트에 새 상품을 추가
		productList.add(product);
	}
	
	// 2. 전체 상품 조회
	public void printAllProduct() {
		for(Product p : productList) {
			System.out.println(p);
		}
	}
	
	// 3. 상품 코드로 조회
	public Product findByCode(String code) {
		for(Product p : productList) {
			if(p.getCode().equals(code)) {
				return p;
			}
		} return null;
	}
	
	// 4. 상품 정보 수정
	public void updateProduct(String code, Function<Product,Product> updater) {
		
		// 코드에 해당하는 제품 한 개 찾기
		Product p = findByCode(code);
		// 없으면 작업 중단
		if(p == null) {
			System.out.println("상품이 존재하지 않습니다.");
			return;
		}
		
		// 이 상품이 리스트의 몇 번째 칸에 있는지 확인
		int index = productList.indexOf(p);
		
		// 외부에서 보낸 '수리 로직(updater)'에 상품을 넣어서
	    // '수정된 결과물(updated)'을 받아옴.
		Product updated = updater.apply(p);
		
		// 리스트의 그 자리에 수정된 상품을 변경
		productList.set(index, updated);
	}
	
	// 5. 조건에 맞는 상품 조회
	public void findProductsByCondition(Predicate<Product> predicate) {
		// 전체 순회하면서
		for(Product p : productList) {
			// 매개변수로 넘어온 람다식의 조건에 맞으면
			if(predicate.test(p)) {
				System.out.println(p);
			}
		}
	}
	
	// 6. 조건에 맞는 상품 삭제
	public void deleteProductsByCondition(Predicate<Product> predicate) {
		productList.removeIf(predicate);
	}
}
