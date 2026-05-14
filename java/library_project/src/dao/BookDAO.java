package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import db.DBUtil;
import dto.BookDTO;

public class BookDAO {
	// book 테이블에 도서 정보를 등록하는 기능 구현하기
	// insertBook(BookDTO dto)

	public void insertBook(BookDTO dto) {

		String sql = "INSERT INTO book (title, author, stock) VALUES (?, ?, ?)";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getAuthor());
			pstmt.setInt(3, dto.getStock());

			int result = pstmt.executeUpdate();
			if (result > 0)
				System.out.println("도서 등록 완료");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 전체 도서 조회 기능 만들기
	// findAllBooks()
	// 출력 예시: 번호 : 1 제목 : 자바의 정석 저자 : 남궁성 재고 : 5

	public void findAllBooks() {

		String sql = "SELECT * FROM book";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				int bookid = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int stock = rs.getInt("stock");

				System.out.println("번호 : " + bookid);
				System.out.println("제목 : " + title);
				System.out.println("저자 : " + author);
				System.out.println("재고 : " + stock);
				System.out.println("-------------------");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findLowStockBooks() {
		//재고가 2권 이하인 도서를 조회
		String sql = "SELECT * FROM book WHERE stock <= 2";

		try (	Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				int bookid = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int stock = rs.getInt("stock");

				System.out.println("번호 : " + bookid);
				System.out.println("제목 : " + title);
				System.out.println("저자 : " + author);
				System.out.println("남은 재고 : " + stock);
				System.out.println("-------------------");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
