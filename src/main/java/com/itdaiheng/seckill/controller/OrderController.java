package com.itdaiheng.seckill.controller;

import com.itdaiheng.seckill.pojo.User;
import com.itdaiheng.seckill.service.IOrderService;
import com.itdaiheng.seckill.vo.OrderDetailVo;
import com.itdaiheng.seckill.vo.RespBean;
import com.itdaiheng.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;


/**
 * @author Administrator
 */
@Controller
@RequestMapping("/order")
public class OrderController {

@Autowired
private IOrderService orderService;


    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public RespBean detail(User user, Long orderId) {
        if (user == null) {
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }
           OrderDetailVo detail= orderService.detail(orderId);
        return RespBean.success(detail);
    }



}
