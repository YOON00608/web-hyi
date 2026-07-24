package com.korea.product.dao;

import com.korea.product.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ProductDAO {
    List<ProductVO> selectAllProducts();
    
    int insertProduct(ProductVO product);
    
    ProductVO selectProductById(Integer productId);
	
}