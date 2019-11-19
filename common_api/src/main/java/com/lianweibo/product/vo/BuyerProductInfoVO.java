package com.lianweibo.product.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName BuyerProductInfoVO
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/13
 * @Version V1.0
 **/
@Data
public class BuyerProductInfoVO {
    private String name;
    private Integer type;
    private List<FoodVO> foods;
}
