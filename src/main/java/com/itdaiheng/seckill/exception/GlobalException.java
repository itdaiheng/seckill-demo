package com.itdaiheng.seckill.exception;

import com.itdaiheng.seckill.vo.RespBeanEnum;

/**
 * @Author：itdaiheng
 * @data:2022/8/9-15:47
 * @Description:运行时异常
 */
public class GlobalException extends RuntimeException{

    private RespBeanEnum respBeanEnum;

    public RespBeanEnum getRespBeanEnum() {
        return respBeanEnum;
    }

    public void setRespBeanEnum(RespBeanEnum respBeanEnum) {
        this.respBeanEnum = respBeanEnum;
    }

    public GlobalException(RespBeanEnum respBeanEnum) {
        this.respBeanEnum = respBeanEnum;
    }
}
