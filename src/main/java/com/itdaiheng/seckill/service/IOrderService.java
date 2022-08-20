package com.itdaiheng.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itdaiheng.seckill.pojo.Order;
import com.itdaiheng.seckill.pojo.User;
import com.itdaiheng.seckill.vo.GoodsVo;
import org.springframework.stereotype.Service;


/**
 * @Author：itdaiheng
 * @data:2022/8/16-19:23
 * @Description:
 */

public interface IOrderService extends IService<Order> {
    Order seckill(User user, GoodsVo goods);
}
