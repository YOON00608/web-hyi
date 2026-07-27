package com.korea.movie_reservation.service;

import org.springframework.stereotype.Service;

import com.korea.movie_reservation.dao.MovieMapper;
import com.korea.movie_reservation.vo.MovieVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
	
	private final MovieMapper moviemapper;

	public int insertMovie(MovieVO movie) {
        return moviemapper.insertMovie(movie);
    }

    public MovieVO findMovieById(Long movieId) {
        return moviemapper.findMivieById(movieId);
    }
	
}
