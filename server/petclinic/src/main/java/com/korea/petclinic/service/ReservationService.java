package com.korea.petclinic.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.korea.petclinic.dao.ReservationDAO;
import com.korea.petclinic.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationDAO reservationDAO;

    public List<ReservationVO> findAll() {
        return reservationDAO.findAll();
    }

    public ReservationVO findById(Long id) {
        return reservationDAO.findById(id);
    }

    // 예약 등록 (영향받은 행의 수 반환)
    public int insert(ReservationVO reservation) {
        return reservationDAO.insert(reservation);
    }

    // 예약 정보 수정
    public int update(ReservationVO reservation) {
        return reservationDAO.update(reservation);
    }

    // 예약 삭제
    public int delete(Long id) {
        return reservationDAO.delete(id);
    }

    // 검색 기준 선택
    public List<ReservationVO> searchDetail(String searchType, String keyword) {
        return reservationDAO.searchDetail(searchType, keyword);
    }

    // 진료비 정렬
    public List<ReservationVO> sortByPrice(String sort) {
        return reservationDAO.sortByPrice(sort);
    }

    // 예약 상태별 예약 수 조회
    public List<Map<String, Object>> getStatusCount() {
        return reservationDAO.getStatusCount();
    }
}