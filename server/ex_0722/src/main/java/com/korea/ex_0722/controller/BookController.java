package com.korea.ex_0722.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.ex_0722.service.BookService;
import com.korea.ex_0722.vo.BookVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
	private final BookService bookService;
	
	@GetMapping
	public List<BookVO> findAll(){
		return bookService.findAll();
	}
	
	@GetMapping("{id}")
	public BookVO findBook(@PathVariable Long id) {
		return bookService.findBook(id);
	}
}
