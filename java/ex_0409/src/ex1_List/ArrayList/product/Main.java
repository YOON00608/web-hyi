package ex1_List.ArrayList.product;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Cart cart = new Cart();
		
		while (true) {
            System.out.println("\n===== 장바구니 메뉴 =====");
            System.out.println("1. 상품 추가");
            System.out.println("2. 장바구니 보기");
            System.out.println("3. 총 금액 보기");
            System.out.println("4. 상품 삭제");
            System.out.println("0. 종료");
            System.out.print("선택 >> ");

            int choice = sc.nextInt();
            sc.nextLine(); // 버퍼 제거
            
            
            // 1. 상품 추가
            if(choice == 1) {
            	System.out.print("상품명 : ");
            	String name = sc.nextLine();
            	
            	System.out.print("가격 : ");       
            	int price = sc.nextInt();
            	
            	System.out.print("수량 : ");
            	int quantity = sc.nextInt();
            	
            	cart.addProduct(name, price, quantity);
            	
            // 2. 장바구니 보기
            }else if(choice == 2) {
            	System.out.println("--- 장바구니 목록 ---");
            	cart.printCart();
            	
            // 3. 총 금액 보기
            }else if(choice == 3){
            	System.out.println("--- 총 금액 --- ");
            	cart.printTotalPrice();
            // 4. 상품 삭제
            }else if(choice == 4) {
            	System.out.print("삭제할 상품명 입력");
            	String name = sc.nextLine();
            	cart.removeProduct(name);
            	
            // 0. 프로그램 종료
            }else if(choice == 0) {
            	System.out.println("프로그램을 종료합니다.");
            	break;
            	
            // 그 외의 숫자 입력 시
            }else {
            	System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
            }
            
		
            
            
            
            
            
            
		}
	}
}
