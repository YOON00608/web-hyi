package com.korea.todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.todo.dto.ResponseDTO;
import com.korea.todo.dto.TodoDTO;
import com.korea.todo.entity.TodoEntity;
import com.korea.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("todo")
@RequiredArgsConstructor
public class TodoController {
	// TodoService를 필드를 갖고 객체를 생성자 주입을 한다.
	private final TodoService todoService;
	
	// /test로 요청이 들어오면 testTodo라는 메서드가 실행되고,
	// 서비스의 메서드를 실행하여 응답으로 반환한다.
	// ResponseEntity : HTTP 응답 전체를 표현하는 객체
	@GetMapping("/test")
	public ResponseEntity<?> testTodo() {
		String str = todoService.testService();
		List<String> list = new ArrayList<>();
		list.add(str);
		ResponseDTO<String> response = 
				ResponseDTO.<String>builder().data(list).build();
		// ok() -> 상태를 강제로 200으로 설정한다.
		// body() -> 응답 본문에 response 객체를 넣는다.
		// 완성된 HTTP 응답을 클라이언트에게 전송한다.
		return ResponseEntity.ok().body(response);
		
		// Controller -> Service -> ResponseDTO -> ResponseEntity -> JSON
	}
	
	// 요청 -> (DTO -> Entity) TodoController -> TodoService
	// 추가하기 위해 데이터가 넘어왔다.
	// 매개 변수로 받는다. -> 엔티티로 변경하고 service로 보낸다.
	// 비즈니스 로직을 실행하고 난 결과를 받아온다. -> 응답으로 내보낸다.
	@PostMapping
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto){
		try {
			String temporaryUserId = "temporary-user"; // 임시 유저 아이디
			
			// 1. DTO -> Entity 변환
			TodoEntity entity = TodoDTO.toEntity(dto);
			entity.setUserId(temporaryUserId);
			
			// 2. 서비스레이어의 create 메서드를 호출, TodoEntity를 데이터베이스 저장
			List<TodoEntity> entities = todoService.create(entity);
			
			// 3. 자바 스트림을 이용해 Entity List -> DTO List 변환
			List<TodoDTO> dtos = entities.stream()
					.map(TodoDTO::new)
					.toList();
			
			// 4. 변환된 TodoDTO를 이용해 ResponseDTO의 data에 리스트를 넣는다.
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder()
					.data(dtos)
					.build();
			
			// 5. 성공 응답 반환
			return ResponseEntity.ok().body(response);
			
		} catch (Exception e) {
			
			// 예외가 발생하는 경우 dto 대신 error에 메시지를 넣어 반환한다.
			String error = e.getMessage();
			
			// 에러 메시지를 포함한 ResponseDTO 객체 만들기
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder()
								.error(error)
								.build();
						
			// badRequest() : 400 Bad Request 상태코드를 가진 응답을 반환한다.
			// 이는 클라이언트가 잘못 요청 했음을 나타낸다.
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	// 전체조회 기능
	@GetMapping
	public ResponseEntity<?> retrieveTodoList() { 
	    String temporaryUserId = "temporary-user";
	    
	    // 1. 서비스에서 Entity 리스트 가져오기
	    List<TodoEntity> entities = todoService.retrieve(temporaryUserId);
	    
	    // 2. Entity 리스트를 DTO 리스트로 변환
	    List<TodoDTO> dtos = entities.stream()
	            .map(TodoDTO::new)
	            .toList();
	    
	    // 3. ResponseDTO 생성
	    ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder()
	            .data(dtos)
	            .build();
	    
	    // 4. HTTP Status 200(OK)으로 응답
	    return ResponseEntity.ok().body(response);
	}
	
	
	// 할일 수정하기
	@PutMapping
	public ResponseEntity<?> updateTodo(@RequestBody TodoDTO dto) {
	    String temporaryUserId = "temporary-user";
	    
	    // 1. DTO를 Entity로 변환 및 유저 ID 설정
	    TodoEntity entity = TodoDTO.toEntity(dto);
	    entity.setUserId(temporaryUserId);
	    
	    // 2. 서비스 레이어 호출 (List<TodoEntity> 반환)
	    List<TodoEntity> entities = todoService.update(entity);
	    
	    // 3. 반환받은 Entity 리스트를 DTO 리스트로 변환
	    List<TodoDTO> dtos = entities.stream()
	            .map(TodoDTO::new)
	            .toList();
	            
	    // 4. ResponseDTO에 DTO 리스트 담기
	    ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder()
	            .data(dtos)
	            .build();
	            
	    return ResponseEntity.ok().body(response);
	}
	
	// 삭제하기
	@DeleteMapping
	public ResponseEntity<?> deleteTodo(@RequestBody TodoDTO dto) {
	    try {
	        String temporaryUserId = "temporary-user";
	        
	        TodoEntity entity = TodoDTO.toEntity(dto);
	        entity.setUserId(temporaryUserId);
	        
	        List<TodoEntity> entities = todoService.delete(entity);
	        
	        List<TodoDTO> dtos = entities.stream()
	                .map(TodoDTO::new)
	                .toList();
	                
	        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder()
	                .data(dtos)
	                .build();
	                
	        return ResponseEntity.ok().body(response);
	        
	    } catch (Exception e) {
	        
	        String error = e.getMessage();
	        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder()
	                .error(error)
	                .build();
	                
	        return ResponseEntity.badRequest().body(response);
	    }
	}
	
}













