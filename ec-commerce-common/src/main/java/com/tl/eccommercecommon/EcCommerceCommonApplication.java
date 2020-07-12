package com.tl.eccommercecommon;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.tl.service","com.tl.business","com.tl.eccommercecommon"})
//分布式sessionId一致性
@EnableRedisHttpSession
public class EcCommerceCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcCommerceCommonApplication.class, args);
    }

}
