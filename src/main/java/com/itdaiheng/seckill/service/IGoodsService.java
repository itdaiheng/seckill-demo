package com.itdaiheng.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itdaiheng.seckill.pojo.Goods;
import com.itdaiheng.seckill.vo.GoodsVo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IGoodsService extends IService<Goods> {

/**
 * @Description:跳转商品页
 * @Param:
 * @Return:
 * @Author itdaiheng
 * @Date 2022/8/16 13:27
 */

    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
