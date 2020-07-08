package com.tl.service.mapper;

import com.tl.service.domain.Goods;
import com.tl.service.domain.GoodsSpecs;
import org.apache.ibatis.annotations.Select;
import org.springframework.lang.Nullable;

import java.util.List;


public interface CommodityMapper {



    /**
     * 商品
     * @param goods_id
     * @return
     */
    Goods getGood(int goods_id);

    /**
     * 获取商品信息及其规格
     * @param goods_id
     * @return
     */
    List<Goods> getGoodSpec( Integer goods_id);


}
