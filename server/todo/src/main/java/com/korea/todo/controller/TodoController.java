package com.korea.todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    private final TodoService todoService;

    // 인증 테스트용 엔드포인트
    @GetMapping("/test")
    public ResponseEntity<?> testTodo() {
        String str = todoService.testService();
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = 
                ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }

    // 1. Todo 생성 (로그인한 유저의 userId 적용)
    @PostMapping
    public ResponseEntity<?> createTodo(
            @AuthenticationPrincipal String userId, 
            @RequestBody TodoDTO dto) {
        try {
            // 1. DTO -> Entity 변환
            TodoEntity entity = TodoDTO.toEntity(dto);
            
            // 2. SecurityContext에서 추출한 실제 로그인 사용자 ID 설정
            entity.setUserId(userId);

            // 3. 서비스 호출 및 DB 저장
            List<TodoEntity> entities = todoService.create(entity);

            // 4. Entity List -> DTO List 변환
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

    // 2. 전체 조회 (로그인한 유저의 Todo만 조회)
    @GetMapping
    public ResponseEntity<?> retrieveTodoList(@AuthenticationPrincipal String userId) {
        // 인증된 사용자 ID로 목록 조회
        List<TodoEntity> entities = todoService.retrieve(userId);

        List<TodoDTO> dtos = entities.stream()
                .map(TodoDTO::new)
                .toList();

        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder()
                .data(dtos)
                .build();

        return ResponseEntity.ok().body(response);
    }

    // 3. 수정 (로그인한 유저 본인의 Todo만 수정)
    @PutMapping
    public ResponseEntity<?> updateTodo(
            @AuthenticationPrincipal String userId, 
            @RequestBody TodoDTO dto) {
        try {
            TodoEntity entity = TodoDTO.toEntity(dto);
            entity.setUserId(userId);

            List<TodoEntity> entities = todoService.update(entity);

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

    // 4. 삭제 (로그인한 유저 본인의 Todo만 삭제)
    @DeleteMapping
    public ResponseEntity<?> deleteTodo(
            @AuthenticationPrincipal String userId, 
            @RequestBody TodoDTO dto) {
        try {
            TodoEntity entity = TodoDTO.toEntity(dto);
            entity.setUserId(userId);

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