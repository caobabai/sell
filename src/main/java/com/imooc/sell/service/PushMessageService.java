package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

/**
 * 推送消息
 * Created by 曹友学
 * 2020-02-27 21:39
 */
public interface PushMessageService {

    /** 订单状态变更消息 */
    void orderStatus(OrderDTO orderDTO);

}
