package com.korea.product.service;

import com.korea.product.dao.OrderDAO;
import com.korea.product.dao.ProductDAO;
import com.korea.product.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDAO productDAO;
    private final OrderDAO orderDAO;

    // 전체 상품 조회
    public List<ProductVO> getAllProducts() {
        return productDAO.selectAllProducts();
    }
    
    // 상품 등록
    public int registerProduct(ProductVO product) {
    	return productDAO.insertProduct(product);
    }

    // 상품 상세 조회
    public ProductVO getProductById(Integer productId) {
    	return productDAO.selectProductById(productId);
    }

}