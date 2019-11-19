package com.lianweibo.product.vo;

import lombok.Data;

/**
 * @ClassName ResponseVO
 * @Description: TODO
 * @Author :lianweibo
 * @Date 2019/11/13
 * @Version V1.0
 **/
@Data
public class ResponseVO<T> {// 泛型类
    private int code;
    private String msg;
    private T data;

    public static <T> ResponseVO success(T data){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(data);
        responseVO.setMsg(CodeMsg.SUCCESS.getMsg());
        responseVO.setCode(CodeMsg.SUCCESS.getCode());
        return responseVO;
    }
    public static <T> ResponseVO error(CodeMsg codeMsg){//泛型方法
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(codeMsg.getCode());
        responseVO.setMsg(codeMsg.getMsg());
        return responseVO;
    }

}
