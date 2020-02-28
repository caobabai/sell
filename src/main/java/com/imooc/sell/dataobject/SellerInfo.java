package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 曹友学
 * 2020-02-27 11:37
 */
@Data
@Entity
public class SellerInfo {
    @Id
    private String id;

    private String username;

    private String password;

    private String openid;
}
