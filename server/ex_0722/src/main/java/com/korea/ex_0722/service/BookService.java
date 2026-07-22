package com.korea.ex_0722.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.korea.ex_0722.dao.BookDAO;
import com.korea.ex_0722.vo.BookVO;
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
}