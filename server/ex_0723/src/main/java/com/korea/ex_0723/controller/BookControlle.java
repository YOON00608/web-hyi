package com.korea.ex_0723.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korea.ex_0723.service.BookService;
import com.korea.ex_0723.vo.BookVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookControlle {
	private final BookService bookService;
	
	@GetMapping
	public List<BookVO> findAll(){
		return bookService.findAll();
	}
	
	@GetMapping("{id}")
	public BookVO findBook(@PathVariable Long id) {
		return bookService.findBook(id);
	}
	
	@PostMapping
	public int insertBook(@RequestBody BookVO vo) {
		return bookService.insertBook(vo);
	}
	
	@PutMapping("/{id}")
    public int updateBook(@PathVariable Long id, @RequestBody BookVO bookVO) {
        bookVO.setId(id);
        return bookService.updateBook(bookVO);
    }

    @DeleteMapping("/{id}")
    public int deleteBook(@PathVariable("id") int id) {
        return bookService.deleteBook(id);
    }

    @GetMapping("/category")
    public List<BookVO> findByCategory(@RequestParam String name) {
        return bookService.findByCategory(name);
    }

    @GetMapping("/search")
    public List<BookVO> searchByTitle(@RequestParam String title) {
        return bookService.searchByTitle(title);
    }

    @GetMapping("/price")
    public List<BookVO> findByPriceMin(@RequestParam int min) {
        return bookService.findByPriceMin(min);
    }
}
