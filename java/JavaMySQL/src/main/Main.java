package main;

import dao.MemberDAO;
import dto.MemberDTO;

public class Main {
	public static void main(String[] args) {

		MemberDAO dao = new MemberDAO();

		// member 테이블의 모든 내용 조회하기
		dao.findAll();

		// 추가하기
		MemberDTO newMember = new MemberDTO(4, "최유리", "Choi@naver.com", 22);
		dao.insertMember(newMember);

		// 수정하기
		MemberDTO updateMember = new MemberDTO(1, "이몽룡", "Mong@naver.com", 30);
		dao.updateMember(updateMember);

		// 삭제하기
		dao.deleteMember(4);

	}
}
