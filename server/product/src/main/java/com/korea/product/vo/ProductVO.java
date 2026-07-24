package com.korea.product.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProductVO {
    private Integer productId;
    private String productName;
    private Integer productStock;
    private Integer productPrice;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
}
