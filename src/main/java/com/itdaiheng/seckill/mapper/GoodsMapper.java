package com.itdaiheng.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itdaiheng.seckill.pojo.Goods;
import com.itdaiheng.seckill.vo.GoodsVo;

import java.util.List;


public interface GoodsMapper extends BaseMapper<Goods> {


    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);

}
