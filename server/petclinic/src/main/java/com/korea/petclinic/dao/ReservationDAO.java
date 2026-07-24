package com.korea.petclinic.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.korea.petclinic.vo.ReservationVO;

@Mapper
public interface ReservationDAO {

    List<ReservationVO> findAll();

    ReservationVO findById(Long id);

    int insert(ReservationVO vo);

    int update(ReservationVO vo);

    int delete(Long id);

    List<ReservationVO> searchDetail(@Param("searchType") String searchType, @Param("keyword") String keyword);

    List<ReservationVO> sortByPrice(@Param("sort") String sort);
    
    List<Map<String, Object>> getStatusCount();

	List<ReservationVO> totalPrice();

	Integer getTotalPrice();
}