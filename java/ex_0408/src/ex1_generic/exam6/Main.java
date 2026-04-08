package ex1_generic.exam6;

public class Main {
	public static void main(String[] args) {
		
		ApiResponse<Product> api =
				new ApiResponse<>(200,new Product("아이폰 15",1250000 ));
		
		System.out.println("상태 코드 : " + api.getStatusCode());
		System.out.println("상품명 : " + api.getBody().getProductName());
		System.out.println("가격 : " + api.getBody().getPrice());
	}
}
