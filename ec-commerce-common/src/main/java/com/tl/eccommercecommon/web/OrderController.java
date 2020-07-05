package com.tl.eccommercecommon.web;


import com.tl.eccommercecommon.init.UserFilter;
import com.tl.eccommercecommon.web.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class OrderController {

    @Autowired
    private RedisService redisService;

    @Autowired
    UserFilter userFilter;

    @GetMapping("/hello")
    @ResponseBody
    public String getOrder(){
        userFilter.addIpBlankList("43.232.232.120");

        redisService.setBit("lintan",1,true);

        boolean offset_value=redisService.getBit("lintan",1);


        redisService.set("school","hnist");



        System.out.println(offset_value?1:0);


        System.out.println(redisService.get("school"));

        return "hello";
    }
}
