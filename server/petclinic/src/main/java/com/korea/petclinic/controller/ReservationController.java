package com.korea.petclinic.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.korea.petclinic.service.ReservationService;
import com.korea.petclinic.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public List<ReservationVO> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("{id}")
    public ReservationVO findById(@PathVariable Long id) {
        return reservationService.findById(id);
    }

    // 예약 등록 (POST /reservations)
    @PostMapping
    public int insert(@RequestBody ReservationVO vo) {
        return reservationService.insert(vo);
    }

    // 예약 정보 수정 (PUT /reservations/{id})
    @PutMapping("{id}")
    public int update(@PathVariable Long id, @RequestBody ReservationVO vo) {
        vo.setId(id); // URL의 id를 VO 객체에 주입
        return reservationService.update(vo);
    }

    // 예약 삭제 (DELETE /reservations/{id})
    @DeleteMapping("{id}")
    public int delete(@PathVariable Long id) {
        return reservationService.delete(id);
    }

    // 검색 기준 선택 (GET /reservations/search-detail?searchType=pet&keyword=초코)
    @GetMapping("/search-detail")
    public List<ReservationVO> searchDetail(@RequestParam String searchType, 
                                             @RequestParam String keyword) {
        return reservationService.searchDetail(searchType, keyword);
    }

    // 진료비 정렬 (GET /reservations/sort?sort=asc)
    @GetMapping("sort")
    public List<ReservationVO> sortByPrice(@RequestParam(required = false) String sort){
    	return reservationService.sortByPrice(sort);
    }

    // 상태별 예약 수 (GET /reservations/status-count)
    @GetMapping("status-count")
    public List<Map<String, Object>> getStatusCount() {
        return reservationService.getStatusCount();
    }
    
    // 전체 예상 진료비
    // GET / reservation / totla-price
    @GetMapping("total-price")
    public Integer getTotalPrice(){
    	return reservationService.getTotalPrice();
    }
    
    
    
    
    
    
    
    
}