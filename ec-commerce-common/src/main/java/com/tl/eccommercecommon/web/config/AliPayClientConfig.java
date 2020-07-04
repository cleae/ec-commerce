package com.tl.eccommercecommon.web.config;


import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 支付对象配置类
 *  created by linTan 2019/12/27
 */
@Component
public class AliPayClientConfig {

    @Autowired
    AlipayConfig alipayConfig;

    /**
     *获得初始化的AliPayClient
     * @return
     */
    @Bean
    public AlipayClient getAliPayConfig(){
        return new DefaultAlipayClient(alipayConfig.getGatewayUrl(),
                alipayConfig.getAppId(), alipayConfig.getMerchant_private_key(), "json", alipayConfig.getCharset(), alipayConfig.getAlipay_public_key(), alipayConfig.getSign_type());
    }

    /**
     * 支付请求参数类
     * @return
     */
    @Bean
    public AlipayTradePagePayRequest getTradePagePayRequest(){
        AlipayTradePagePayRequest aliPayRequest =new AlipayTradePagePayRequest();
        aliPayRequest.setReturnUrl(alipayConfig.getReturn_url());
        aliPayRequest.setNotifyUrl(alipayConfig.getNotify_url());
        return aliPayRequest;
    }


}
