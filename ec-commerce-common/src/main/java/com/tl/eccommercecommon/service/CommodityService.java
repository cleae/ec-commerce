package com.tl.eccommercecommon.service;


import com.tl.service.domain.Goods;

import java.util.List;

public interface CommodityService {

    public List<Goods> getCommoditiesWithSpec(String type);
    public List<Goods>getCommodityWithSpec(int goods_id);



}
