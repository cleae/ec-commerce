package com.tl.eccommercecommon.service.impl;

import com.tl.service.domain.Goods;
import com.tl.service.mapper.CommodityMapper;
import com.tl.eccommercecommon.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    @Resource
    CommodityMapper commodityMapper;

    /**
     * 获取商品
     * @return
     */
    @Override
    public List<Goods> getCommoditiesWithSpec(){
        return commodityMapper.getGoodSpec(null);
    }


    /**
     * 获取单个商品及其详情信息
     * @param goods_id
     * @return
     */
    @Override
    public List<Goods> getCommodityWithSpec(int goods_id) {
        return commodityMapper.getGoodSpec(goods_id);
    }


}
