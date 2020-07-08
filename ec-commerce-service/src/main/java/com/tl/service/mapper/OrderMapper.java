package com.tl.service.mapper;


import com.tl.service.domain.Order;
import com.tl.service.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    /**
     * 保存订单，返回自增主键
     * @param order
     * @return
     */
    int save(Order order);


    /**
     * 支付成功，微信回调里改变订单状态
     * @param openid
     * @param transactionId
     * @param orderId
     * @return
     */
    int update(@Param("openid") String openid, @Param("transactionId") String transactionId, @Param("orderId") String orderId);


    /**
     * 获取用户订单
     * @param userId
     * @return
     */
    List<Map<String,Object>> getOrderByUserId(int userId);


    /**
     * 获取用户订单
     * @param orderId
     * @return
     */
    Order getOrderByOrderId(String orderId);

    /**
     * 支付状态查询
     * @param user_id
     * @param goods_id
     * @param spec_id
     * @return
     */
    List<Order> getCurrenrOrderMsg(int user_id,int goods_id,int spec_id);


    /**
     * 订单超时或取消
     * @param orderId
     * @return
     */
    int delete(String orderId);
}





