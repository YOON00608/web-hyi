package com.korea.test.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korea.test.dto.BookDTO;
import com.korea.test.dto.ResponseDTO;
import com.korea.test.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
	private final BookService bookService;
	
	// 1. 도서 등록 (POST /books)
	@PostMapping
	public ResponseEntity<?> createBook(@RequestBody BookDTO dto) {
		BookDTO registeredBook = bookService.create(dto);
		ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
				.data(Collections.singletonList(registeredBook))
				.build();
		return ResponseEntity.ok().body(response);
	}
	
	// 2. 전체 도서 조회 (GET /books)
	@GetMapping
	public ResponseEntity<?> getAllBooks() {
		List<BookDTO> books = bookService.retrieveAll();
		ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
				.data(books)
				.build();
		return ResponseEntity.ok().body(response);
	}
	
	// 3. 도서 ID 조회 (GET /books/{id})
	@GetMapping("/{id}")
	public ResponseEntity<?> getBookById(@PathVariable Long id) throws IllegalAccessException {
		BookDTO book = bookService.retrieveById(id);
		ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
				.data(Collections.singletonList(book))
				.build();
		return ResponseEntity.ok().body(response);
	}
	
	// 4. 제목으로 도서 검색 (GET /books/search/title?q=제목)
	@GetMapping("/search/title")
	public ResponseEntity<?> searchBooksByTitle(@RequestParam("q") String title) {
		List<BookDTO> books = bookService.retrieveByCategory(title);
		ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
				.data(books)
				.build();
		return ResponseEntity.ok().body(response);
	}
	
	// 5. 카테고리별 도서 검색 (GET /books/search/category?q=카테고리)
	@GetMapping("/search/category")
	public ResponseEntity<?> searchBooksByCategory(@RequestParam("q") String category) {
		List<BookDTO> books = bookService.retrieveByCategory(category);
		ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
				.data(books)
				.build();
		return ResponseEntity.ok().body(response);
	}
	
	// 6. 도서 정보 수정 (PUT /books/{id})
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookDTO dto) throws IllegalAccessException {
		BookDTO updatedBook = bookService.update(id, dto);
		ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
				.data(Collections.singletonList(updatedBook))
				.build();
		return ResponseEntity.ok().body(response);
	}
	
	// 7. 도서 삭제 (DELETE /books/{id})
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Long id) throws IllegalAccessException {
		bookService.delete(id);
		ResponseDTO<BookDTO> response = ResponseDTO.<BookDTO>builder()
				.data(Collections.emptyList()) // 성공 시 빈 리스트 반환
				.build();
		return ResponseEntity.ok().body(response);
	}
}