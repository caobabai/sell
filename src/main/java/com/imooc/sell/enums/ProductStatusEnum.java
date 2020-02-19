package com.imooc.sell.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by 曹友学
 * 2020-02-19 14:44
 */
@Getter
public enum ProductStatusEnum {

    UP(0, "在线"),
    DOWN(1, "下架")
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
