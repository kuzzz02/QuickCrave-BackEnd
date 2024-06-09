package com.quickcravebackend.middleware;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.ExtUserInfo;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.quickcravebackend.model.Orders;
import org.springframework.web.bind.annotation.*;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.quickcravebackend.controller.OrdersController;

@RestController
@CrossOrigin
@RequestMapping("/alipay")
public class AlipayController {
    private final String serverUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    private final String appId = "9021000137608403";
    private final String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCY6ShbvSDv8jhT5ym95jTz8vx3UcifDKglbRmWZWfUJhplraZgBqJWNgPrvm6nBSWXcyW7zgwIPVAtwJWir/Cynt5/HJdXdZ9xq65Oy13H95YgZ6plAXcr8DlGvkbnTQDscnVPrbM6NeHLc5F9e202i32N2Y98t/14F0cjT+Zj9/3IkKbmzMh+PrEaNig7ejJTzUilfD2DKsXfrfMPt4IsS0C75Ay0hKEEGjFOeAyXXQHr+oc5gN8bzZZN2DueV/PK2w7AMzsjzq0TVdKZo2tw6kNO8lNhXO+CUvXHAd83IC0Eh5IS1tE+ab5r0tQGC9q6t6Z25HKwCNwDf3ZUJLThAgMBAAECggEBAJHApUSUyYGOC90GGka12UGzGq2NmkLo6JoMHXi7HjYdP8ottMoRaMnuYNxkP8saX9O14YDbjaKI9xU1XiydsjxArOrS0Pt/1cSfFd5rgO/r8wDeb5ApznNmXuIs2x78ymWXUHTrqExTMfAhL8xBSz/TxJDikSAbrRK8dYWWUpB0QcTruIehr06v+ymhnm2uJlMh8T1HdpiY4JMPipFy/vdTgn1hzA4KL6p3k20AykinrD4NQCcjcVZvfe4GbToukh6cVMZYmI4obqO5Oh7CklFejbBQyZCOhnVLQRY4gZZC0j1etLQYUb6Pn61Zx9yCE+PjqxWjWC8035zrZDbFhQECgYEA7YxJsLMwE2ZrGr4IDfnEYf8NsEUQqSYzRBTrWlG01Rs+XWg6Eki25shlVea4yG5zisIrdVmFldAPolG4IxsecWPsDCGlfnkbAwYv40NnrvV54nwAGsyPTOqtVVU7jC4FzckhNqf4z4iUOa/ufvAKiFVkiFM8JFOHoYJbGvtL6nECgYEApMnVYgYEPHpupCCAV3WmgObd5QE9lGMyr5zFhBaTJ5JmEOfTwYAGw91yVpXtTnTS+Mf3YJJrdsKLb2QSDP6gHE+nq4uxaBrbWKnuZzI3jUXpN3eaabgoGFRf9nTCflUM2LBRIhIFkudxfiPsNkaYhW/atZ4iMt6Woh/CrPJISXECgYBvTUMd0uecv2lBr3Zwre2xCONuCv5Ccw6kQLUBrbTwAQLYm0RSWtWwDodEl4VPDEmA43efVWG9Dy60HFwNvuAluu7XxFAZkT7xzM1VS7jiBkykrPsTk3M1U+QBTp1HEi1P/YRdapivDMx+twslWO1mcbRYF7/fOXAcYcq0OriYUQKBgCwpNrkFOb9nZB0x5JMLoWpr9E05ruIET4IGdlw2nIr/TcD8D6CMicOVpd2UYjsjTaKEHERSGOCDtFBOthOrbQcJRbrQPePTRrMVHyGisIZ4lM5bjBMG2h/jBLCMi87FRiMP5T5HLB05Tw3p3JSTCK7B0g/X5/xP8HhUIJyudTbRAoGACw9Fn9nM+6l9TAqJ5rllA/99rXTUUtMlylo4vxMyavlQx8YYcW8Iq57OMb1ZU52LNApdf5yTnJ8o75ao5wmYKWOfVBis70WoL7Wb1rFyBpSR4aqPor4Un1OCY85GOIxrBel4lu0jxHJfO+Kn7578JLOAHPVlW1xNSnl6hEIrY7s=";
    private final String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkUP4xIwHrcA9KkKZlDudkjKlc89JZxrRKHLJr1U6xOSZIMc5bOMutSc15iW6iNekBiKjg8sz7ycfs1P+2/S/uWWUO1R7QC4GkrLNw4vLjMjIj5vBVH+poCBgACzN4FOk1BPyMwk86aRTM64hcbV3Oowa6qoNQbE8P/FRt/naiE56NX2vXAjwktXqPF4ERtjwKdVbldtzQehHM+DZzegLyFprz8iTe2SVxExfL6P1zJVAm/fe60lzNWn4Y5VZiHwWyUifqEwDyATgHE2Yqz2sloCQGl9ZT0D1CWGDbzkU68XOWq26btjoeRyozHi9UopOpMUt821BF10+OeEBHTAxxQIDAQAB";
    private final String format = "json";
    private final String charset = "UTF-8";
    private final String sign_type = "RSA2";
    private final String returnUrl = "https://8.130.37.157:12581/alipay/return";
    private final String notifyUrl = "https://8.130.37.157:12581/alipay/notify";

    OrdersController ordersController = new OrdersController();
    private Long orders_id;

    @PostMapping("/pay")
    public String pay(@RequestBody Orders orders) {
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPublicKey, sign_type);
        AlipayTradeAppPayRequest alipayRequest = new AlipayTradeAppPayRequest();
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        alipayRequest.setReturnUrl(returnUrl);
        alipayRequest.setNotifyUrl(notifyUrl);

        ExtUserInfo extUserInfo = new ExtUserInfo();
//        extUserInfo.setCertType("IDENTITY_CARD");
//        extUserInfo.setCertNo("360723200210222017");
//        extUserInfo.setMinAge("21");
//        extUserInfo.setName(name);
        extUserInfo.setMobile(orders.getPhone());
        extUserInfo.setNeedCheckInfo("F");
        model.setExtUserInfo(extUserInfo);

        this.orders_id = orders.getId();
        model.setOutTradeNo(String.valueOf(orders_id));
        model.setTotalAmount(orders.getTotal());
        model.setSubject("ORDER");
        model.setBody("order");
        model.setProductCode("QUICK_MSECURITY_PAY");

        alipayRequest.setBizModel(model);

        String result = "";
        try {
            AlipayTradeAppPayResponse alipayResponse = alipayClient.sdkExecute(alipayRequest);
            result = alipayResponse.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
            throw new RuntimeException("failure");
        }
        return result;
    }

    @GetMapping("/return")
    public String returnPay() {
        return "success";
    }

    @PostMapping("/notify")
    public String notifyPay() {
        ordersController.updateState(this.orders_id, "PAID");
        return "success";
    }
}
