package com.itdaiheng.seckill.rabbitmq;

import com.itdaiheng.seckill.pojo.SeckillMessage;
import com.itdaiheng.seckill.pojo.SeckillOrder;
import com.itdaiheng.seckill.pojo.User;
import com.itdaiheng.seckill.service.IGoodsService;
import com.itdaiheng.seckill.service.IOrderService;
import com.itdaiheng.seckill.utils.JsonUtil;
import com.itdaiheng.seckill.vo.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author：itdaiheng
 * @data:2022/8/23-16:40
 * @Description:
 */
@Service
@Slf4j
public class MQReceiver {

        @Autowired
        private IGoodsService goodsService;
        @Autowired
        private RedisTemplate redisTemplate;
        @Autowired
        private IOrderService orderService;

    @RabbitListener(queues = "seckillQueue")
    public void receive(String message) {
        log.info("接收消息：" + message);
        SeckillMessage seckillMessage = JsonUtil.jsonStr2Object(message, SeckillMessage.class);
        Long goodId = seckillMessage.getGoodId();
        User user = seckillMessage.getUser();
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodId);
        if (goodsVo.getStockCount() < 1) {
            return;
        }
        //判断是否重复抢购
        SeckillOrder SeckillOrder = (SeckillOrder) redisTemplate.opsForValue().get("order:" + user.getId() + ":" + goodId);
        if (SeckillOrder != null) {
            return;
        }
        //下单操作
        orderService.seckill(user,goodsVo);

    }







//    @RabbitListener(queues = "queue")
//    public void receive(Object msg) {
//        log.info("接收到的消息" + msg);}

}
