package com.imooc.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 曹友学
 * 2020-02-27 14:26
 */
@Data
@Component
@ConfigurationProperties(prefix = "projecturl")
public class ProjectUrl {

    /** 微信公众平台授权url */
    public String wechatMpAuthorize;

    /** 微信开放平台授权url */
    public String wechatOpenAuthorize;

    /** 点餐系统 */
    public String sell;

}
