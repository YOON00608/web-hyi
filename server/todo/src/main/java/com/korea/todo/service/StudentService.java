package com.korea.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.todo.dto.StudentDTO;

@Service
public class StudentService {
	private final List<StudentDTO> students = new ArrayList<>(); // 데이터 저장
	private Long nextId = 1L; // ID 관리
	
	public StudentService() {
		addStudent(new StudentDTO(null,"김철수","스프링부트 개발","kim@test.com"));
		addStudent(new StudentDTO(null,"이영희","리액트 기초","young@test.com"));
	} // 생성자, 초기 데이터 세팅
	
	// 전체 학생 목록 조회
	public List<StudentDTO> getStudents(){
		return students;
	}
	
	// 새로운 학생 추가 (ID 자동 부여)
	public StudentDTO addStudent(StudentDTO studentDTO) {
		studentDTO.setId(nextId++); // ID 부여
		students.add(studentDTO); // 실제로 리스트에 추가하는 코드
		return studentDTO;
	}
}
