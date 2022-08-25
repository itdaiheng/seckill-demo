package com.itdaiheng.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itdaiheng.seckill.pojo.SeckillOrder;
import com.itdaiheng.seckill.pojo.User;


/**
 * @Description: 服务类
 * @Author itdaiheng
 * @Date 2022/8/22 16:37
 */

public interface ISeckillOrderService extends IService<SeckillOrder> {

/**
 * @Description:获取秒杀 结果
 * @Author itdaiheng
 * @Date 2022/8/24 17:09
 */

    Long getResult(User user, Long goodsId);

}
