package com.lianweibo.product.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName ProductVO
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/14
 * @Version V1.0
 **/
@Data
public class ProductVO {
    private String productName;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    private Integer productType;

    private String fieldName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    private Integer pageNum;
    private Integer pageSize;
}
