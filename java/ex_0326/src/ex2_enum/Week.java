package ex2_enum;

// 열거형 : 정해진 값들만 선택해서 사용할 수 있도록 만든 특별한 자료형
// 요일(월~일), 계절(봄,여름,가을,겨울), 주문상태(완료,배송중,배송완료,취소)
// 정해진 값을 외에는 아무 문자열이나 들어가서는 안 된다.

// 왜 필요한가?
// 문자열로 상태를 관리하는 경우
public enum Week {
	MONDAY,
	THESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY
}
