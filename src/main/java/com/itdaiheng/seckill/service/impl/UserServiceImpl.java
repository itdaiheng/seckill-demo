package com.itdaiheng.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itdaiheng.seckill.exception.GlobalException;
import com.itdaiheng.seckill.mapper.UserMapper;
import com.itdaiheng.seckill.pojo.User;
import com.itdaiheng.seckill.service.IUserService;
import com.itdaiheng.seckill.utils.CookieUtil;
import com.itdaiheng.seckill.utils.MD5Util;
import com.itdaiheng.seckill.utils.UUIDUtil;
import com.itdaiheng.seckill.vo.LoginVo;
import com.itdaiheng.seckill.vo.RespBean;
import com.itdaiheng.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    @Resource

    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    /**
     * 登录
     */
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {

        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
      /*  if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        if (!ValidatorUtil.isMobile(mobile)) {
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);

        }*/
        //根据手机号获取用户
        User user = userMapper.selectById(mobile);
        if (null==user){

            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
            //return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        //判断密码是否正确
        if(!MD5Util.formPassToDBPass(password,user.getSalt()).equals(user.getPassword())){

            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
            //return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        String ticket = UUIDUtil.uuid();
        //将用户信息存入redis中
        redisTemplate.opsForValue().set("user:" + ticket, user);
        //request.getSession().setAttribute(ticket,user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);

        return RespBean.success(ticket);
    }

    /**
     * 根据cookie返回对象
     * @param userTicket
     * @param request
     * @param response
     * @return
     */
    @Override
    public User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(userTicket)) {
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user:" + userTicket);
        if (user != null) {
            CookieUtil.setCookie(request, response, "userTicket", userTicket);
        }
        return user;
    }
/**
 * @Description: 更新密码
 * @Author itdaiheng
 * @Date 2022/8/20 20:08
 */

    @Override
    public RespBean updatePassword(String userTicket, String password, HttpServletRequest request,
                                   HttpServletResponse response) {
        User user = getUserByCookie(userTicket, request, response);
        if (user == null) {
            throw new GlobalException(RespBeanEnum.MOBILE_NOT_EXIST);
        }
        user.setPassword(MD5Util.inputPassToDBPass(password, user.getSalt()));
        int result = userMapper.updateById(user);
        if (1 == result) {
            //删除Redis
            redisTemplate.delete("user:" + userTicket);
            return RespBean.success();
        }
        return RespBean.error(RespBeanEnum.PASSWORD_UPDATE_FAIL);
    }
}



