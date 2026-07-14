package com.korea.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.todo.dto.StudentDTO;

@Service
public class StudentService {
	private final List<StudentDTO> students = new ArrayList<>();
	private Long nextId = 1L;
	
	public StudentService() {
		addStudent(new StudentDTO(null, "김철수","스프링부트 개발","kim@test.com"));
		addStudent(new StudentDTO(null, "이영희","리액트 기초","young@test.com"));
	}
	
	public List<StudentDTO> getStudents(){
		return students;
	}
	
	public StudentDTO addStudent(StudentDTO studentDTO) {
		studentDTO.setId(nextId++);
		students.add(studentDTO);
		return studentDTO;
	}
}
