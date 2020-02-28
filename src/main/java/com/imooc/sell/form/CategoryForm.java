package com.imooc.sell.form;

import lombok.Data;

/**
 * Created by 曹友学
 * 2020-02-26 21:05
 */
@Data
public class CategoryForm {

    /** 分类id */
    private Integer categoryId;
    /** 分类名 */
    private String categoryName;
    /** 分类编号 */
    private Integer categoryType;

}
