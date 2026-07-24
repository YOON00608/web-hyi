package com.korea.product.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OrderVO {
    private Integer orderId;
    private Integer productId;
    private Integer productCount;
    private LocalDateTime orderDate;

    // 조인 조회용 (주문 목록 조회 시 포함될 정보)
    private String productName;
    private Integer productPrice;
    private Integer totalPrice; // 총 결제 금액 (productPrice * productCount)
}
