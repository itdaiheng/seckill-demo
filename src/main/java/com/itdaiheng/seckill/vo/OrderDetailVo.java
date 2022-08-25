package com.itdaiheng.seckill.vo;

import com.itdaiheng.seckill.pojo.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:订单详情返回对象
 * @Author itdaiheng
 * @Date 2022/8/22 15:44
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailVo {

	private Order order;

	private GoodsVo goodsVo;
}
