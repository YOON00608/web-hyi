package com.korea.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor	// 기본생성자 생성
// 기본생성자가 필요한 이유는 객체를 먼저 만들고 값을 나중에 넣으려고
@AllArgsConstructor
@Data	// getter, setter 등등 여러가지 메서드가 통합된 어노테이션

//Entity : DB테이블과 연결되는 객체
@Entity // 현재 클래스를 JAP가 관리하는 엔티티 클래스로 지정
@Table(name="Todo") // 이 엔티티가 사용할 테이블 이름을 Todo로 지정한다.
public class TodoEntity {
	@Id // 현재 필드를 엔티티의 기본키(PK)로 지정한다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 숫자를 1부터 만들어준다.
	private Long id;		// 이 객체의 아이디
	// @Column(nullable = false) // null이면 안 된다.
	private String userId;	// 이 객체를 생성한 유저의 아이디
	private String title;	// 할일
	private boolean done;	// 완료 여부
	
	
}
