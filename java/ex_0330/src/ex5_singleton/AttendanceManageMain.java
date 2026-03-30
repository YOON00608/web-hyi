package ex5_singleton;

import java.util.Calendar;

public class AttendanceManageMain {
	public static void main(String[] args) {
		
		AttendanceManage a1 = AttendanceManage.getInstance();
		AttendanceManage a2 = AttendanceManage.getInstance();
		
		a1.addAttendance();
		a2.addAttendance();
		
		System.out.println(a1.getAttendance()); // 2
		System.out.println(a2.getAttendance()); // 2 
		
		// 싱글톤 패턴을 사용하는 이유 : 
		// new 생성자(); 를 통해서 객체를 여러개 만들게 되면 메모리를 많이 사용한다.
		// 
		// 1. 공유 자원을 효율적으로 관리하고, 구조를 안정적으로 유지하기 위해서이다.
		// 2. 어디서든지 같은 객체를 가져올 수 있다.
		// 3. 데이터를 일관성 있게 유지할 수 있다.
		// 
		// 실무에서 많이 쓰는 대표적인 사례
		// 1. DB연결 관리자
		// 2. 로그 시스템 -> 하나의 객체로 기록
		// 3. 설정(Config) -> 모든 곳에서 동일한 값을 가진다.
		
		
	}
}
