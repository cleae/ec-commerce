package com.tl.eccommercecommon.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/hello")
    @ResponseBody
    public String getOrder(){
        return "hello";
    }
}
