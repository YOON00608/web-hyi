package main;

import java.util.Scanner;
import dao.BookDAO;
import dao.CustomerDAO;
import dao.RentalDAO;
import dto.BookDTO;
import dto.CustomerDTO;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		CustomerDAO customerDAO = new CustomerDAO();
		BookDAO bookDAO = new BookDAO();
		RentalDAO rentalDAO = new RentalDAO();

		while (true) {
			System.out.println("도서 대여 관리 프로그램");
			System.out.println("1. 고객 등록");
			System.out.println("2. 도서 등록");
			System.out.println("3. 도서 전체 조회");
			System.out.println("4. 도서 대여");
			System.out.println("5. 전체 대여 목록 조회");
			System.out.println("6. 고객별 대여 목록 조회");
			System.out.println("7. 재고 부족 도서 조회");
			System.out.println("0. 종료");

			System.out.println("메뉴 선택 : ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				sc.nextLine();
				// 고객 정보를 입력받아서 customer 테이블에 등록하기
				System.out.print("고객 이름 : ");
				String Name = sc.nextLine();
				
				System.out.print("전화 번호 : ");
				String Phone = sc.nextLine();
				
				customerDAO.insertCustomer(new CustomerDTO(Name, Phone));
				break;

			case 2:
				sc.nextLine();
				// 도서 정보(제목,저자,개수)를 입력 받아서 book테이블에 저장하기
				System.out.print("도서 제목 : ");
				String title = sc.nextLine();
				
				System.out.print("저자 이름 : ");
				String author = sc.nextLine();
				
				System.out.print("수량 : ");
				int stock = sc.nextInt();
				
				sc.nextLine();
				
				bookDAO.insertBook(new BookDTO(title, author, stock));
				break;

			case 3:
				// 도서 전체 조회하기
				bookDAO.findAllBooks();
				break;

			case 4:
				System.out.print("고객 번호(ID) : ");
				int customerID = sc.nextInt();
				
				System.out.print("도서 번호(ID) : ");
				int bookID = sc.nextInt();
				
				rentalDAO.rentalBook(customerID, bookID);
				break;

			case 5:
				// 전체 대여 목록
				rentalDAO.findRrntalList();
				break;
				
			case 6:
				// 고객별 대여 목록 조회
				// 고객 id를 입력받아서 고객명, 제목, 빌린 날짜 순으로 출력하기
				System.out.print("고객 번호 : ");
				int serchCustomerId = sc.nextInt();
				
				rentalDAO.findRentalListByCustomer(serchCustomerId);
				break;
				
			case 7:
				// 재고부족 도서 조회
				// 재고가 2권 이하인 도서를 조회
				// findLowStockBooks
				bookDAO.findLowStockBooks();
				break;

			case 0:
				// 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}

// 박민수 010-3333-3333 회원 추가하기
//		CustomerDAO customerDAO = new CustomerDAO();
//		customerDAO.insertCustomer(new CustomerDTO("박민수","010-3333-3333"));

// 도서 등록
//		BookDAO bookDAO = new BookDAO();
//		bookDAO.insertBook(new BookDTO("이것이 자바다","신용권",6));

//		bookDAO.findAllBooks();

//		RentalDAO rentalDAO = new RentalDAO();
//		rentalDAO.rentalBook(1, 2);

//		rentalDAO.findRrntalList();