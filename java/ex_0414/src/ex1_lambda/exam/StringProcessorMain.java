package ex1_lambda.exam;

public class StringProcessorMain {
	public static void main(String[] args) {
		
		TextService service = new TextService();
		String text = "This product is currently out of stock.";
		
		// 1. 모든 문자를 대문자로 변환
		String upper = service.processText(text, t -> t.toUpperCase());
		System.out.println(upper); // THIS PRODUCT IS CURRENTLY OUT OF STOCK.
		
		// 2. “out of stock” → “in stock”으로 변환
		String replaced = service.processText(text, t -> t.replace("out of stock", "in stock"));
		System.out.println(replaced); // This product is currently in stock.
		
	}
}
