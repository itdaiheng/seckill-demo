package com.itdaiheng.seckill.vo;

import com.itdaiheng.seckill.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:详情返回对象
 * @Author itdaiheng
 * @Date 2022/8/20 20:32
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailVo {

	private User user;

	private GoodsVo goodsVo;

	private int secKillStatus;

	private int remainSeconds;
}
