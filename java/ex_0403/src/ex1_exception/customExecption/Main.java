package ex1_exception.customExecption;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Converter2 coverter = new Converter2();
		OrderService os = new OrderService();
		
		try {
			System.out.print("상품 가격 입력 : ");
			String p = sc.nextLine();
			int price = coverter.toInt(p);
			
			System.out.println("수량 입력 : ");
			String q = sc.nextLine();
			int quantity = coverter.toInt(q);
			
			int total = os.calculateTotal(price, quantity);
			
		} catch (NumberFormatException e) {
			System.out.println("오류 : 숫자 형식 오류(숫자만 입력해주세요)");
		} catch (IllegalArgumentException e) {
			System.out.println("오류 : " + e.getMessage());
		} catch(Exception e) {
			System.out.println("알 수 없는 오류");
		}
		
	}

	private static int service(int price, int quantity) {
		return 0;
	}
}
