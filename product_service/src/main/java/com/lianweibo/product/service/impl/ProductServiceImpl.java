package com.lianweibo.product.service.impl;

import com.lianweibo.product.entity.ProductCategory;
import com.lianweibo.product.entity.ProductInfo;
import com.lianweibo.product.utils.DataTranferTool;
import com.lianweibo.product.vo.BuyerProductInfoVO;
import com.lianweibo.product.vo.FoodVO;
import com.lianweibo.product.repository.ProductCategoryRepository;
import com.lianweibo.product.repository.ProductInfoRepository;
import com.lianweibo.product.service.ProductService;
import com.lianweibo.product.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/14
 * @Version V1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<BuyerProductInfoVO> selectAllProducts() {
        List<BuyerProductInfoVO> productVOList = new ArrayList<>();

        List<ProductCategory> catList = productCategoryRepository.findAll();

        if(catList!=null && catList.size()>0){
            for(int i = 0;i<catList.size();i++){
                BuyerProductInfoVO buyer = new BuyerProductInfoVO();
                ProductCategory cat = catList.get(i);
                buyer.setName(cat.getCategoryName());
                buyer.setType(cat.getCategoryType());
                List<FoodVO> foodVOS = new ArrayList<>();
                List<ProductInfo> productInfos = productInfoRepository.findAllByProductStatusAndAndCategoryType(0, cat.getCategoryType());
                if(productInfos!=null && productInfos.size()>0){
                    for(ProductInfo productInfo : productInfos){
                        // 借助工具类将productInfo转换为FoodVO
                        FoodVO foodVO = DataTranferTool.transferProductInfo(productInfo);
                        foodVOS.add(foodVO);
                    }
                }
                buyer.setFoods(foodVOS);
                productVOList.add(buyer);
            }
        }
        return productVOList;
    }

    @Override
    public Page<ProductInfo> selectSellerProducts(ProductVO productVO) {

        Specification<ProductInfo> spec = new Specification<ProductInfo>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if(productVO.getProductName()!=null && !productVO.getProductName().equals("")){
                    Predicate p1 = cb.like(root.get("productName"), "%" + productVO.getProductName() + "%");
                    list.add(p1);
                }
                if(productVO.getMinPrice()!=null){
                    Predicate p2 = cb.ge(root.get("productPrice"), productVO.getMinPrice());
                    list.add(p2);
                }
                if(productVO.getMaxPrice()!=null){
                    Predicate p3 = cb.le(root.get("productPrice"), productVO.getMaxPrice());
                    list.add(p3);
                }
                if(productVO.getFieldName()!=null && !productVO.getProductName().equals("")){
                    if(productVO.getStartDate()!=null){
                        Predicate p4 = cb.greaterThanOrEqualTo(root.get(productVO.getFieldName()), productVO.getStartDate());
                        list.add(p4);
                    }
                    if(productVO.getEndDate()!=null){
                        Predicate p5 = cb.greaterThanOrEqualTo(root.get(productVO.getFieldName()), productVO.getEndDate());
                        list.add(p5);
                    }
                }
                Predicate[] array = list.toArray(new Predicate[list.size()]);
                return cb.and(array);
            }
        };
        Page<ProductInfo> page = productInfoRepository.findAll(spec, PageRequest.of(productVO.getPageNum() - 1, productVO.getPageSize()));
        return page;
    }

    @Override
    public void deleteByIds(ArrayList<ProductInfo> ids) {
        productInfoRepository.deleteAll(ids);
    }
    @Override
    public void deleteById(String productId) {
        productInfoRepository.deleteById(productId);
    }
}
