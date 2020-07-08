package com.tl.eccommercecommon.web.utils.access;


import com.tl.eccommercecommon.web.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.stereotype.Component;

/**
 * 使用bitmap 二进制位数组统计日访问量，活跃用户数量（连续两天访问）
 * created by linTan 2020/7/1
 *
 */
@Component
public class AccessUtils {


    @Autowired
    private RedisService redisService;

    /**
     * setBit
     * @param key  日期
     * @param offset 偏移量 ，使用用户id
     * @param value  1
     */
    public  void access(String key,long offset,boolean value){
        redisService.setBit(key,offset,value);
    }


    /**
     * 统计在给定时间段内用户活跃数量
     * @param keys
     * @return
     */
    public Long activeUser( String ...keys){
        String destination="fff";
        Long test= redisService.bitOperation(RedisStringCommands.BitOperation.AND,destination,keys);
        System.out.println("operation:" +test);
        //统计人数  bitCount
        return redisService.bitCount(destination);
    }

}
