package com.korea.ex_0723.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.korea.ex_0723.vo.BookVO;

@Mapper
public interface BookDAO {
	List<BookVO> findAll();
	
	BookVO findBook(Long id);
	
	int insertBook(BookVO vo);
	
	int updateBook(BookVO bookVO);

    int deleteBook(int id);

    List<BookVO> findByCategory(String category);
    
    List<BookVO> searchByTitle(String title);

    List<BookVO> findByPriceMin(int minPrice);
    
    int count();
    
    List<BookVO> findAllOrder(@Param("sort")String sort);
    
    
}