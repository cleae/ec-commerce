package com.tl.eccommercecommon.init;


import com.tl.eccommercecommon.aspectj.annotation.Log;
import com.tl.eccommercecommon.web.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ip拉黑
 * created by linTan 2020/6/26
 *
 */
@Component
public class UserFilter {

    @Autowired
    RedisService redisService;


    /**
     * 拉黑名单
     * @param ip
     */
    @Log
    public void addIpBlankList(String ip){

        System.out.println("拉黑名单。。。"+ip);
    }
}
