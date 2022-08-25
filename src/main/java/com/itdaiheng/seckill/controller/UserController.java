package com.itdaiheng.seckill.controller;

import com.itdaiheng.seckill.pojo.User;
import com.itdaiheng.seckill.rabbitmq.MQSender;
import com.itdaiheng.seckill.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author：itdaiheng
 * @data:2022/8/8-10:55
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MQSender mqSender;

    /**
     * @Description:用户信息测试
     * @Author itdaiheng
     * @Date 2022/8/18 17:56
     */

    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(User user){
        return RespBean.success(user);
    }

//        @RequestMapping(value = "/mq", method = RequestMethod.GET)
//    @ResponseBody
//    public void mq() {
//        mqSender.send("Hello");
//    }


}
