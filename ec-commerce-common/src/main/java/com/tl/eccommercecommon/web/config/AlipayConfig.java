package com.tl.eccommercecommon.web.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource(value = "classpath:application.properties")

public class AlipayConfig {


    @Value("${alipay.config.appId}")
    private String appId;

    @Value("${alipay.config.merchant_private_key}")
    private String merchant_private_key;

    @Value("${alipay.config.alipay_public_key}")
    private String alipay_public_key;

    @Value("${alipay.config.notify_url}")
    private String notify_url;

    @Value("${alipay.config.return_url}")
    private String return_url;

    @Value("${alipay.config.sign_type}")
    private String sign_type;

    @Value("${alipay.config.charset}")
    private String charset;


    @Value("${alipay.config.gatewayUrl}")
    private String gatewayUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMerchant_private_key() {
        return merchant_private_key;
    }

    public void setMerchant_private_key(String merchant_private_key) {
        this.merchant_private_key = merchant_private_key;
    }

    public String getAlipay_public_key() {
        return alipay_public_key;
    }

    public void setAlipay_public_key(String alipay_public_key) {
        this.alipay_public_key = alipay_public_key;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }
}
