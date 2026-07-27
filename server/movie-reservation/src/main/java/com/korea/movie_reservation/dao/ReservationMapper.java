package com.korea.movie_reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.movie_reservation.vo.ReservationVO;

@Mapper
public interface ReservationMapper {
	int insertReservation(ReservationVO reservation);
	int updateReservation(ReservationVO reservation);
	List <ReservationVO> findReservationDetails();
}
