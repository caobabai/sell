package com.imooc.sell.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * http请求返回的最外层对象
 * Created by 曹友学
 * 2020-02-19 18:20
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;



}
