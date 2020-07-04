package com.tl.eccommercecommon.init;


import com.tl.eccommercecommon.aspectj.annotation.Log;
import org.springframework.stereotype.Component;

/**
 * ip拉黑
 * created by linTan 2020/6/26
 *
 */
@Component
public class UserFilter {


    /**
     * 拉黑名单
     * @param ip
     */
    @Log
    public void addIpBlankList(String ip){

        System.out.println("拉黑名单。。。"+ip);
    }
}
