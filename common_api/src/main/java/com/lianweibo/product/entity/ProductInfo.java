package com.lianweibo.product.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName ProductInfo
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/13
 * @Version V1.0
 **/
@Data
@Entity
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;
    /** 名字. */
    private String productName;
    /** 单价. */
    private BigDecimal productPrice;
    /** 库存. */
    private Integer productStock;
    /** 描述. */
    private String productDescription;
    /** 小图. */
    private String productIcon;
    /** 状态, 0正常1下架. */
    private Integer productStatus = 0;

    /** 类目编号. */
    private Integer categoryType;
    @Transient
    private String categoryName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


}
