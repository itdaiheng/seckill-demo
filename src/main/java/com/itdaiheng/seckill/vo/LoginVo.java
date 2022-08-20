package com.itdaiheng.seckill.vo;

import com.itdaiheng.seckill.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Author：itdaiheng
 * @data:2022/8/8-16:56
 * @Description:登录参数
 */
@Data
public class LoginVo {
    @NotNull
    @IsMobile
    private String mobile;
    @NotNull
    @Length(min = 32)
    private String password;

}
