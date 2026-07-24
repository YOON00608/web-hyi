package com.korea.product.controller;

import com.korea.product.service.ProductService;
import com.korea.product.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

 // 1. 모든 상품 조회하기 (GET /product)
    @GetMapping
    public List<ProductVO> findAll() {
        return productService.getAllProducts();
    }

    // 2. 상품 등록 (POST /product)
    @PostMapping
    public int createProduct(@RequestBody ProductVO product) {
        return productService.registerProduct(product);
    }

    // 3. 상품 상세 조회 (GET /product/{productId})
    @GetMapping("{productId}")
    public ProductVO findById(@PathVariable Integer productId) {
        return productService.getProductById(productId);
    }

}