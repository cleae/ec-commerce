package com.tl.eccommercecommon.web;


import com.tl.eccommercecommon.init.UserFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {


    @Autowired
    UserFilter userFilter;

    @GetMapping("/hello")
    @ResponseBody
    public String getOrder(){
        userFilter.addIpBlankList("43.232.232.120");
        return "hello";
    }
}
