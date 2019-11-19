package com.lianweibo.product.controller;

import com.lianweibo.product.vo.BuyerProductInfoVO;
import com.lianweibo.product.vo.CodeMsg;
import com.lianweibo.product.vo.ResponseVO;
import com.lianweibo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ProductController
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/14
 * @Version V1.0
 **/
@RestController
@RequestMapping("/buyer/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseVO<List<BuyerProductInfoVO>> selectBuyerFoods(){

        List<BuyerProductInfoVO> buyerProductInfoVOList = productService.selectAllProducts();

        if(buyerProductInfoVOList != null && buyerProductInfoVOList.size()>0){
            return ResponseVO.success(buyerProductInfoVOList);
        }
        return ResponseVO.error(CodeMsg.PRODUCT_NOT_EXIST);
    }

}
