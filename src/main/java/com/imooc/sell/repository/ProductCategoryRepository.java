package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 曹友学
 * 2020-02-18 22:32
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

}
