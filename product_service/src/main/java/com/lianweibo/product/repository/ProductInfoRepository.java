package com.lianweibo.product.repository;

import com.lianweibo.product.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @InterfaceName ProductInfoRepository
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/14
 * @Version V1.0
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>, JpaSpecificationExecutor<ProductInfo> {

    List<ProductInfo> findAllByProductStatusAndAndCategoryType(Integer status,Integer type);

}
