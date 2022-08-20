package com.itdaiheng.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itdaiheng.seckill.mapper.GoodsMapper;
import com.itdaiheng.seckill.pojo.Goods;
import com.itdaiheng.seckill.service.IGoodsService;
import com.itdaiheng.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

	@Autowired
	@Resource
	private GoodsMapper goodsMapper;


	@Override
	public List<GoodsVo> findGoodsVo() {
		return goodsMapper.findGoodsVo();
	}

	@Override
	public GoodsVo findGoodsVoByGoodsId(Long goodsId) {
		return goodsMapper.findGoodsVoByGoodsId(goodsId);
	}





}
