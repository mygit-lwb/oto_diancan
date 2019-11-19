package com.lianweibo.product.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName FoodVO
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/13
 * @Version V1.0
 **/
@Data
public class FoodVO {
    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private String icon;
}
