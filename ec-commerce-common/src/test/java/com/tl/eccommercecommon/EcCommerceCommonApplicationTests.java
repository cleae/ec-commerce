package com.tl.eccommercecommon;

import com.tl.eccommercecommon.init.UserFilter;
import com.tl.eccommercecommon.web.redis.RedisService;
import com.tl.eccommercecommon.web.utils.access.AccessUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcCommerceCommonApplicationTests {

    @Autowired
    private RedisService redisService;

    @Autowired
    UserFilter userFilter;

    @Autowired
    AccessUtils activeUser;

    @Test
    void contextLoads() {
    }

    @Test
    public String getOrder(){
        userFilter.addIpBlankList("43.232.232.120",12);

        redisService.setBit("lintan",1,true);

        boolean offset_value=redisService.getBit("lintan",1);


        redisService.set("school","hnist");



        System.out.println(offset_value?1:0);


        System.out.println(redisService.get("school"));//bind  uncomment


        System.out.println(activeUser.activeUser("lintan","lintan2"));


        return "hello";
    }

}
