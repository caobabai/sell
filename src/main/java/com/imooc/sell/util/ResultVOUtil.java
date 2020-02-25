package com.imooc.sell.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.imooc.sell.vo.ResultVO;

/**
 * Created by 曹友学
 * 2020-02-20 12:56
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
