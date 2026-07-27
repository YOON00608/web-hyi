package com.korea.movie_reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.movie_reservation.dao.ReservationMapper;
import com.korea.movie_reservation.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {
	
	private final ReservationMapper reservationmapper;
	
	public int insertReservation(ReservationVO reservation) {
        return reservationmapper.insertReservation(reservation);
    }

    public int updateReservation(ReservationVO reservation) {
        return reservationmapper.updateReservation(reservation);
    }

    public List<ReservationVO> findReservationDetails() {
        return reservationmapper.findReservationDetails();
    }
	
}
