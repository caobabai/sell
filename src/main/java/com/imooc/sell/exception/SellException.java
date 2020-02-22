package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;

/**
 * Created by 曹友学
 * 2020-02-22 12:21
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
