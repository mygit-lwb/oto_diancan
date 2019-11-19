package com.lianweibo.product.controller;

import com.lianweibo.product.entity.ProductInfo;
import com.lianweibo.product.service.ProductService;
import com.lianweibo.product.vo.CodeMsg;
import com.lianweibo.product.vo.ProductVO;
import com.lianweibo.product.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/16
 * @Version V1.0
 **/
@CrossOrigin
@RestController
@RequestMapping("/seller/product")
public class SellerController {

    @Autowired
    private ProductService productService;
    @GetMapping("/list")
    public ResponseVO<Page<ProductInfo>> selectSellerProducts(ProductVO productVO){
        Page<ProductInfo> productInfos = productService.selectSellerProducts(productVO);
        System.out.println(productInfos.getContent());
        productInfos.getContent();
        if(productInfos != null){
            return ResponseVO.success(productInfos);
        }
        return ResponseVO.error(CodeMsg.PRODUCT_NOT_EXIST);
    }
    @PostMapping("/deleteByIds")
    public boolean deleteByIds(@RequestBody ArrayList<ProductInfo> ids){
        System.out.println(ids);
        try {
            productService.deleteByIds(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @GetMapping("deleteById")
    public boolean deleteById(String productId){
        try {
            productService.deleteById(productId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
