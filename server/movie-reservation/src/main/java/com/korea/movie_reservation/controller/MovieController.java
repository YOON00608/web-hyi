package com.korea.movie_reservation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.movie_reservation.service.MovieService;
import com.korea.movie_reservation.vo.MovieVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
	
	private final MovieService movieService;
	
	// 1. 영화 등록
	@PostMapping
	public String insertMovie(@RequestBody MovieVO movie){
	int result = movieService.insertMovie(movie);
	if(result == 1) {
		return "영화 등록 성공 ";
	}else {
		return "영화 등록 실패";
		}
	}
	
	// 2. 영화 단건 조회
	@GetMapping("{movieId}")
	public MovieVO findMovieById(@PathVariable Long movueId) {
		return movieService.findMovieById(movueId);
	}

	
}
