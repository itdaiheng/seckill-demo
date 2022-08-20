package com.itdaiheng.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itdaiheng.seckill.pojo.User;
import com.itdaiheng.seckill.vo.LoginVo;
import com.itdaiheng.seckill.vo.RespBean;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author：itdaiheng
 * @data:2022/8/8-17:16
 * @Description:
 */

public interface IUserService extends IService<User> {
    /**
     * 登录
     * @param loginVo
     * @param request
     * @param response
     * @return
     */
    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);


    User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response);

    RespBean updatePassword(String userTicket, String password, HttpServletRequest request,
                            HttpServletResponse response);
}
