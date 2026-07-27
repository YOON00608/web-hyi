package com.korea.movie_reservation.dao;

import org.apache.ibatis.annotations.Mapper;

import com.korea.movie_reservation.vo.MovieVO;

@Mapper
public interface MovieMapper {
	int insertMovie(MovieVO movie);
	MovieVO findMivieById(Long movieId);
}
