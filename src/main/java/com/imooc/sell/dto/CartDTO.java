package com.imooc.sell.dto;

import lombok.Data;

/**
 * 购物车
 * Created by 曹友学
 * 2020-02-22 13:28
 */
@Data
public class CartDTO {

    /** 商品id */
    private String productId;

    /** 数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public CartDTO() {
    }
}
