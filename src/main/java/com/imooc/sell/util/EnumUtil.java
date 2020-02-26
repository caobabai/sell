package com.imooc.sell.util;

import com.imooc.sell.enums.CodeEnum;

/**
 * Created by 曹友学
 * 2020-02-26 11:21
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }

}
