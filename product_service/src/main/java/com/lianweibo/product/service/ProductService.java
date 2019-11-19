package com.lianweibo.product.service;

import com.lianweibo.product.entity.ProductInfo;
import com.lianweibo.product.vo.BuyerProductInfoVO;
import com.lianweibo.product.vo.ProductVO;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProductService
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/14
 * @Version V1.0
 **/
public interface ProductService {

    List<BuyerProductInfoVO> selectAllProducts();

    Page<ProductInfo> selectSellerProducts(ProductVO productVO);

    void deleteByIds(ArrayList<ProductInfo> ids);

    void deleteById(String productId);
}
