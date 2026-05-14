package dao;

import db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RentalDAO {
	// 고객이 도서를 대여하면 다음의 작업을 처리한다.
	// 도서 재고를 조회
	// rental 테이블에 대여 정보를 추가
	// book 테이블의 재고를 1감소
	// rentalBook(int custmerid, int bookid)
	// conn.setAutoCommit(false);
	// conn.rollback(); 롤백
	// conn.commit(); 커밋

	public void rentalBook(int customerId, int bookId) {
		String stockSQL = "SELECT stock FROM book WHERE book_id = ?";
		String insertRentalSQL = "INSERT INTO rental (customer_id, book_id, rental_date) VALUES (?, ?, NOW())";
		String updateBookSQL = "UPDATE book SET stock = stock - 1 WHERE book_id = ?";

		// 1. try(...) 괄호 안에 리소스를 선언하면 자동으로 close() 호출됨
		try (Connection conn = DBUtil.getConnection()) {

			// 트랜잭션 수동 제어 설정
			conn.setAutoCommit(false);

			try {
				// 2. 재고 확인
				int currentStock = 0;
				try (PreparedStatement pstmt = conn.prepareStatement(stockSQL)) {
					pstmt.setInt(1, bookId);
					try (ResultSet rs = pstmt.executeQuery()) {
						if (rs.next()) {
							currentStock = rs.getInt("stock");
						} else {
							System.out.println("해당 도서가 존재하지 않습니다.");
							return;
						}
					}
				}

				// 3. 재고가 있을 경우 대여 처리
				if (currentStock > 0) {
					// 대여 정보 추가
					try (PreparedStatement pstmt = conn.prepareStatement(insertRentalSQL)) {
						pstmt.setInt(1, customerId);
						pstmt.setInt(2, bookId);
						pstmt.executeUpdate();
					}

					// 재고 감소
					try (PreparedStatement pstmt = conn.prepareStatement(updateBookSQL)) {
						pstmt.setInt(1, bookId);
						pstmt.executeUpdate();
					}

					// 모든 작업 성공 시 커밋
					conn.commit();
					System.out.println("도서 대여 완료");
				} else {
					System.out.println("재고가 부족합니다.");
				}

			} catch (SQLException e) {
				// 내부 작업 중 오류 발생 시 롤백
				conn.rollback();
				System.err.println("작업 중 오류 발생으로 롤백되었습니다.");
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 전체 대여 목록 JOIN으로 조회
	// 대여번호, 고객명, 도서명, 대여일을 조회하세요.
	// findRrntalList()
	public void findRrntalList() {
		String sql = "SELECT r.rental_id, c.name, b.title, r.rental_date " + "FROM rental r "
				+ "JOIN customer c ON r.customer_id = c.customer_id " + "JOIN book b ON r.book_id = b.book_id ";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			boolean hasResult = false;
			while (rs.next()) {
				hasResult = true;

				System.out.println("대여번호 : " + rs.getInt("rental_id"));
				System.out.println("고객명 : " + rs.getString("name"));
				System.out.println("도서명 : " + rs.getString("title"));
				System.out.println("대여일 : " + rs.getString("rental_date"));
				System.out.println("-------------------");
			}

			if (!hasResult) {
				System.out.println("대여 기록이 없습니다.");
			}

		} catch (Exception e) {
			System.err.println("대여 목록 조회 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
	}

	public void findRentalListByCustomer(int customerId) {
		
		String sql = "SELECT c.name, b.title, r.rental_date " + 
					 "FROM rental r " +
					 "JOIN customer c ON r.customer_id = c.customer_id " +
					 "JOIN book b ON r.book_id = b.book_id " +
					 "WHERE r.customer_id = ?";

		try (Connection conn = DBUtil.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, customerId);

			try (ResultSet rs = pstmt.executeQuery()) {

				boolean hasResult = false;
				
				while (rs.next()) {
					hasResult = true;
					System.out.println("고객명 : " + rs.getString("name"));
					System.out.println("제목 : " + rs.getString("title"));
					System.out.println("빌린 날짜 : " + rs.getString("rental_date"));
					System.out.println("---------------------------");
				}
				
				if(!hasResult) {
					System.out.println("대여 내력이 없습니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}