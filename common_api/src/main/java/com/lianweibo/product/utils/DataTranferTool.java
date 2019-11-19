package com.lianweibo.product.utils;

import com.lianweibo.product.entity.ProductInfo;
import com.lianweibo.product.vo.FoodVO;

/**
 * @ClassName DataTranferTool
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/13
 * @Version V1.0
 **/
public class DataTranferTool {
    public static FoodVO transferProductInfo(ProductInfo productInfo) {

        FoodVO foodVO = new FoodVO();
        foodVO.setId(productInfo.getProductId());
        foodVO.setDescription(productInfo.getProductDescription());
        foodVO.setIcon(productInfo.getProductIcon());
        foodVO.setName(productInfo.getProductName());
        foodVO.setPrice(productInfo.getProductPrice());
        return foodVO;
    }
}
