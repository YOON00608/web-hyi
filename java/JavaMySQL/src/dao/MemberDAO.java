package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBUtil;
import dto.MemberDTO;

//DAO(Data Access Object)
//실제로 DB에 접근하는 클래스
public class MemberDAO {

	List<MemberDTO> list = new ArrayList<>();

	// 조회
	public void findAll() {
		// member테이블에서 데이터를 조회한 후 memberDTO 객체에 담은 후
		// 콘솔에 출력하는 코드 작성하기
		String sql = "select * from member";

		try (Connection conn = DBUtil.getConnection();

				PreparedStatement pstmt = conn.prepareStatement(sql);

				ResultSet rs = pstmt.executeQuery();) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				int age = rs.getInt("age");

				list.add(new MemberDTO(id, name, email, age));

			}

			list.forEach(x -> {
				System.out.println("ID : " + x.getId());
				System.out.println("이름 : " + x.getName());
				System.out.println("이메일 : " + x.getEmail());
				System.out.println("나이 : " + x.getAge());
				System.out.println("------------------");
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 추가
	public void insertMember(MemberDTO dto) {
		// 매개변수를 통해 넘겨받은 dto를 member 테이블에 추가하기

		String sql = "INSERT INTO member(name, email, age) VALUES(?, ?, ?)";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setInt(3, dto.getAge());

			int result = pstmt.executeUpdate();
			if (result > 0)
				System.out.println("회원 등록 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 수정
	// 특정 사람의 나이를 수정하는 메서드 작성하기
	public void updateMember(MemberDTO dto) {

		String sql = "UPDATE member SET name = ?, email = ?, age = ? WHERE id = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setInt(3, dto.getAge());
			pstmt.setInt(4, dto.getId());

			int result = pstmt.executeUpdate();
			if (result > 0)
				System.out.println(dto.getId() + "번 회원 정보 수정");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 삭제
	public void deleteMember(int id) {
		String sql = "DELETE FROM member WHERE id = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);

			int result = pstmt.executeUpdate();
			if (result > 0)
				System.out.println(id + "번 회원 삭제");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
