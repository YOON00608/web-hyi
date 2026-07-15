package com.korea.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.todo.dto.ResponseDTO;
import com.korea.todo.dto.StudentDTO;
import com.korea.todo.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController // REST API용 컨트롤러 선언
@RequestMapping("api/students") // 경로 이어주기 
@RequiredArgsConstructor // 생성자 자동 생성
@CrossOrigin(origins = "*") // 다른 도메인의 api호출 차단
public class StudentController {
    private final StudentService studentService; // 의존성 주입(Service 연결)
    
    // 수강생 조회
    @GetMapping
    public ResponseDTO<StudentDTO> getStudents(){
        List<StudentDTO> list = studentService.getStudents(); // 호출해서 메모리에 저장된 학생 목록 받아오기
        return new ResponseDTO<StudentDTO>(null, list); // null은 메시지 넣는 곳, list가 학생 목록 데이터
    }
    
    // GET /api/students 호출 ➡ Controller가 감지  
    // ➡ Service에서 리스트를 꺼내옴 ➡ ResponseDTO에 예쁘게 포장해서 브라우저로 JSON 전달.
    
    // 수강생 등록
    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO) {
    	// @RequestBody : 클라이언트가 HTTP 요청의 Body(본문)에 담아 보낸 데이터를
    	// Java 객체로 변환해서 받기 위한 어노테이션
        return studentService.addStudent(studentDTO); // 변환된 studentDTO 객체를 전달
    }
    
    // POST /api/students로 학생 정보 JSON 전송 ➡ Controller가 @RequestBody로 데이터 수신 
    // ➡ Service에 넘겨서 ID 부여 및 저장 ➡ 처리 완료된 데이터 브라우저로 전달.
}