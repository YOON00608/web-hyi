package com.korea.ex_0722.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.ex_0722.vo.BookVO;

@Mapper
public interface BookDAO {
	List<BookVO> findAll();
	
	BookVO findBook(Long id);
	
	int insertBook(BookVO vo);
	
	
}