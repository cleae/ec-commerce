package com.tl.eccommercecommon.service.impl;


import com.google.gson.Gson;
import com.tl.eccommercecommon.web.config.WeChatConfig;
import com.tl.eccommercecommon.web.utils.CommonUtils;
import com.tl.eccommercecommon.web.utils.HttpUtils;
import com.tl.eccommercecommon.web.utils.WXPayUtil;
import com.tl.service.domain.Goods;
import com.tl.service.domain.GoodsSpecs;
import com.tl.service.domain.Order;
import com.tl.service.mapper.CommodityMapper;
import com.tl.service.mapper.OrderMapper;
import com.tl.eccommercecommon.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Service
public class OrderServiceImpl  implements OrderService {


    @Resource
    OrderMapper orderMapper;

    @Autowired
    WeChatConfig weChatConfig;

    @Resource
    CommodityMapper commodityMapper;


    /**
     * 统一下单方法
     * 保存订单，生成订单code_url return
     *
     * @param goods_id
     * @param specs_id
     * @param userIp
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public String unifiedOrder(int goods_id, int specs_id, String userIp, int userId, String address, String consignee, String mobile) throws Exception {


        Goods goods = commodityMapper.getGood(goods_id);
        if (null == goods) return null;

        int price = goods.getDetails().get(0).getPrice();
        Order order = new Order();
        order.setAddress(address);
        order.setGoodsId(goods_id);
        order.setOrderId(CommonUtils.generateUUID());
        order.setTotalFee(price);
        order.setSpecsId(specs_id);
        order.setUserId(userId);
        order.setUserIp(userIp);
        order.setConsignee(consignee);
        order.setMobile(mobile);
        int influence = orderMapper.save(order);
        if (influence == 0) return null;

        /**
         * 生成签名
         * document :https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1
         */
        SortedMap<String, String> params = new TreeMap<>();
        params.put("appid", weChatConfig.getAppId());
        params.put("mch_id", weChatConfig.getMchId());
        params.put("nonce_str", CommonUtils.generateUUID());
        params.put("body", goods.getDescription());
        params.put("out_trade_no", order.getOrderId());
        params.put("total_fee", order.getTotalFee().toString());
        params.put("spbill_create_ip", userIp);
        params.put("notify_url", weChatConfig.getPayCallbackUrl());
        params.put("trade_type", "NATIVE");

        //sign签名
        String sign = WXPayUtil.createSign(params, weChatConfig.getKey());
        params.put("sign", sign);

        final Gson gson = new Gson();
        System.out.println("order sign:" + gson.toJson(sign));
        //map转xml
        String payXml = WXPayUtil.mapToXml(params);

        System.out.println(payXml);
        /**
         * 统一下单的协议为https 不必担心数据包被截取并篡改
         */
        String orderStr = HttpUtils.doPost(WeChatConfig.getUnifiedOrderUrl(), payXml, 4000);
        if (null == orderStr) {
            return null;
        }

        Map<String, String> unifiedOrderMap = WXPayUtil.xmlToMap(orderStr);
        System.out.println(unifiedOrderMap.toString());
        if (unifiedOrderMap.get("code_url") != null) {
            return unifiedOrderMap.get("code_url");
        }

        return null;
    }





    /**
     * 回调改变订单状态
     *
     * @param openid
     * @param transactionId
     * @param orderId
     * @return
     */
    @Override
    public int updateOrderState(String openid, String transactionId, String orderId) {
        return orderMapper.update(openid, transactionId, orderId);
    }

    /**
     * 订单超时或取消
     *
     * @param orderId
     * @return
     */
    @Override
    public int delete(String orderId) {
        return orderMapper.delete(orderId);
    }

    /**
     * 保存订单
     *
     * @param order
     * @return
     */
    @Override
    public int save(Order order) {
        return orderMapper.save(order);
    }

    /**
     * 获取订单
     *
     * @param userId
     * @return
     */
    @Override
    public List<Map<String, Object>> getOrderByUserId(int userId) {
        return orderMapper.getOrderByUserId(userId);
    }

    /**
     * 获取当前支付的订单状态
     *
     * @param userId
     * @param goods_id
     * @param specs_id
     * @return
     */
    @Override
    public List<Order> getCurrentOrder(int userId, int goods_id, int specs_id) {
        return orderMapper.getCurrenrOrderMsg(userId, goods_id, specs_id);


    }


    /**
     * 获取订单
     *
     * @param orderId
     * @return
     */
    @Override
    public Order getOrderByOrderId(String orderId) {
        return orderMapper.getOrderByOrderId(orderId);
    }
}
