package com.korea.ex_0723.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.korea.ex_0723.dao.BookDAO;
import com.korea.ex_0723.vo.BookVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    
    private final BookDAO bookDAO;
    
    public List<BookVO>findAll(){
    	return bookDAO.findAll();
    }
    
    public BookVO findBook(Long id){
        return bookDAO.findBook(id);
    }
    
    public int insertBook(BookVO vo) {
    	return bookDAO.insertBook(vo);
    }
    
    public int updateBook(BookVO bookVO) {
        return bookDAO.updateBook(bookVO);
    }

    public int deleteBook(int id) {
        return bookDAO.deleteBook(id);
    }

    public List<BookVO> findByCategory(String category) {
        return bookDAO.findByCategory(category);
    }
    
    public List<BookVO> searchByTitle(String title){
    	return bookDAO.searchByTitle(title);
    }
    

    public List<BookVO> findByPriceMin(int min) {
        return bookDAO.findByPriceMin(min);
    }

	public int count() {
		return bookDAO.count();
	}
	
	public List<BookVO> findAllOrder(String sort){
		return bookDAO.findAllOrder(sort);
	}
}