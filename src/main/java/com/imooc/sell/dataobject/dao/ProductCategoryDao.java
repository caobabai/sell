package com.imooc.sell.dataobject.dao;

import com.imooc.sell.dataobject.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by 曹友学
 * 2020-02-28 12:57
 */
public class ProductCategoryDao {

    @Autowired
    CategoryMapper mapper;

    public int insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }

}
