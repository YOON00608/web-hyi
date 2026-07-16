package com.korea.test.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.korea.test.dto.BookDTO;
import com.korea.test.entity.BookEntity;
import com.korea.test.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {
	private final BookRepository bookRepository;
	
	// 1. 도서 등록
	@Transactional
	public BookDTO create(final BookDTO dto) {
		
		BookEntity entity = BookEntity.builder()
				.title(dto.getTitle())
				.author(dto.getAuthor())
				.category(dto.getCategory())
				.price(dto.getPrice())
				.stock(dto.getStock())
				.build();
		
		BookEntity savedEntity = bookRepository.save(entity);
		return new BookDTO(savedEntity);
	} 
	
	// 2. 전체 도서 조회
	public List<BookDTO> retrieveAll(){
		return bookRepository.findAll().stream()
				.map(BookDTO::new)
				.collect(Collectors.toList());
	}
	
	// 3. 도서 ID 조회
	public BookDTO retrieveById(final Long id) throws IllegalAccessException {
		BookEntity entity = bookRepository.findById(id)
				.orElseThrow(() -> new IllegalAccessException("존재하지 않는 ID"));
		return new BookDTO(entity);
	}
	
	// 4. 제목으로 도서 검색
	public List<BookDTO> retrieveTitle(final String title){
		return bookRepository.findByTitle(title).stream()
				.map(BookDTO::new)
				.collect(Collectors.toList());
	}
	
	// 5. 카테고리별 도서 검색
	public List<BookDTO> retrieveByCategory(final String category){
		return bookRepository.findByCategory(category).stream()
				.map(BookDTO::new)
				.collect(Collectors.toList());
	}
	
	// 6. 도서 정보 수정
	@Transactional
	public BookDTO update(final Long id, final BookDTO dto) throws IllegalAccessException {
		BookEntity entity = bookRepository.findById(id)
				.orElseThrow(() -> new IllegalAccessException("수정할 도서가 없습니다."));
		entity.setTitle(dto.getTitle());
		entity.setAuthor(dto.getAuthor());
		entity.setCategory(dto.getCategory());
		entity.setPrice(dto.getPrice());
		entity.setStock(dto.getStock());
		
		return new BookDTO(entity);
	}
	
	// 도서 삭제
	@Transactional
	public void delete(final Long id) throws IllegalAccessException {
		BookEntity entity = bookRepository.findById(id)
				.orElseThrow(() -> new IllegalAccessException("삭제할 도서가 없습니다."));
		bookRepository.delete(entity);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}