package com.imooc.sell.controller;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.service.ICategoryService;
import com.imooc.sell.service.IProductService;
import com.imooc.sell.util.ResultVOUtil;
import com.imooc.sell.vo.ProductInfoVO;
import com.imooc.sell.vo.ProductVO;
import com.imooc.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 曹友学
 * 2020-02-19 18:18
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        //注意别把数据库查询放入for循环中
        //1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 查询类目（一次性查询）
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装
//        List<ProductVO> productVOList = new ArrayList<>();
//        for (ProductCategory productCategory : productCategoryList) {
//            ProductVO productVO = new ProductVO();
//            productVO.setCategoryName(productCategory.getCategoryName());
//            productVO.setCategoryType(productCategory.getCategoryType());
//
//            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
//            for (ProductInfo productInfo : productInfoList) {
//                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
//                    ProductInfoVO productInfoVO = new ProductInfoVO();
//                    BeanUtils.copyProperties(productInfo, productInfoVO);
//                    productInfoVOList.add(productInfoVO);
//                }
//            }
//            productVO.setProductInfoVOList(productInfoVOList);
//            productVOList.add(productVO);
//        }


        //3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        long count = productCategoryList.stream().filter(productCategory -> {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            long count2 = productInfoList.stream().filter(productInfo -> {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
                return false;
            }).count();
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
            return false;
        }).count();
//        ResultVO resultVO = new ResultVO<>();//不声明类型，默认Object
        return ResultVOUtil.success(productVOList);
    }
}
