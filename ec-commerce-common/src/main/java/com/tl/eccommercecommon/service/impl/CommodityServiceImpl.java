package com.tl.eccommercecommon.service.impl;

import com.tl.service.domain.Goods;
import com.tl.service.mapper.CommodityMapper;
import com.tl.eccommercecommon.service.CommodityService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品
 */
@Service
@CacheConfig(cacheNames="commodityInfoCache")
public class CommodityServiceImpl implements CommodityService {

    @Resource
    CommodityMapper commodityMapper;

    /**
     * 获取商品
     * @return
     */
    @Cacheable(key = "#p0")
    @Override
    public List<Goods> getCommoditiesWithSpec(String type){
        return commodityMapper.getGoodSpec(null);
    }


    /**
     * 获取单个商品及其详情信息
     * @param goods_id
     * @return
     */
    @Cacheable(key = "#p0")
    //    @Cacheable(value = "ec-msg" ,key="#p0")
    @Override
    public List<Goods> getCommodityWithSpec(int goods_id) {
        System.out.println("called..");
        return commodityMapper.getGoodSpec(goods_id);
    }


}
