package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

/**
 * 买家
 * Created by 曹友学
 * 2020-02-23 18:25
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);


}
