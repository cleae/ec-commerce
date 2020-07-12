package com.tl.eccommercecommon.web;


import com.tl.eccommercecommon.init.UserFilter;
import com.tl.eccommercecommon.web.redis.RedisService;
import com.tl.eccommercecommon.web.utils.access.AccessUtils;
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

    @Autowired
    AccessUtils activeUser;

    /**
     * Error:java: Annotation processing is not supported for module cycles.
     * Please ensure that all modules from cycle [ec-commerce-service,ec-commerce-common] are excluded from annotation processing
     * @return
     */
    @GetMapping("/hello")
    @ResponseBody
    public String getOrder(){
        userFilter.addIpBlankList("43.232.232.120",12);

        redisService.setBit("lintan",1,true);

        boolean offset_value=redisService.getBit("lintan",1);


        redisService.set("school","hnist");



        System.out.println(offset_value?1:0);

        redisService.set("school3","湖南大学");
        System.out.println(">>>>>>>>>>>>>>>>>>>>"+redisService.get("school3"));//bind  uncomment


        System.out.println(activeUser.activeUser("lintan","lintan2"));


        return "hello";
    }
}
