package com.imooc.sell.service;

import com.imooc.sell.dataobject.SellerInfo;

/**
 * 卖家端
 * Created by 曹友学
 * 2020-02-27 11:55
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);

}
