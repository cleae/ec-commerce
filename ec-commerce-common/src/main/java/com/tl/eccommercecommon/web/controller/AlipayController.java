package com.tl.eccommercecommon.web.controller;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.tl.eccommercecommon.web.utils.AliPayUtil;
import com.tl.eccommercecommon.web.config.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
@RequestMapping("/pay/order")
public class AlipayController {

    @Autowired
    AlipayClient clientConfig;


    @Autowired
    AlipayTradePagePayRequest tradePagePayRequest;

    @Autowired
    AlipayConfig alipayConfig;


    //记一个问题  如果Java程序于nginx 运行再不同的主机下，用户每次请求sessionId 仍旧是每次都不一样


    /**
     *
     * @param trade_no  订单号
     * @param amount  金额
     * @param commodity_name  商品名称
     * @param commodity_body  商品描述
     * @param response
     */
    @PostMapping("/info")
    public void AliPayInfo(@RequestParam(value = "trade_no",required = true) String trade_no,
                           @RequestParam(value = "amount",required = true) String amount,
                           @RequestParam(value = "commodity_name",required = true) String commodity_name,
                           @RequestParam(value = "commodity_body",required = true) String commodity_body, HttpServletResponse response
                           ) throws UnsupportedEncodingException {

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String(trade_no.getBytes("ISO-8859-1"),"UTF-8");
        //付款金额，必填
        String total_amount = new String(amount.getBytes("ISO-8859-1"),"UTF-8");
        //订单名称，必填
        String subject = new String(commodity_name.getBytes("ISO-8859-1"),"UTF-8");
        //商品描述，可空
        String body = new String(commodity_body.getBytes("ISO-8859-1"),"UTF-8");

        tradePagePayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        try{
            //请求支付
            String result = clientConfig.pageExecute(tradePagePayRequest).getBody();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out=response.getWriter();
            //输出
            out.println(result);
            System.out.println(result);
            out.flush();
            out.close();
        }catch ( Exception e ){
            e.printStackTrace();
        }
    }


    /**
     *支付宝支付服务器异步通知
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/notify")
    public  void notify(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, AlipayApiException {
        Map<String,String> params = AliPayUtil.getRequestMap(request);
        boolean signVerified=false;
        if(!params.isEmpty()){
            //SDK验证签名
             signVerified = AlipaySignature.rsaCheckV1(params, alipayConfig.getAlipay_public_key(), alipayConfig.getCharset(), alipayConfig.getSign_type());
        }
        try{
            PrintWriter out =response.getWriter();
            if(signVerified){
                if(signVerified) {//验证成功
                    String out_trade_no = new String(request.getParameter("out_trade_no"));
                    String trade_no = new String(request.getParameter("trade_no"));
                    //交易状态
                    String trade_status = new String(request.getParameter("trade_status"));

                    System.out.println("callback");
                    System.out.println(out_trade_no+"\t" +trade_no+"\t"+trade_status);

                    if(trade_status.equals("TRADE_FINISHED")){//支付完成，这笔交易不能再做任何操作
                        //更新数据

                    }else if (trade_status.equals("TRADE_SUCCESS")){ //支付成功，卖家还可以执行退款等操作
                        //更新数据
                    }

                    out.println("success");

                }else {//验证失败
                    out.println("fail");
                }
            }else {
                out.println("fail");
            }
        }catch (IOException e){

        }

    }

    /**
     * 支付宝支付支付成功跳转命令
     * @param request
     * @param response
     */
    public void return_url(HttpServletRequest request, HttpServletResponse response){

    }


}
